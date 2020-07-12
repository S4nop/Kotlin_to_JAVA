// Generated from KotlinParser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KotlinParser}.
 */
public interface KotlinParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KotlinParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(KotlinParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(KotlinParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#packages}.
	 * @param ctx the parse tree
	 */
	void enterPackages(KotlinParser.PackagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#packages}.
	 * @param ctx the parse tree
	 */
	void exitPackages(KotlinParser.PackagesContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(KotlinParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(KotlinParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(KotlinParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(KotlinParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunDecl(KotlinParser.FunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunDecl(KotlinParser.FunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#funParam}.
	 * @param ctx the parse tree
	 */
	void enterFunParam(KotlinParser.FunParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#funParam}.
	 * @param ctx the parse tree
	 */
	void exitFunParam(KotlinParser.FunParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#decFunParam}.
	 * @param ctx the parse tree
	 */
	void enterDecFunParam(KotlinParser.DecFunParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#decFunParam}.
	 * @param ctx the parse tree
	 */
	void exitDecFunParam(KotlinParser.DecFunParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#funBody}.
	 * @param ctx the parse tree
	 */
	void enterFunBody(KotlinParser.FunBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#funBody}.
	 * @param ctx the parse tree
	 */
	void exitFunBody(KotlinParser.FunBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KotlinParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KotlinParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(KotlinParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(KotlinParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(KotlinParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(KotlinParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#juncExpr}.
	 * @param ctx the parse tree
	 */
	void enterJuncExpr(KotlinParser.JuncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#juncExpr}.
	 * @param ctx the parse tree
	 */
	void exitJuncExpr(KotlinParser.JuncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(KotlinParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(KotlinParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(KotlinParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(KotlinParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#iExpr}.
	 * @param ctx the parse tree
	 */
	void enterIExpr(KotlinParser.IExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#iExpr}.
	 * @param ctx the parse tree
	 */
	void exitIExpr(KotlinParser.IExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#qcolExpr}.
	 * @param ctx the parse tree
	 */
	void enterQcolExpr(KotlinParser.QcolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#qcolExpr}.
	 * @param ctx the parse tree
	 */
	void exitQcolExpr(KotlinParser.QcolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#rangeExpr}.
	 * @param ctx the parse tree
	 */
	void enterRangeExpr(KotlinParser.RangeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#rangeExpr}.
	 * @param ctx the parse tree
	 */
	void exitRangeExpr(KotlinParser.RangeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#additExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditExpr(KotlinParser.AdditExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#additExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditExpr(KotlinParser.AdditExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(KotlinParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(KotlinParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#idxExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdxExpr(KotlinParser.IdxExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#idxExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdxExpr(KotlinParser.IdxExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#prefExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefExpr(KotlinParser.PrefExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#prefExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefExpr(KotlinParser.PrefExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#targ}.
	 * @param ctx the parse tree
	 */
	void enterTarg(KotlinParser.TargContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#targ}.
	 * @param ctx the parse tree
	 */
	void exitTarg(KotlinParser.TargContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#postUExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostUExpr(KotlinParser.PostUExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#postUExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostUExpr(KotlinParser.PostUExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#callExpr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(KotlinParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#callExpr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(KotlinParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#dotExpr}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(KotlinParser.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#dotExpr}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(KotlinParser.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#lamdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLamdaBody(KotlinParser.LamdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#lamdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLamdaBody(KotlinParser.LamdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(KotlinParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(KotlinParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#rangeOp}.
	 * @param ctx the parse tree
	 */
	void enterRangeOp(KotlinParser.RangeOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#rangeOp}.
	 * @param ctx the parse tree
	 */
	void exitRangeOp(KotlinParser.RangeOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void enterEqOp(KotlinParser.EqOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void exitEqOp(KotlinParser.EqOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(KotlinParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(KotlinParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#lOp}.
	 * @param ctx the parse tree
	 */
	void enterLOp(KotlinParser.LOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#lOp}.
	 * @param ctx the parse tree
	 */
	void exitLOp(KotlinParser.LOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#isOp}.
	 * @param ctx the parse tree
	 */
	void enterIsOp(KotlinParser.IsOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#isOp}.
	 * @param ctx the parse tree
	 */
	void exitIsOp(KotlinParser.IsOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#inOp}.
	 * @param ctx the parse tree
	 */
	void enterInOp(KotlinParser.InOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#inOp}.
	 * @param ctx the parse tree
	 */
	void exitInOp(KotlinParser.InOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#additOp}.
	 * @param ctx the parse tree
	 */
	void enterAdditOp(KotlinParser.AdditOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#additOp}.
	 * @param ctx the parse tree
	 */
	void exitAdditOp(KotlinParser.AdditOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(KotlinParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(KotlinParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#asOp}.
	 * @param ctx the parse tree
	 */
	void enterAsOp(KotlinParser.AsOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#asOp}.
	 * @param ctx the parse tree
	 */
	void exitAsOp(KotlinParser.AsOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#prefixUOp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixUOp(KotlinParser.PrefixUOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#prefixUOp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixUOp(KotlinParser.PrefixUOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#postfixUOp}.
	 * @param ctx the parse tree
	 */
	void enterPostfixUOp(KotlinParser.PostfixUOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#postfixUOp}.
	 * @param ctx the parse tree
	 */
	void exitPostfixUOp(KotlinParser.PostfixUOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(KotlinParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(KotlinParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(KotlinParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(KotlinParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classSpecf}.
	 * @param ctx the parse tree
	 */
	void enterClassSpecf(KotlinParser.ClassSpecfContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classSpecf}.
	 * @param ctx the parse tree
	 */
	void exitClassSpecf(KotlinParser.ClassSpecfContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classParams}.
	 * @param ctx the parse tree
	 */
	void enterClassParams(KotlinParser.ClassParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classParams}.
	 * @param ctx the parse tree
	 */
	void exitClassParams(KotlinParser.ClassParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classParam}.
	 * @param ctx the parse tree
	 */
	void enterClassParam(KotlinParser.ClassParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classParam}.
	 * @param ctx the parse tree
	 */
	void exitClassParam(KotlinParser.ClassParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#classbody}.
	 * @param ctx the parse tree
	 */
	void enterClassbody(KotlinParser.ClassbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#classbody}.
	 * @param ctx the parse tree
	 */
	void exitClassbody(KotlinParser.ClassbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#valDecl}.
	 * @param ctx the parse tree
	 */
	void enterValDecl(KotlinParser.ValDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#valDecl}.
	 * @param ctx the parse tree
	 */
	void exitValDecl(KotlinParser.ValDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#multiValDecl}.
	 * @param ctx the parse tree
	 */
	void enterMultiValDecl(KotlinParser.MultiValDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#multiValDecl}.
	 * @param ctx the parse tree
	 */
	void exitMultiValDecl(KotlinParser.MultiValDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#assn}.
	 * @param ctx the parse tree
	 */
	void enterAssn(KotlinParser.AssnContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#assn}.
	 * @param ctx the parse tree
	 */
	void exitAssn(KotlinParser.AssnContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(KotlinParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(KotlinParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#cngLine}.
	 * @param ctx the parse tree
	 */
	void enterCngLine(KotlinParser.CngLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#cngLine}.
	 * @param ctx the parse tree
	 */
	void exitCngLine(KotlinParser.CngLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#strings}.
	 * @param ctx the parse tree
	 */
	void enterStrings(KotlinParser.StringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#strings}.
	 * @param ctx the parse tree
	 */
	void exitStrings(KotlinParser.StringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#texts}.
	 * @param ctx the parse tree
	 */
	void enterTexts(KotlinParser.TextsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#texts}.
	 * @param ctx the parse tree
	 */
	void exitTexts(KotlinParser.TextsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#strExpr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(KotlinParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#strExpr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(KotlinParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(KotlinParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(KotlinParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#contrBody}.
	 * @param ctx the parse tree
	 */
	void enterContrBody(KotlinParser.ContrBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#contrBody}.
	 * @param ctx the parse tree
	 */
	void exitContrBody(KotlinParser.ContrBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#jumpExpr}.
	 * @param ctx the parse tree
	 */
	void enterJumpExpr(KotlinParser.JumpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#jumpExpr}.
	 * @param ctx the parse tree
	 */
	void exitJumpExpr(KotlinParser.JumpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#loopExpr}.
	 * @param ctx the parse tree
	 */
	void enterLoopExpr(KotlinParser.LoopExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#loopExpr}.
	 * @param ctx the parse tree
	 */
	void exitLoopExpr(KotlinParser.LoopExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#forExpr}.
	 * @param ctx the parse tree
	 */
	void enterForExpr(KotlinParser.ForExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#forExpr}.
	 * @param ctx the parse tree
	 */
	void exitForExpr(KotlinParser.ForExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#whileExpr}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpr(KotlinParser.WhileExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#whileExpr}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpr(KotlinParser.WhileExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#doExpr}.
	 * @param ctx the parse tree
	 */
	void enterDoExpr(KotlinParser.DoExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#doExpr}.
	 * @param ctx the parse tree
	 */
	void exitDoExpr(KotlinParser.DoExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#whenExpr}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpr(KotlinParser.WhenExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#whenExpr}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpr(KotlinParser.WhenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#arrExpr}.
	 * @param ctx the parse tree
	 */
	void enterArrExpr(KotlinParser.ArrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#arrExpr}.
	 * @param ctx the parse tree
	 */
	void exitArrExpr(KotlinParser.ArrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#testExpr}.
	 * @param ctx the parse tree
	 */
	void enterTestExpr(KotlinParser.TestExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#testExpr}.
	 * @param ctx the parse tree
	 */
	void exitTestExpr(KotlinParser.TestExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#inp}.
	 * @param ctx the parse tree
	 */
	void enterInp(KotlinParser.InpContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#inp}.
	 * @param ctx the parse tree
	 */
	void exitInp(KotlinParser.InpContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#idNum}.
	 * @param ctx the parse tree
	 */
	void enterIdNum(KotlinParser.IdNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#idNum}.
	 * @param ctx the parse tree
	 */
	void exitIdNum(KotlinParser.IdNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinParser#modLit}.
	 * @param ctx the parse tree
	 */
	void enterModLit(KotlinParser.ModLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinParser#modLit}.
	 * @param ctx the parse tree
	 */
	void exitModLit(KotlinParser.ModLitContext ctx);
}