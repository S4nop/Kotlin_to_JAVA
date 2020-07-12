lexer grammar KotlinLexer;



fragment REAL: [0-9]+('.'[0-9]+)? ;
fragment Digit: [0-9]+ ;
fragment Letter : [a-zA-Z] ;
fragment EscId
    : '\\' ('b' | 'n' | 'r' | 't' | '"' | '\'' | '\\' | '$')
    ;
NUM: REAL | Digit ('L' | 'F' | 'f')?;
WS: [\u0020\u0009\u000C] -> skip ;
NEWLINE : '\r\n' | '\n' ;

DOTDOTDOT: '...' ;
DOT: '.' ;
COMMA: ',' ;
LPAREN: '(' -> pushMode(Paren) ;
LSQUARE: '[' -> pushMode(Paren) ;
LCURL: '{' ;
RCURL: '}' ;
MULT: '*' ;
MOD: '%' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;
INCR: '++' ;
DECR: '--' ;
LAND: '&&' ;
LOR: '||' ;
NOT: '!' ;
COLON: ':' ;
SEMICOLON: ';' ;
ASSIGN: '=' ;
ADD_ASSIGN: '+=' ;
SUB_ASSIGN: '-=' ;
MULT_ASSIGN: '*=' ;
DIV_ASSIGN: '/=' ;
MOD_ASSIGN: '%=' ;
ARR: '->' ;
DBL_ARR: '=>' ;
RANGE: '..' ;
DBLCOLON: '::' ;
QUECOLON: '?:' ;
DBL_SEMICOLON: ';;' ;
QUEST: '?' ;
LESS: '<' ;
GREATER: '>' ;
LEQ: '<=' ;
GEQ: '>=' ;
NEQ: '!=' ;
NDBLEQ: '!==' ;
DBLEQ: '==' ;
TRIEQ: '===' ;
SINGLE_QUOTE: '\'' ;

PACKAGE: 'package' ;
IMPORT: 'import' ;
CLASS: 'class' ;
INTERFACE: 'interface' ;
FUN: 'fun' ;
OBJECT: 'object' ;
VAL: 'val' ;
VAR: 'var' ;
IF: 'if' ;
ELSE: 'else' ;
FOR: 'for' ;
DO: 'do' ;
WHILE: 'while' ;
CONTINUE: 'continue' ;
BREAK: 'break' ;
RETURN: 'return' ;
CONSTRUCTOR: 'constructor' ;
BY: 'by' ;
INIT: 'init'  ;
WHERE: 'where' ;
WHEN: 'when' ;
IS: 'is' ;
NIS: '!is' ;
DT : 'downTo' ;
AS: 'as' ;
IN: 'in' ;
NIN : '!in' ;
STEP : 'step' ;
GETTER: 'get' ;
SETTER: 'set' ;
//MODIFIERS

PUBLIC: 'public' ;
PRIVATE: 'private' ;
PROTECTED: 'protected' ;
INTERNAL: 'internal' ;
EXTERNAL: 'external' ;
ABSTRACT: 'abstract' ;
OVERRIDE: 'override' ;
OPERATOR: 'operator' ;
INLINE: 'inline' ;
FINAL: 'final' ;
OPEN: 'open' ;
CONST: 'const' ;
THROW : 'throw' ;


BoolLit  : 'true'
         | 'false'
         ;

NullLit  : 'null'
         ;

ID : (Letter | '_') (Letter | Digit | '_')*
   | '`' ~('`')+ '`'
   ;
//주석처리

LNGCmt
    : '/*' ( LNGCmt| . )*? '*/'
      -> channel(HIDDEN)
    ;

LineCmt
    : '//' ~[\n\r]*
      -> channel(HIDDEN)
    ;


QUOTE_OPN : '"' -> pushMode(String);

mode Paren;
RPAREN: ')'  -> popMode ;
RSQUARE: ']' -> popMode ;

Paren_RCURL: RCURL -> popMode, type(RCURL) ;

Paren_LPAREN: LPAREN -> pushMode(Paren), type(LPAREN) ;
Paren_LSQUARE: LSQUARE -> pushMode(Paren), type(LSQUARE) ;

