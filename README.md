# Simple Kotlin_to_JAVA Compiler :: Using ANTLR4
---
## Introduction
This project is assignment for [Sungkyunkwan University's PL class](http://dicl.skku.edu/class/spring2019/pl/)
It provides the ability to translate some of [Kotlin's basic syntax](https://kotlinlang.org/docs/reference/basic-syntax.html) into JAVA Language
(Spring 2019)

---
### Structure & Simple Discription

#### Lexer&Parser implemted by Antlr4
[KotlinLexer.g4](src/main/java/KotlinLexer.g4)

[KotlinParser.g4](src/main/java/KotlinParser.g4)

[KotlinLexer.java](src/main/java/KotlinLexer.java)

[KotlinParser.java](src/main/java/KotlinParser.java)

[KotlinParserBaseListener.java](src/main/java/KotlinParserBaseListener.java)

[KotlinParserListener.java](src/main/java/KotlinParserListener.java)

---

#### JAVA files Based on Antlr4 Lexer&Parser
##### 1. [Kotlin2Java.java](src/main/java/Kotlin2Java.java) : Main Class
Main class of this project. It starts program flow like

1. receives input file & outpu-t file name from commandline argument. If missing, exit program
2. Antlr4 creates parse tree, walker and attaches them to `KotlinListener`.
3. Check if output file name is in commandline argument. If not, output file name is automatically fixed as `"output.java"`
4. Walker walks from root using listner.


##### 2. [KotlinListener.java](src/main/java/KotlinListener.java) : Listener Class
Listener class, contains functions that respond when entering and exiting each token.

Structure is automatically implemented by **Antlr4**

It manages tokens using `stack`.

Whenever enter a token, it is entered into the stack.

Also it handles expressions using `KotlinExprForm`
##### 3. [KotlinExprForm.java](src/main/java/KotlinExprForm.java) : Expr form Class
Super class for variable expression handling classes.

Its child class is as follow:

1. `KotlinCallExprForm` : Handling callable expressions
2. `KotlinDotExprForm` : Handling expressions containing dot(sign of decimal, properties, etc..)
3. `KotlinForExprForm` : Handling 'for' expressions
4. `KotlinIdxExprForm` : Handling array expressions
5. `KotlinIExprForm` : Handling 'is' expressions
6. `KotlinIfExprForm` : Handling 'if' expressions
7. `KotlinWhileExprForm` : Handling 'while' expressions

##### 4. [KotlinExprStacks.java](src/main/java/KotlinExprStacks.java) : Expression Stack Class
This class is for stacks managing expressions

##### 5. [KotlinFunDeclForm.java](src/main/java/KotlinFunDeclForm.java) : Function Expr Class
This class handles function structures.

##### 6. [KotlinConst.java](src/main/java/KotlinConst.java) : Const Class
Const variables are defined in this class

##### 7. [KotlinIDStackJob.java](src/main/java/KotlinIDStackJob.java) : Id stack manager Class

##### 8. [KotlinMultiVarDeclForm.java](src/main/java/KotlinMultiVarDeclForm.java) : Parenthesis making Class

##### 9. [KotlinUtils.java](src/main/java/KotlinUtils.java) : Util Class
This class contains some functions used for several situations.

1. `cngType` : Converts type of variables to make JAVA compiler can read
2. `chkType` : Checks type of variables, especially `listOf`, and call `chkDetail` function
3. `chkDetail` : Specifically inferences the type of variable - Integer, String, Double
4. `cngListOf` : Changes listOf structure into square bracket in specific case.

##### 10. KotlinPrefExprForm : UNUSED
