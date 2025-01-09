%{
#include<stdio.h> 
#include "simple.h"
void error();
%}

nombre    [0-9]+
operateur \+|\*|\=|\;|\=\=|\!\=|\<|\>
affectation nuan 
/* nwan signie recoit*/ 
/*variable   \#[a-zA-Z0-9]+*/
variable    A|B|C|D|E
fonction   [a-zA-Z_][0-9a-zA-Z_]*
condition  si|sinon|sinon_si
comparaison sup|inf|diff|sup_egal|inf_egal|egale
symbole     \(|\)
sepvar       ,
sepinstr     ;
%%
ewondo:       {printf("<debut du programme  %s>",yytext); return DEBUTPROGRAMME;}
:ewondo       {printf("<fin du programme: %s>",yytext); return FINPROGRAMME;}
{sepvar}      {printf("<sepvar: %c>",yytext[0]); return SEPVAR;}
{sepinstr}    {printf("<sepinstr: %c>",yytext[0]); return SEPINSTR;}
{symbole}     {printf("<symbole: %c>",yytext[0]); return *yytext;}
abo         {printf("<debut: %s>",yytext); return FAIRE;}
amanibo          {printf("<fin: %s>",yytext); return FAIT;}
nde         {printf("<alors: %s>",yytext); return ALORS;}
ngue            {printf("<condition: %s>",yytext); return SI;}
memanengue           {printf("<condition: %s>",yytext); return FSI;}
nguequi           {printf("<condition: %s>",yytext); return SINON;}
anal         {printf("<+: %s>",yytext); return PLUS;}
avaa          {printf("<-: %s>",yytext); return MOINS;}
abouli         {printf("<*: %s>",yytext); return FOIS;}
diviser      {printf("</: %s>",yytext); return DIVISER;}
alan           {printf("<fonction: %s>",yytext); return LIRE;}
atili         {printf("<fonction: %s>",yytext); return ECRIRE;}
compter         {printf("<fonction: %s>",yytext); return COMPTER;}
ane         {printf("<fonction: %s>",yytext); return EGALE;}
assigui         {printf("<fonction: %s>",yytext); return DIFFERENT;}
nyemoro         {printf("<fonction: %s>",yytext); return SUPERIEUR;}
muangue         {printf("<fonction: %s>",yytext); return INFERIEUR;}
supegale         {printf("<fonction: %s>",yytext); return SUPEGALE;}
infegale         {printf("<fonction: %s>",yytext); return INFEGALE;}
modulo           {printf("<fonction: %s>",yytext); return MODULO;}
unte             {printf("<boucle: %s>",yytext); return TANTQUE;}
{condition}   {printf("<condition: %s>",yytext); return COND;}
{nombre}      {printf("<nombre: %d>",atoi(yytext));yylval=atoi(yytext); return NOMBRE;}
{comparaison} {printf("<comparaison: %s>",yytext); return COMPARAISON;}
{affectation} {printf("<affectation: %s>",yytext); return AFFECTATION;}
{variable}    {printf("<variable: %s>",yytext); yylval=*yytext; return VARIABLE;}
{fonction}    {printf("<fonction: %s>",yytext); return IDFONCTION;}
{operateur}    {printf("<operateur: %s>",yytext); return *yytext;}

. ;
%%
void error(){
      printf("ca ne marche pas");
}