Paren_LCURL: LCURL -> pushMode(StrExpression), type(LCURL) ;
Paren_DOT: DOT -> type(DOT) ;
Paren_COMMA: COMMA  -> type(COMMA) ;
Paren_MULT: MULT -> type(MULT) ;
Paren_MOD: MOD  -> type(MOD) ;
Paren_DIV: DIV -> type(DIV) ;
Paren_ADD: ADD  -> type(ADD) ;
Paren_SUB: SUB  -> type(SUB) ;
Paren_INCR: INCR  -> type(INCR) ;
Paren_DECR: DECR  -> type(DECR) ;
Paren_LAND: LAND  -> type(LAND) ;
Paren_LOR: LOR  -> type(LOR) ;
Paren_NOT: NOT  -> type(NOT) ;
Paren_COLON: COLON  -> type(COLON) ;
Paren_SEMICOLON: SEMICOLON  -> type(SEMICOLON) ;
Paren_ASSIGN: ASSIGN  -> type(ASSIGN) ;
Paren_ADD_ASSIGN: ADD_ASSIGN  -> type(ADD_ASSIGN) ;
Paren_SUB_ASSIGN: SUB_ASSIGN  -> type(SUB_ASSIGN) ;
Paren_MULT_ASSIGN: MULT_ASSIGN  -> type(MULT_ASSIGN) ;
Paren_DIV_ASSIGN: DIV_ASSIGN  -> type(DIV_ASSIGN) ;
Paren_MOD_ASSIGN: MOD_ASSIGN  -> type(MOD_ASSIGN) ;
Paren_ARR: ARR  -> type(ARR) ;
Paren_DBLARR: DBL_ARR  -> type(DBL_ARR) ;
Paren_RANGE: RANGE  -> type(RANGE) ;
Paren_DBLCOLON: DBLCOLON  -> type(DBLCOLON) ;
Paren_DOUBLE_SEMICOLON: DBL_SEMICOLON  -> type(DBL_SEMICOLON) ;
Paren_QUEST: QUEST  -> type(QUEST) ;
Paren_LANGLE: LESS  -> type(LESS) ;
Paren_RANGLE: GREATER  -> type(GREATER) ;
Paren_LE: LEQ  -> type(LEQ) ;
Paren_GE: GEQ  -> type(GEQ) ;
Paren_NEQ: NEQ  -> type(NEQ) ;
Paren_NDBEQEQ: NDBLEQ  -> type(NDBLEQ) ;
Paren_AS: AS -> type(AS) ;
Paren_IS: IS -> type(IS) ;
Paren_IN: IN -> type(IN);
Paren_VAL: VAL -> type(VAL);
Paren_VAR: VAR -> type(VAR);
Paren_DT : DT -> type(DT);
Paren_STEP : STEP -> type(STEP);
Paren_NIS: NIS -> type(NIS) ;
Paren_NIN: NIN -> type(NIN) ;
Paren_DBLEQ: DBLEQ  -> type(DBLEQ) ;
Paren_TRIEQ: TRIEQ  -> type(TRIEQ) ;
Paren_SINGLE_QUOTE: SINGLE_QUOTE  -> type(SINGLE_QUOTE) ;
Paren_QUOTE_OPN: QUOTE_OPN -> pushMode(String), type(QUOTE_OPN) ;
Paren_BoolLit: BoolLit -> type(BoolLit) ;
Paren_NullLit: NullLit -> type(NullLit) ;
Paren_ID: ID -> type(ID) ;
Paren_Cmt: (LNGCmt | LineCmt) -> channel(HIDDEN) ;
Paren_WS: WS -> skip ;
Paren_NEWLINE: NEWLINE -> skip ;
Paren_NUM: NUM -> type(NUM) ;
Paren_PACKAGE: PACKAGE -> type(PACKAGE);
Paren_IMPORT: IMPORT -> type(IMPORT);
Paren_CLASS: CLASS -> type(CLASS);
Paren_INTERFACE: INTERFACE -> type(INTERFACE);
Paren_FUN: FUN -> type(FUN);
Paren_OBJECT: OBJECT -> type(OBJECT);
Paren_IF: IF -> type(IF);
Paren_ELSE: ELSE -> type(ELSE);
Paren_FOR: FOR -> type(FOR);
Paren_DO: DO -> type(DO);
Paren_WHILE: WHILE -> type(WHILE);
Paren_CONTINUE: CONTINUE -> type(CONTINUE);
Paren_BREAK: BREAK -> type(BREAK);
Paren_RETURN: RETURN -> type(RETURN);
Paren_CONSTRUCTOR: CONSTRUCTOR -> type(CONSTRUCTOR);
Paren_BY: BY -> type(BY);
Paren_INIT: INIT  -> type(INIT);
Paren_WHERE: WHERE -> type(WHERE);
Paren_WHEN: WHEN-> type(WHEN);
Paren_PUBLIC: PUBLIC -> type(PUBLIC);
Paren_PRIVATE: PRIVATE -> type(PRIVATE);
Paren_PROTECTED: PROTECTED -> type(PROTECTED);
Paren_INTERNAL: INTERNAL -> type(INTERNAL);
Paren_EXTERNAL: EXTERNAL -> type(EXTERNAL) ;
Paren_ABSTRACT: ABSTRACT -> type(ABSTRACT) ;
Paren_OVERRIDE: OVERRIDE -> type(OVERRIDE) ;
Paren_OPERATOR: OPERATOR -> type(OPERATOR) ;
Paren_INLINE: INLINE -> type(INLINE) ;
Paren_FINAL: FINAL -> type(FINAL) ;
Paren_OPEN: OPEN -> type(OPEN) ;
Paren_CONST: CONST -> type(CONST) ;
Paren_GETTER: GETTER -> type(GETTER) ;
Paren_SETTER: SETTER -> type(SETTER) ;
Paren_QUECOLON: QUECOLON -> type(QUECOLON) ;

