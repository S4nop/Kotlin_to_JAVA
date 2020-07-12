class KotlinWhileExprForm{
    String expr;
    String ctrlBody;
    
    public void setCtrlBody(String s){
        ctrlBody = s;
    }

    public void setExpr(String s){
        expr = s;        
    }

    public String makeStr(){
        return "while(" + expr + "){" + ctrlBody +"\n}\n";
    }
}