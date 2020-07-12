
class KotlinCallExprForm extends KotlinExprForm{
    String callee;

    public void setCallee(String cl){
        callee = cl;
    }

    @Override
    public String makeStr(){
        cngCallee();
        String rslt = callee + (childExpr.isEmpty() ? "(" : "(" + childExpr.poll());
        for(int i = 0; i < childNum - 1; i++){
            rslt += (", " + childExpr.poll());
        }
        return rslt + ")";
    }

    public void cngCallee(){
        if(callee.equals("println")) callee = "System.out.println";
        if(callee.equals("print")) callee = "System.out.print";
        if(callee.equals("parseInt")) callee = "Integer.parseInt";
    }
}