parser grammar KotlinParser;

options { tokenVocab = KotlinLexer; }

prog
    : NEWLINE* packages? NEWLINE* imports NEWLINE* ((state) cngLine?)* NEWLINE* EOF
    ;

packages 
    : (PACKAGE id (DOT MULT)? SEMICOLON?) 
    ;

imports
    : (IMPORT id (DOT MULT | AS id)? SEMICOLON? NEWLINE*)*
    ;

id
    : ID (NEWLINE* DOT ID)* 
    | NullLit 
    ;

funDecl //36
    : (FUN? (NEWLINE* id NEWLINE*)?
    | INIT
    | CONSTRUCTOR
    )
      NEWLINE* funParam 
      (NEWLINE* COLON NEWLINE* type)?
      (NEWLINE* funBody)?

    ;

funParam //37
    : LPAREN NEWLINE* (decFunParam (COMMA decFunParam)*)? NEWLINE* RPAREN
    ;

decFunParam
    : id (COLON type)?
    ;


funBody //32
    : block
    | ASSIGN NEWLINE* expr 
    ;

type //33
    : id (NEWLINE* DOT NEWLINE* id )* (LESS id? GREATER)? QUEST?
    ;

block //34
    : LCURL NEWLINE* (state cngLine)* NEWLINE* RCURL
    | expr
    ;

expr : juncExpr //0
     | strings
     ;

juncExpr //1
    : eqExpr (NEWLINE* lOp NEWLINE* eqExpr)*
    ;

eqExpr //2
    : compExpr (NEWLINE* eqOp NEWLINE* compExpr)*
    ;

compExpr //3
    : iExpr (NEWLINE* compOp NEWLINE* iExpr)*
    ;

iExpr //4
    : qcolExpr (NEWLINE* isOp NEWLINE* type)?
    | qcolExpr (NEWLINE* inOp NEWLINE* qcolExpr)?
    ;

qcolExpr //5
    : rangeExpr (NEWLINE* QUECOLON NEWLINE* rangeExpr)*
    ;

rangeExpr //6
    : additExpr (rangeOp NEWLINE* additExpr)*
    ;

additExpr //7
    : multExpr (NEWLINE* additOp NEWLINE* multExpr)*
    ;

multExpr //8
    : prefExpr (NEWLINE* multOp NEWLINE* prefExpr)*
    ;

idxExpr //9
    : id LSQUARE (expr (COMMA expr)*)? RSQUARE
    ;

prefExpr //10
    : prefixUOp* targ
    ;

targ //11
    : NUM
    | id postfixUOp?
    | postUExpr
    | strings
    ;

postUExpr //12
    : callExpr
    | dotExpr postfixUOp?
    | jumpExpr
    | ifExpr
    | loopExpr
    | idxExpr postfixUOp?
    | whenExpr
    | LPAREN expr RPAREN
    ;

callExpr //13
    : (id | dotExpr) LPAREN (expr (COMMA expr)*)? RPAREN 
    ;

dotExpr //14
    : id (NEWLINE* DOT (id lamdaBody?| callExpr) NEWLINE*)+
    ;
    
lamdaBody //15
    : LCURL expr RCURL
    ;
assignOp
    : ASSIGN
    | ADD_ASSIGN
    | SUB_ASSIGN
    | MULT_ASSIGN
    | DIV_ASSIGN
    | MOD_ASSIGN
    ;


rangeOp 
    : RANGE 
    | DT 
    ;

eqOp
    : NEQ
    | DBLEQ
    | TRIEQ
    ;

compOp
    : LESS
    | GREATER
    | LEQ
    | GEQ
    | eqOp
    ;

lOp
    : LAND 
    | LOR 
    ;

isOp
    : IS | NIS
    ;

inOp
    : IN | NIN
    ;

additOp
    : ADD | SUB
    ;

multOp
    : MULT
    | DIV
    | MOD
    ;

asOp
    : AS
    | COLON
    ;

prefixUOp
    : INCR
    | DECR
    | ADD
    | SUB
    | NOT
    ;

postfixUOp
    : INCR
    | DECR
    ;

decl //16
    : modLit* classDecl
    | modLit* funDecl
    | modLit* valDecl
    ;

classDecl 
    : (CLASS | INTERFACE) NEWLINE* ID NEWLINE* classParams? 
    (NEWLINE* COLON NEWLINE* classSpecf)? 
    NEWLINE* classbody? 
    ;

classSpecf
    : expr (NEWLINE* COMMA expr)*
    ;

classParams
    : LPAREN NEWLINE* (classParam (NEWLINE* COMMA NEWLINE* classParam)*)? NEWLINE* RPAREN
    ;


classParam
    : modLit? (VAL | VAR)? (NEWLINE* id (COLON type)?) NEWLINE* (ASSIGN expr)?
    ;

classbody
    : LCURL (NEWLINE* decl)* NEWLINE* RCURL
    ;

valDecl //17
    : (VAL | VAR) 
    (NEWLINE* id (COLON type)?)
    (NEWLINE* ASSIGN NEWLINE* expr)?
    (GETTER LPAREN RPAREN NEWLINE* (ASSIGN expr)?)?
    ;

multiValDecl //18
    : LPAREN valDecl (COMMA valDecl)* RPAREN
    ;

assn //19
    : id assignOp NEWLINE* expr
    ;

state //35
    : expr
    | decl 
    | assn
    ;

cngLine
    : NEWLINE+
    | SEMICOLON
    | SEMICOLON NEWLINE*
    ;

strings //20
    : QUOTE_OPN (texts | strExpr)* QUOTE_CLS
    ;

texts //21
    : Str_Esc
    | Str_Text
    | Str_Idf
    ;

strExpr 
    : Str_Exp expr* RCURL 
    ;

ifExpr //22
    : IF NEWLINE* LPAREN expr RPAREN NEWLINE*
        contrBody? SEMICOLON?
        (NEWLINE* ELSE NEWLINE* contrBody?)?
    ;

contrBody //23
    : block
    | NEWLINE* expr 
    ;

jumpExpr //24
    : THROW NEWLINE* expr
    | RETURN expr?
    | CONTINUE
    | BREAK
    ;

loopExpr //25
    : forExpr
    | whileExpr
    | doExpr
    ;

forExpr //26
    : FOR NEWLINE* LPAREN (valDecl | multiValDecl | id) IN expr 
    (STEP idNum)? RPAREN NEWLINE* contrBody?
    ;


whileExpr //27
    : WHILE NEWLINE* LPAREN expr RPAREN NEWLINE* contrBody?
    ;

doExpr //28
    : DO NEWLINE* contrBody? NEWLINE* WHILE NEWLINE* LPAREN expr RPAREN
    ;

whenExpr //29
    : WHEN NEWLINE* (LPAREN expr RPAREN)? NEWLINE* LCURL NEWLINE* 
    (arrExpr NEWLINE*)* NEWLINE* RCURL
    ;

arrExpr //30
    : (expr | testExpr) (NEWLINE* COMMA NEWLINE* (expr | testExpr))* 
    NEWLINE* ARR NEWLINE* contrBody SEMICOLON?
    | ELSE NEWLINE* ARR expr
    ;

testExpr //31
    : isOp NEWLINE* type
    | inOp NEWLINE* expr
    ;

inp
    : id
    | NUM
    | strings
    ;

idNum : id | NUM ;

modLit
  : PUBLIC
  | PRIVATE
  | PROTECTED
  | INTERNAL
  | EXTERNAL
  | ABSTRACT
  | OVERRIDE
  | OPERATOR
  | INLINE
  | FINAL
  | OPEN
  | CONST
  ;