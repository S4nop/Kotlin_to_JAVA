import java.util.Stack;

class KotlinExprStacks {
    public static Stack<KotlinExprForm> juncStack = new Stack<>();
    public static Stack<KotlinExprForm> eqStack = new Stack<>();
    public static Stack<KotlinExprForm> compStack = new Stack<>();
    public static Stack<KotlinIExprForm> iStack = new Stack<>();
    public static Stack<KotlinExprForm> qcolStack = new Stack<>();
    public static Stack<KotlinExprForm> rangeStack = new Stack<>();
    public static Stack<KotlinExprForm> additStack = new Stack<>();
    public static Stack<KotlinExprForm> multStack = new Stack<>();
    public static Stack<KotlinIdxExprForm> idxStack = new Stack<>();
    public static Stack<KotlinExprForm> targStack = new Stack<>();
    public static Stack<KotlinExprForm> postUStack = new Stack<>();
    public static Stack<KotlinCallExprForm> callStack = new Stack<>();
    public static Stack<KotlinDotExprForm> dotStack = new Stack<>();
    public static Stack<KotlinMultiVarDeclForm> multivalStack = new Stack<>();
    public static Stack<KotlinFunDeclForm> fundeclStack = new Stack<>();
    public static Stack<KotlinIfExprForm> ifStack = new Stack<>();  
    public static Stack<KotlinForExprForm> forStack = new Stack<>();
    public static Stack<KotlinWhileExprForm> whileStack = new Stack<>();  
    public static Stack<Stack<String>> prefStack = new Stack<>();
    public static Stack<Stack<String>> funPrmStack = new Stack<>();
    public static Stack<Stack<String>> loopStack = new Stack<>();
    public static Stack<Stack<String>> exprStack = new Stack<>();
    public static Stack<Stack<String>> assnStack = new Stack<>();
    public static Stack<Stack<String>> declStack = new Stack<>();
    public static Stack<Stack<String>> stateStack = new Stack<>();
    public static Stack<Stack<String>> jumpStack = new Stack<>();
    public static Stack<Stack<String>> blockStack = new Stack<>();
    public static Stack<Stack<String>> funbodyStack = new Stack<>();
    public static Stack<Stack<String>> ctrlbodyStack = new Stack<>();
    public static Stack<Stack<String>> valStack = new Stack<>();
}