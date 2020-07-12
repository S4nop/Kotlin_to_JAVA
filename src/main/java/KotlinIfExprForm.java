import java.util.LinkedList;
import java.util.Queue;

class KotlinIfExprForm {
    String expr;
    Queue<String> contrBody = new LinkedList<>();

    public void setExpr(String s){
        expr = s;
    }

    public void addCtrlBody(String s){
        contrBody.add(s);
    }

    public String makeStr(){
        String out = "if(" + expr + ")";

        if(!contrBody.isEmpty())
            out += typeConv("{\n" + contrBody.poll() + "\n}\n");
        
        if(!contrBody.isEmpty()){
            out += "\nelse{\n" + contrBody.poll() + "\n}\n";
        }

        return out;
    }

    private String typeConv(String s){
        String tmpType = expr, tmpName = expr;
        if(tmpType.contains("instanceof")){
            tmpType = tmpType.split(" instanceof ")[1];
            if(tmpType.contains("&&")) tmpType = tmpType.split(" && ")[0];
            if(tmpType.contains("||")) tmpType = tmpType.split(" || ")[0];


            tmpName = tmpName.split(" instanceof ")[0];
            if(tmpName.contains("&&")) tmpName = tmpName.split(" && ")[1];
            if(tmpName.contains("||")) tmpName = tmpName.split(" || ")[1];
            s = s.replace(tmpName, "((" + tmpType + ")"+ tmpName + ")");

            tmpType = expr.split(" instanceof ")[1].replace(tmpName, "((" + tmpType + ")"+ tmpName + ")");
            expr = expr.split(" instanceof ")[0] + " instanceof " + tmpType;
        }
        return s;
    }
}