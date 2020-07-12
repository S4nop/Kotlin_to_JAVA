import java.util.LinkedList;
import java.util.Queue;

class KotlinIExprForm {
    String op = "";
    Queue<String> qcol = new LinkedList<>();
    String type;

    public void setOp(String s){
        op = s;
    }

    public void addQCol(String s){
        qcol.add(s);
    }

    public void setType(String s){
        type = s;
    }

    public String makeStr(){
        String out = qcol.poll();
        if(!op.equals("")){
            if(op.equals("nis") || op.equals("is")){
                out += " instanceof " + type;
            }
            else{
                for(String s : qcol){
                    if(s.contains(" .. ")){
                        return (s.split(" \\.\\. ")[0] + " <= " + out + " && " + s.split(" \\.\\. ")[1] + " >= " + out);
                    }
                    else out = s + ".contains(" + out + ")";
                }
            }
            if(op.startsWith("n")) out = "!" + out;
        }
        return out;
    }
}