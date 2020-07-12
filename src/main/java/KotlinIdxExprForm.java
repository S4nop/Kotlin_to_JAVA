
class KotlinIdxExprForm extends KotlinExprForm{
    String id;

    public void setID(String id){
        this.id = id;
    }

    @Override
    public String makeStr(){
        String rslt = id + "[";
        if(!childExpr.isEmpty())
            rslt += childExpr.poll();
        
        for(int i = 0; i < childNum - 1; i++){
            rslt += ("," + childExpr.poll());
        }

        rslt += "]";
        return rslt;
    }
}