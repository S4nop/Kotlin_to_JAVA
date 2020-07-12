
class KotlinPrefExprForm extends KotlinExprForm{
    String targ;

    public void setTarg(String targ){
        this.targ = targ;
    }

    @Override
    public String makeStr(){
        String rslt = "";
        for(String op : childExpr){
            rslt += (op + " ");
        }
        rslt += targ;
        return rslt;
    }
}