import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Stack;

import org.antlr.v4.runtime.tree.*;

class KotlinListener extends KotlinParserBaseListener {
    KotlinIDStackJob stJob;
	Stack<Integer> modStack;
	String className = "Main";
	String out = "";
	File file;
	PrintWriter pw;
	public void setClassName(String s){
		className = s;
		file = new File(s);
		try{
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		} catch(Exception e){
			System.out.println("Failed to write file");
		}
	}


	@Override public void enterProg(KotlinParser.ProgContext ctx) { 
        stJob = new KotlinIDStackJob();
		modStack = new Stack<>();
		modStack.push(999);
        stJob.init();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitProg(KotlinParser.ProgContext ctx) { 

		 pw.println(KotlinExprStacks.stateStack.pop().pop() + "\n}\n");
		 pw.close();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterPackages(KotlinParser.PackagesContext ctx) { 
        stJob.addStack();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitPackages(KotlinParser.PackagesContext ctx) { 
        //pw.println(ctx.getText());
        Stack<String> idStk = stJob.getIDList();
        pw.write("package " + idStk.peek()); 

        if(ctx.DOT() != null) pw.write(".*");
        if(ctx.SEMICOLON() != null) pw.println(";");
        stJob.removeStack();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterImports(KotlinParser.ImportsContext ctx) { 
        stJob.addStack();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitImports(KotlinParser.ImportsContext ctx) { 
		Stack<String> idStk = stJob.getIDList();
		// if(!ctx.IMPORT().isEmpty()){
		// 	while(!idStk.isEmpty()){
		// 		pw.write("import " + idStk.pop()); 
	
		// 		if(ctx.DOT() != null) pw.write(".*");
		// 		if(ctx.SEMICOLON() != null) pw.println(";");
		// 	}
		// }
		stJob.removeStack();
		
		pw.println("public class " + (className.contains(".") ? className.split("\\.")[0] : className) + "{\n");

    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterId(KotlinParser.IdContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitId(KotlinParser.IdContext ctx) { 
        stJob.addIDtoStack(ctx.getText());
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterFunDecl(KotlinParser.FunDeclContext ctx) { 
		modStack.push(36);
		stJob.addStack();
		KotlinExprStacks.fundeclStack.push(new KotlinFunDeclForm());
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitFunDecl(KotlinParser.FunDeclContext ctx) { 
		modStack.pop();
		KotlinExprStacks.fundeclStack.peek().setId(ctx.id().getText());
		if(ctx.type() != null && !ctx.type().isEmpty())
			KotlinExprStacks.fundeclStack.peek().setType(KotlinUtils.cngType(ctx.type().getText()));
		else 
			KotlinExprStacks.fundeclStack.peek().setType("void");
		
		if(modStack.peek() == 16)
			KotlinExprStacks.declStack.peek().push("");
			pw.println(KotlinExprStacks.fundeclStack.peek().makeStr());
		stJob.removeStack();
        
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterFunParam(KotlinParser.FunParamContext ctx) { 
		KotlinExprStacks.funPrmStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitFunParam(KotlinParser.FunParamContext ctx) { 
		String out = "";
		for(String s : KotlinExprStacks.funPrmStack.peek())
			out += s + ", ";
		
		if(out.length() > 1)
			out = out.substring(0, out.length() - 2);
		
		KotlinExprStacks.fundeclStack.peek().setFunParam("(" + out + ")");
	}

	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterDecFunParam(KotlinParser.DecFunParamContext ctx) { 
		stJob.addStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitDecFunParam(KotlinParser.DecFunParamContext ctx) { 
		String id = ctx.id().getText();
		String tp = "Object";
		if(ctx.COLON() != null){
			tp = ctx.type().getText();
			tp = KotlinUtils.cngType(tp);
		}
		KotlinExprStacks.funPrmStack.peek().push(tp + " " + id);
		stJob.removeStack();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterFunBody(KotlinParser.FunBodyContext ctx) { 
		modStack.push(KotlinConst.FUNBODY);
		KotlinExprStacks.funbodyStack.push(new Stack<String>());
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitFunBody(KotlinParser.FunBodyContext ctx) { 
		modStack.pop();
		if(ctx.ASSIGN() == null)
			KotlinExprStacks.fundeclStack.peek().setFunBody("{\n" + KotlinExprStacks.funbodyStack.peek().pop() + "\n}");
		else{
			KotlinExprStacks.fundeclStack.peek().setFunBody("{\n return " + KotlinExprStacks.funbodyStack.peek().pop() + ";\n}");
			KotlinExprStacks.fundeclStack.peek().setAssn(true);
		}

    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterType(KotlinParser.TypeContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitType(KotlinParser.TypeContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterBlock(KotlinParser.BlockContext ctx) { 
		modStack.push(34);
		KotlinExprStacks.blockStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitBlock(KotlinParser.BlockContext ctx) { 
		modStack.pop();
		String out = "";

		for(String st : KotlinExprStacks.blockStack.peek())
			out += st + "\n";

		if(out.length() > 1)
			out = out.substring(0, out.length() - 1);

		if(modStack.peek() == 32)
			KotlinExprStacks.funbodyStack.peek().push(out);
		else if(modStack.peek() == 23){
			KotlinExprStacks.ctrlbodyStack.peek().push(out);
		}
		KotlinExprStacks.blockStack.pop();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterExpr(KotlinParser.ExprContext ctx) { 
		modStack.add(0);
		KotlinExprStacks.exprStack.push(new Stack<String>());
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitExpr(KotlinParser.ExprContext ctx) { 
		modStack.pop();
		int mod = modStack.peek();
		String pop = KotlinExprStacks.exprStack.peek().pop();
		if(mod == KotlinConst.VALDECL)
			KotlinExprStacks.valStack.peek().push(pop);
		else if(mod == KotlinConst.ASSN)
			KotlinExprStacks.assnStack.peek().push(pop);
		else if(mod == KotlinConst.STATE)
			KotlinExprStacks.stateStack.peek().push(pop.contains("}\n") ? pop : pop + ";");
		else if(mod == KotlinConst.JUMPEXPR)
			KotlinExprStacks.jumpStack.peek().push(pop);
		else if(mod == 13)
			KotlinExprStacks.callStack.peek().addChild(pop);
		else if(mod == 32)
			KotlinExprStacks.funbodyStack.peek().push(pop);
		else if(mod == 34)
			KotlinExprStacks.blockStack.peek().push(pop.contains("}\n") ? pop : pop + ";");
		else if(mod == 23)
			KotlinExprStacks.ctrlbodyStack.peek().push(pop);
		else if(mod == 22)
			KotlinExprStacks.ifStack.peek().setExpr(pop);// else
		else if(mod == KotlinConst.FOREXPR)
			KotlinExprStacks.forStack.peek().setExpr(pop);
		else if(mod == 27)
			KotlinExprStacks.whileStack.peek().setExpr(pop);
		// 	pw.println(KotlinExprStacks.exprStack.peek());
		KotlinExprStacks.exprStack.pop();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterJuncExpr(KotlinParser.JuncExprContext ctx) { 
		modStack.add(KotlinConst.JUNCEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(KotlinParser.LOpContext l : ctx.lOp()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.juncStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitJuncExpr(KotlinParser.JuncExprContext ctx) { 
		modStack.pop();
		KotlinExprStacks.exprStack.peek().push(KotlinExprStacks.juncStack.pop().makeStr());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterEqExpr(KotlinParser.EqExprContext ctx) { 
		modStack.add(KotlinConst.EQEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(KotlinParser.EqOpContext l : ctx.eqOp()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.eqStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitEqExpr(KotlinParser.EqExprContext ctx) { 
		modStack.pop();

		if(modStack.peek() == 1){
			KotlinExprStacks.juncStack.peek().addChild(
				KotlinExprStacks.eqStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterCompExpr(KotlinParser.CompExprContext ctx) { 
		modStack.add(KotlinConst.COMPEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(KotlinParser.CompOpContext l : ctx.compOp()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.compStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitCompExpr(KotlinParser.CompExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 2){
			KotlinExprStacks.eqStack.peek().addChild(
				KotlinExprStacks.compStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterIExpr(KotlinParser.IExprContext ctx) { 
		modStack.add(KotlinConst.IEXPR);
		KotlinExprStacks.iStack.push(new KotlinIExprForm());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitIExpr(KotlinParser.IExprContext ctx) { 
		modStack.pop();
		if(ctx.isOp() != null && !ctx.isOp().isEmpty()){
			KotlinExprStacks.iStack.peek().setOp(ctx.isOp().getText());
			KotlinExprStacks.iStack.peek().setType(KotlinUtils.cngType(ctx.type().getText()));
		}
		else if(ctx.inOp() != null && !ctx.inOp().isEmpty())
			KotlinExprStacks.iStack.peek().setOp(ctx.inOp().getText());
		
		if(modStack.peek() == 3){
			KotlinExprStacks.compStack.peek().addChild(
				KotlinExprStacks.iStack.peek().makeStr());
		}
		KotlinExprStacks.iStack.pop();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterQcolExpr(KotlinParser.QcolExprContext ctx) { 
		modStack.add(KotlinConst.QCOLEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(TerminalNode l : ctx.QUECOLON()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.qcolStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitQcolExpr(KotlinParser.QcolExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 4){
			KotlinExprStacks.iStack.peek().addQCol(
				KotlinExprStacks.qcolStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterRangeExpr(KotlinParser.RangeExprContext ctx) { 
		modStack.add(KotlinConst.RANGEEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(KotlinParser.RangeOpContext l : ctx.rangeOp()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.rangeStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitRangeExpr(KotlinParser.RangeExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 5){
			KotlinExprStacks.qcolStack.peek().addChild(
				KotlinExprStacks.rangeStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterAdditExpr(KotlinParser.AdditExprContext ctx) { 
		modStack.add(KotlinConst.ADDITEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(KotlinParser.AdditOpContext l : ctx.additOp()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.additStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitAdditExpr(KotlinParser.AdditExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 6){
			KotlinExprStacks.rangeStack.peek().addChild(
				KotlinExprStacks.additStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterMultExpr(KotlinParser.MultExprContext ctx) { 
		modStack.add(KotlinConst.MULTEXPR);
		KotlinExprForm kef = new KotlinExprForm();
		for(KotlinParser.MultOpContext l : ctx.multOp()){
			kef.addExprs(l.getText());
		}
		KotlinExprStacks.multStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitMultExpr(KotlinParser.MultExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 7){
			KotlinExprStacks.additStack.peek().addChild(
				KotlinExprStacks.multStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterIdxExpr(KotlinParser.IdxExprContext ctx) { 
		stJob.addStack();
		modStack.add(KotlinConst.IDXEXPR);
		KotlinIdxExprForm ief = new KotlinIdxExprForm();
		for(TerminalNode l : ctx.COMMA()){
			ief.addExprs(l.getText());
		}
		KotlinExprStacks.idxStack.push(ief);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitIdxExpr(KotlinParser.IdxExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 12){
			KotlinExprStacks.postUStack.peek().addChild(
				stJob.getIDList().pop() + KotlinExprStacks.idxStack.pop().makeStr());
		}
		stJob.removeStack();
	}
	/*
	 *
	 * 
	 */
	@Override public void enterPrefExpr(KotlinParser.PrefExprContext ctx) { 
		modStack.add(KotlinConst.PREFEXPR);
		KotlinExprStacks.prefStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitPrefExpr(KotlinParser.PrefExprContext ctx) { 
		modStack.pop();
		String out = "";
		for(KotlinParser.PrefixUOpContext l : ctx.prefixUOp()){
			out+=l.getText() + " ";
		}
		if(modStack.peek() == 8){
			KotlinExprStacks.multStack.peek().addChild(
				out + KotlinExprStacks.prefStack.pop().pop());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterTarg(KotlinParser.TargContext ctx) { 
		stJob.addStack();
		modStack.add(KotlinConst.TARG);
		KotlinExprForm kef = new KotlinExprForm();
		if(ctx.NUM() != null) kef.addChild(ctx.NUM().getText());
		else if(ctx.id() != null && !ctx.id().isEmpty()){
			kef.addChild(ctx.id().getText() + 
			(ctx.postfixUOp() != null && !ctx.postfixUOp().isEmpty() ? " " + ctx.postfixUOp().getText() : ""));
		}
		KotlinExprStacks.targStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitTarg(KotlinParser.TargContext ctx) { 
		modStack.pop();
		String out = KotlinExprStacks.targStack.pop().makeStr();
		if(ctx.id() != null && out.contains(".")) out += "()";
		if(out.contains(".") && out.split("\\.")[1].equals("size()"))
			out = out.split("\\.")[0] + ".length";
		if(modStack.peek() == 10){
			KotlinExprStacks.prefStack.peek().push(
				out);
		}
		stJob.removeStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterPostUExpr(KotlinParser.PostUExprContext ctx) { 
		modStack.add(KotlinConst.POSTUEXPR);
		stJob.addStack();
		KotlinExprForm kef = new KotlinExprForm();
		KotlinExprStacks.postUStack.push(kef);
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitPostUExpr(KotlinParser.PostUExprContext ctx) { 
		String rslt = KotlinExprStacks.postUStack.pop().makeStr();
		modStack.pop();
		if(modStack.peek() == KotlinConst.TARG){
			if(ctx.postfixUOp()!= null && !ctx.postfixUOp().isEmpty())
				rslt += ctx.postfixUOp();
			if(ctx.LPAREN() != null)
				rslt = "(" + rslt + ")";
			KotlinExprStacks.targStack.peek().addChild(rslt);
		}
		stJob.removeStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterCallExpr(KotlinParser.CallExprContext ctx) { 
		modStack.push(13);
		stJob.addStack();
		KotlinExprStacks.callStack.push(new KotlinCallExprForm());
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitCallExpr(KotlinParser.CallExprContext ctx) { 
		modStack.pop();
		if(ctx.id() != null && !ctx.id().isEmpty())
			KotlinExprStacks.callStack.peek().setCallee(ctx.id().getText());

		if(modStack.peek() == KotlinConst.POSTUEXPR)
			KotlinExprStacks.postUStack.peek().addChild(KotlinExprStacks.callStack.peek().makeStr());
		else if(modStack.peek() == KotlinConst.DOTEXPR)
			KotlinExprStacks.dotStack.peek().addChild(KotlinExprStacks.callStack.peek().makeStr());
		stJob.removeStack();
		KotlinExprStacks.callStack.pop();
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterDotExpr(KotlinParser.DotExprContext ctx) { 
		modStack.push(14);
		stJob.addStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitDotExpr(KotlinParser.DotExprContext ctx) { 
		modStack.pop();
		String out = stJob.getIDList().pop();
		out += KotlinExprStacks.dotStack.pop().makeStr();

		if(modStack.peek() == 12)
			KotlinExprStacks.postUStack.peek().addChild(out);
		else if(modStack.peek() == 13)
			KotlinExprStacks.callStack.peek().setCallee(out);
		stJob.removeStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterLamdaBody(KotlinParser.LamdaBodyContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitLamdaBody(KotlinParser.LamdaBodyContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterAssignOp(KotlinParser.AssignOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitAssignOp(KotlinParser.AssignOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterEqOp(KotlinParser.EqOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitEqOp(KotlinParser.EqOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterCompOp(KotlinParser.CompOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitCompOp(KotlinParser.CompOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterIsOp(KotlinParser.IsOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitIsOp(KotlinParser.IsOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterInOp(KotlinParser.InOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitInOp(KotlinParser.InOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterAdditOp(KotlinParser.AdditOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitAdditOp(KotlinParser.AdditOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterMultOp(KotlinParser.MultOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitMultOp(KotlinParser.MultOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterAsOp(KotlinParser.AsOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitAsOp(KotlinParser.AsOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterPrefixUOp(KotlinParser.PrefixUOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitPrefixUOp(KotlinParser.PrefixUOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterPostfixUOp(KotlinParser.PostfixUOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitPostfixUOp(KotlinParser.PostfixUOpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterDecl(KotlinParser.DeclContext ctx) { 
		modStack.push(KotlinConst.DECL);
		KotlinExprStacks.declStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitDecl(KotlinParser.DeclContext ctx) { 
		modStack.pop();
		String out = "";
		for(int i = 0; i < ctx.modLit().size(); i++){
			out += (ctx.modLit(i).getText() + " ");
		}
		if(modStack.peek() == KotlinConst.STATE)
			KotlinExprStacks.stateStack.peek().push(out + KotlinExprStacks.declStack.pop().pop());
	}
	/**
	 * 
	 *	
	 * 
	 */
	@Override public void enterClassDecl(KotlinParser.ClassDeclContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitClassDecl(KotlinParser.ClassDeclContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterClassSpecf(KotlinParser.ClassSpecfContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitClassSpecf(KotlinParser.ClassSpecfContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterClassParams(KotlinParser.ClassParamsContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitClassParams(KotlinParser.ClassParamsContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterClassParam(KotlinParser.ClassParamContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitClassParam(KotlinParser.ClassParamContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterClassbody(KotlinParser.ClassbodyContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitClassbody(KotlinParser.ClassbodyContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterValDecl(KotlinParser.ValDeclContext ctx) { 
		modStack.add(KotlinConst.VALDECL);
		KotlinExprStacks.valStack.push(new Stack<String>());
		stJob.addStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitValDecl(KotlinParser.ValDeclContext ctx) { 
		modStack.pop();
		String rslt = "";
		String type = "var";
		String assn = "";
		if(!ctx.ASSIGN().isEmpty()) {
			assn = KotlinExprStacks.valStack.pop().pop();
			type = KotlinUtils.chkType(assn);
			if(!type.contains("[]"))
				assn = " = " + "(" + type + ")" + assn;
			else
				assn = " = " + KotlinUtils.cngListOf(assn);
		}
		else if(ctx.type() != null && !ctx.type().isEmpty()) type = KotlinUtils.cngType(ctx.type().getText());
			
		rslt = type + " " + ctx.id().getText() + assn;
		
		int mod = modStack.peek();
		if(mod == KotlinConst.DECL)
			KotlinExprStacks.declStack.peek().push(rslt + ";");
		else if(mod == KotlinConst.IFEXPR)
			KotlinExprStacks.forStack.peek().setVal(rslt);
		stJob.removeStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterMultiValDecl(KotlinParser.MultiValDeclContext ctx) { 
		modStack.add(KotlinConst.MULTIVALDECL);
		KotlinExprStacks.multivalStack.push(new KotlinMultiVarDeclForm());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitMultiValDecl(KotlinParser.MultiValDeclContext ctx) { 
		modStack.pop();
		KotlinExprStacks.multivalStack.pop();

	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterAssn(KotlinParser.AssnContext ctx) { 
		modStack.push(KotlinConst.ASSN);
		stJob.addStack();
		KotlinExprStacks.assnStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitAssn(KotlinParser.AssnContext ctx) { 
		modStack.pop();
		KotlinExprStacks.stateStack.peek().push(ctx.id().getText() + " " + ctx.assignOp().getText() + " " + KotlinExprStacks.assnStack.pop().pop() + ";");
		stJob.removeStack();
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterState(KotlinParser.StateContext ctx) { 
		modStack.push(KotlinConst.STATE);
		KotlinExprStacks.stateStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitState(KotlinParser.StateContext ctx) { 
		modStack.pop();

		if(modStack.peek() == 34 && KotlinExprStacks.stateStack.peek().peek().length() > 0) {
			KotlinExprStacks.blockStack.peek().push(KotlinExprStacks.stateStack.pop().pop());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterCngLine(KotlinParser.CngLineContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitCngLine(KotlinParser.CngLineContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterStrings(KotlinParser.StringsContext ctx) { 
		int mod = modStack.peek();
		if(mod == KotlinConst.TARG)
			KotlinExprStacks.targStack.peek().addChild(ctx.getText());
		else if(mod == KotlinConst.EXPR)
			KotlinExprStacks.exprStack.peek().push(ctx.getText());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitStrings(KotlinParser.StringsContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterTexts(KotlinParser.TextsContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitTexts(KotlinParser.TextsContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterStrExpr(KotlinParser.StrExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitStrExpr(KotlinParser.StrExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterIfExpr(KotlinParser.IfExprContext ctx) { 
		modStack.push(22);
		KotlinExprStacks.ifStack.push(new KotlinIfExprForm());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitIfExpr(KotlinParser.IfExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 12){
			KotlinExprStacks.postUStack.peek().addChild(KotlinExprStacks.ifStack.pop().makeStr());
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterContrBody(KotlinParser.ContrBodyContext ctx) { 
		modStack.push(23);
		KotlinExprStacks.ctrlbodyStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitContrBody(KotlinParser.ContrBodyContext ctx) { 
		modStack.pop();
		if(modStack.peek() == 22){
			KotlinExprStacks.ifStack.peek().addCtrlBody(KotlinExprStacks.ctrlbodyStack.pop().pop());
		}
		else if(modStack.peek() == KotlinConst.FOREXPR)
			KotlinExprStacks.forStack.peek().setCtrlBody(KotlinExprStacks.ctrlbodyStack.pop().pop());
		else if(modStack.peek() == 27)
			KotlinExprStacks.whileStack.peek().setCtrlBody(KotlinExprStacks.ctrlbodyStack.pop().pop());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterJumpExpr(KotlinParser.JumpExprContext ctx) { 
		modStack.push(KotlinConst.JUMPEXPR);
		KotlinExprStacks.jumpStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitJumpExpr(KotlinParser.JumpExprContext ctx) { 
		modStack.pop();
		if(modStack.peek() == KotlinConst.POSTUEXPR){
			if(ctx.CONTINUE() != null) KotlinExprStacks.postUStack.peek().addChild("continue");
			else if(ctx.BREAK() != null) KotlinExprStacks.postUStack.peek().addChild("break");
			else if(ctx.THROW() != null) KotlinExprStacks.postUStack.peek().addChild(
				"throw " + KotlinExprStacks.jumpStack.pop().pop());
			else{
				KotlinExprStacks.postUStack.peek().addChild(
				"return" + (KotlinExprStacks.jumpStack.isEmpty() ? "" : " " + KotlinExprStacks.jumpStack.pop().pop()));
			}
		}
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterLoopExpr(KotlinParser.LoopExprContext ctx) { 
		modStack.push(25);
		KotlinExprStacks.loopStack.push(new Stack<String>());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitLoopExpr(KotlinParser.LoopExprContext ctx) { 
		modStack.pop();
		KotlinExprStacks.postUStack.peek().addChild(KotlinExprStacks.loopStack.pop().pop());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterForExpr(KotlinParser.ForExprContext ctx) { 
		stJob.addStack();
		modStack.push(26);
		KotlinExprStacks.forStack.add(new KotlinForExprForm());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitForExpr(KotlinParser.ForExprContext ctx) { 
		modStack.pop();
		stJob.removeStack();
		if(ctx.STEP() != null)
			KotlinExprStacks.forStack.peek().setSIdNum(ctx.idNum().getText());

		KotlinExprStacks.forStack.peek().setVal(ctx.id().getText());
		KotlinExprStacks.loopStack.peek().push(KotlinExprStacks.forStack.pop().makeStr());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterWhileExpr(KotlinParser.WhileExprContext ctx) { 
		modStack.push(27);
		stJob.addStack();
		KotlinExprStacks.whileStack.add(new KotlinWhileExprForm());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitWhileExpr(KotlinParser.WhileExprContext ctx) { 
		modStack.pop();
		stJob.removeStack();
		KotlinExprStacks.loopStack.peek().push(KotlinExprStacks.whileStack.pop().makeStr());
	}
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterDoExpr(KotlinParser.DoExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitDoExpr(KotlinParser.DoExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterWhenExpr(KotlinParser.WhenExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitWhenExpr(KotlinParser.WhenExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterArrExpr(KotlinParser.ArrExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitArrExpr(KotlinParser.ArrExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterTestExpr(KotlinParser.TestExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitTestExpr(KotlinParser.TestExprContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterInp(KotlinParser.InpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitInp(KotlinParser.InpContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void enterModLit(KotlinParser.ModLitContext ctx) { }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void exitModLit(KotlinParser.ModLitContext ctx) { }

	
	@Override public void visitTerminal(TerminalNode node) { 
        //pw.println("Node : \n" + node.getText());
    }
	/**
	 * 
	 *
	 * 
	 */
	@Override public void visitErrorNode(ErrorNode node) { }

}
