
class KotlinForExprForm{
    String val;
    String expr;
    String dIdNum, sIdNum;
    String ctrlBody;

    public void setCtrlBody(String s){
        ctrlBody = s;
    }

    public void setVal(String s){
        val = s;
    }

    public void setExpr(String s){
        if(s.contains("downTo")){
            expr = s.split(" downTo ")[0];
            dIdNum = s.split(" downTo ")[1];
        }
        else expr = s;
        
    }

    public void setDIdNum(String s){
        dIdNum = s;
    }
    
    public void setSIdNum(String s){
        sIdNum = s;
    }

    public String makeStr(){
        String out;
        try{
            String tmp = ( " = "  + Integer.parseInt(expr) + "; ");
            out = "for(Integer " + val + tmp;
            if(dIdNum != null) out += (val + " >= " + dIdNum + "; ");
            if(sIdNum != null) out += (val + " = " + val + " - " + sIdNum);
        } catch(Exception e){
            if(expr.contains("..")){
                out = ( "for(Integer " + val + " = " + expr.split(" .. ")[0] + "; " + val + " <= " + expr.split(" .. ")[1] + "; " + val + "++");
            }
            else out = ( "for(String " + val + " : " + (expr.contains(".indices()") ? expr.split("\\.")[0] : expr));
        }
        return out + ")\n" + (ctrlBody == null ? "" : "{\n" + ctrlBody + "\n}\n" );
    }
}