
class KotlinMultiVarDeclForm extends KotlinExprForm{
    
    @Override
    public String makeStr(){
        String rslt = "(" + childExpr.poll();
        for(int i = 0; i < childNum - 1; i++)
            rslt += (", " + childExpr.poll());
        return rslt;
    }
}