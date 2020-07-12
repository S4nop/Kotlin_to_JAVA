import java.util.LinkedList;
import java.util.Queue;

class KotlinExprForm {
    Queue<String> childExpr;
    Queue<String> ops;
    int childNum;
    KotlinExprForm(){
        childExpr = new LinkedList<>();
        ops = new LinkedList<>();
        childNum = 0;
    }

    public void addChild(String child){
        childExpr.add(child);
        childNum++;
    }

    public void addExprs(String op){
        ops.add(op);
    }

    public String makeStr(){
        String rslt = childExpr.poll();
        for(int i = 0; i < childNum - 1; i++){
            rslt += (" " + ops.poll() + " " + childExpr.poll());
        }
        return rslt;
    }
}