import java.util.ArrayList;
import java.util.Stack;

class KotlinIDStackJob {
    ArrayList<Stack<String>> idStack;
    int stkSize;
    public void init(){
        idStack = new ArrayList<>();
        stkSize = -1;
    }

    public void addStack(){
        idStack.add(new Stack<String>());
        stkSize++;
    }

    public void addIDtoStack(String id){
        idStack.get(stkSize).add(id);
    }

    public void removeStack(){
        idStack.remove(stkSize--);
    }
    public Stack<String> getIDList(){
        return idStack.get(stkSize);
    }
}