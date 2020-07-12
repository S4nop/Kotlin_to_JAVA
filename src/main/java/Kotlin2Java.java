import java.util.*;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Kotlin2Java {
    public static void main(String[] args) throws IOException {
        //System.out.println("** Expression Eval w/ antlr-listener **");
        // Get lexer
        if(args.length == 0){
            System.err.println("You must put file name on command line!");
            System.exit(1);
        }
        KotlinLexer lexer = new KotlinLexer(CharStreams.fromFileName(args[0]));
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass tokens to parser
        KotlinParser parser = new KotlinParser(tokens);
        // Walk parse-tree and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        KotlinListener listener = new KotlinListener();
        listener.setClassName(args.length > 1 ? args[1] : "output.java");


        // walk from the root of parse tree
        walker.walk(listener, parser.prog());
    }
}