mode String;
QUOTE_CLS : '"'
    -> popMode
        ;

Str_Exp : '${' 
    -> pushMode(StrExpression)
        ;

Str_Idf : '$' ID ;

Str_Text : ~('\\' | '"' | '$')+ | '$' ;

Str_Esc : '\\'. ;


mode StrExpression;
StrExpression_RCURL: RCURL -> popMode, type(RCURL) ;

StrExpression_LPAREN: LPAREN -> pushMode(Paren), type(LPAREN) ;
StrExpression_LSQUARE: LSQUARE -> pushMode(Paren), type(LSQUARE) ;

StrExpression_LCURL: LCURL -> pushMode(StrExpression), type(LCURL) ;
StrExpression_DOT: DOT -> type(DOT) ;
StrExpression_COMMA: COMMA  -> type(COMMA) ;
StrExpression_MULT: MULT -> type(MULT) ;
StrExpression_MOD: MOD  -> type(MOD) ;
StrExpression_DIV: DIV -> type(DIV) ;
StrExpression_ADD: ADD  -> type(ADD) ;
StrExpression_SUB: SUB  -> type(SUB) ;
StrExpression_INCR: INCR  -> type(INCR) ;
StrExpression_DECR: DECR  -> type(DECR) ;
StrExpression_LAND: LAND  -> type(LAND) ;
StrExpression_LOR: LOR  -> type(LOR) ;
StrExpression_NOT: NOT  -> type(NOT) ;
StrExpression_COLON: COLON  -> type(COLON) ;
StrExpression_SEMICOLON: SEMICOLON  -> type(SEMICOLON) ;
StrExpression_ASSIGN: ASSIGN  -> type(ASSIGN) ;
StrExpression_ADD_ASSIGN: ADD_ASSIGN  -> type(ADD_ASSIGN) ;
StrExpression_SUB_ASSIGN: SUB_ASSIGN  -> type(SUB_ASSIGN) ;
StrExpression_MULT_ASSIGN: MULT_ASSIGN  -> type(MULT_ASSIGN) ;
StrExpression_DIV_ASSIGN: DIV_ASSIGN  -> type(DIV_ASSIGN) ;
StrExpression_MOD_ASSIGN: MOD_ASSIGN  -> type(MOD_ASSIGN) ;
StrExpression_ARR: ARR  -> type(ARR) ;
StrExpression_DBLARR: DBL_ARR  -> type(DBL_ARR) ;
StrExpression_RANGE: RANGE  -> type(RANGE) ;
StrExpression_DBLCOLON: DBLCOLON  -> type(DBLCOLON) ;
StrExpression_DOUBLE_SEMICOLON: DBL_SEMICOLON  -> type(DBL_SEMICOLON) ;
StrExpression_QUEST: QUEST  -> type(QUEST) ;
StrExpression_LANGLE: LESS  -> type(LESS) ;
StrExpression_RANGLE: GREATER  -> type(GREATER) ;
StrExpression_LE: LEQ  -> type(LEQ) ;
StrExpression_GE: GEQ  -> type(GEQ) ;
StrExpression_NEQ: NEQ  -> type(NEQ) ;
StrExpression_NDBEQEQ: NDBLEQ  -> type(NDBLEQ) ;
StrExpression_AS: AS -> type(AS) ;
StrExpression_IS: IS -> type(IS) ;
StrExpression_IN: IN -> type(IN);
StrExpression_NIS: NIS -> type(NIS) ;
StrExpression_NIN: NIN -> type(NIN) ;
StrExpression_QUECOLON: QUECOLON -> type(QUECOLON) ;
StrExpression_DBLEQ: DBLEQ  -> type(DBLEQ) ;
StrExpression_TRIEQ: TRIEQ  -> type(TRIEQ) ;
StrExpression_SINGLE_QUOTE: SINGLE_QUOTE  -> type(SINGLE_QUOTE) ;
StrExpression_QUOTE_OPN: QUOTE_OPN -> pushMode(String), type(QUOTE_OPN) ;
StrExpression_BoolLit: BoolLit -> type(BoolLit) ;
StrExpression_NullLit: NullLit -> type(NullLit) ;
StrExpression_ID: ID -> type(ID) ;
StrExpression_Cmt: (LNGCmt | LineCmt) -> channel(HIDDEN) ;
StrExpression_WS: WS -> skip ;
StrExpression_NEWLINE: NEWLINE -> skip ;
StrExpression_NUM: NUM -> type(NUM);
StrExpression_GETTER: GETTER -> type(GETTER) ;
StrExpression_SETTER: SETTER -> type(SETTER) ;