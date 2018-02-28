/* codigo de usuario */
package simuladorconsola;

import java_cup.runtime.*;
import static simuladorconsola.sym.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%class AnalizadorLexico
%cup
%cupdebug
%line
%column

LineTerminator = \r|\n|\r\n

DIAGONAL = [/]

WhiteSpace = [ \t\f]+

/* identifiers */
NameDirectory =   [:jletterdigit:] ([:jletterdigit:] | [-] | [_] | [@] | [+] | [*] | [#])*
NameFile =        [:jletterdigit:] ([:jletterdigit:] | [-] | [_] | [@] | [+] | [*] | [#] | [.])*
//PathDirectory =   [/]( [NameDirectory] [/] )* [NameDirectory]? | ([NameDirectory] [/])+[NameDirectory]? | [NameDirectory]
//PathFile =        [/]( [NameDirectory] [/] )* [NameFile] | ([NameDirectory] [/])+ [NameFile]

%{
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
%}

%% // separador de areas

/* reglas lexicas */
<YYINITIAL> {

	"&&"		{ return symbol(CONCAT);}

	"pwd"		{ return symbol(DIRECTION);}

	"mv"		{ return symbol(RENAMEF);}

  "cp"    { return symbol(COPY);}

  "ls"    { return symbol(LIST);}

  "-l"    { return symbol(LISTDET);}

  "-a"    { return symbol(LISTHIDE);}

  "rm"    { return symbol(DELETE);}

  "rmdir"    { return symbol(DELETEDIR);}

  "mkdir"    { return symbol(NEWDIR);}

  "chmod"    { return symbol(MANPERMISO);}

  "cd"    { return symbol(MOVEPATH);}

  "touch"    { return symbol(CREATEFE);}

  "-r"|"-R"    { return symbol(RECURSIVE);}

  "r"    { return symbol(READ, yytext());}

  "w"    { return symbol(WRITE, yytext());}

  "x"    { return symbol(EXECUTE, yytext());}

  "rw"|"wr"    { return symbol(READ_WRITE, yytext());}

  "wx"|"xw"    { return symbol(WRITE_EXECUTE, yytext());}

  "xr"|"rx"    { return symbol(READ_EXECUTE, yytext());}

  "xrw"|"rwx"|"wxr"|"xwr"|"rxw"|"wrx" {return symbol(READ_WRITE_EXECUTE, yytext());}

  ".."    { return symbol(BACKDIR);}

  "+"    { return symbol(MAS, yytext());}

  "-"    { return symbol(MENOS, yytext());}  

	{WhiteSpace} { return symbol(SPACE);}

  //{DIAGONAL}({NameDirectory} {DIAGONAL} )*{NameDirectory}?|({NameDirectory}{DIAGONAL})+{NameDirectory}?|{NameDirectory} { System.out.println("Path Dir: "+yytext()); return symbol(PDIRECTORY, yytext()); }

   {DIAGONAL}({NameDirectory} {DIAGONAL} )*{NameDirectory}?|({NameDirectory}{DIAGONAL})+{NameDirectory}?|{NameDirectory} { return symbol(PDIRECTORY, yytext()); }

  //{DIAGONAL}( {NameDirectory} {DIAGONAL} )* {NameFile} | ({NameDirectory} {DIAGONAL})+ {NameFile}  { System.out.println("Path File: "+yytext()); return symbol(PFILE, yytext()); }

  {DIAGONAL}( {NameDirectory} {DIAGONAL} )* {NameFile} | ({NameDirectory} {DIAGONAL})+ {NameFile}  { return symbol(PFILE, yytext()); }

  {NameFile}  { return symbol(NFILE, yytext());}

  {LineTerminator}  {/* NADA */}

}

/* error fallback */
[^]                              /*{ throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }*/
			{error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }