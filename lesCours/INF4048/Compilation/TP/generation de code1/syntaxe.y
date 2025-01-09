%{
#include<stdio.h>
#include<string.h>
#include "simple.h"
#include "utilitaire.h"

char *header="extern printf,scanf \nsection .data\n; declaration des variables en memoire\nA:  dd  0\nB:  dd  0\nC:  dd  0\nD:  dd  0\nE:  dd  0\nfmt:db \"%d\", 10, 0 \nfmtlec:db \"%d\",0\nsection .text\nglobal _start\n\n_start:\n\n";

char *trailer="mov eax,1 ; sys_exit \nmov ebx,0; Exit with return code of 0 (no error)\nint 80h";
char *add=" ; addition\npop eax\npop ebx\nadd eax,ebx\npush eax\n\n";
char *mode=" ; modulo\nmov edx,0\npop ebx\npop eax\nidiv ebx\nmov eax,edx\npush eax\n\n";
char *compter=" ; compter\npop eax\nadd eax,1\npush eax\n\n";
char *mul=" ;multiplication\npop eax\npop ebx\nmul ebx\npush eax\n\n";
char *affec=" ;affectation\npop eax\nmov";
char *take=" ;recuperation en memoire\nmov eax,";
char *affec1=";affectation\n";
char *afficher1=";affiher\nmov eax,";
char *afficher2="\npush eax\npush dword fmt\ncall printf\n\n";
char *lire1=";lire\npush ";
char *lire2="\npush dword fmtlec\ncall scanf\n\n";
char *cmp = "pop ebx\npop eax\ncmp eax, ebx\n\n";

int sinonVu = 0;

int compteurSi = 0, compteurTest = 0, compteurWhile = 0;
char *cmpEgal;
char *testGene;
char *cmpDifferent;
char *cmpSuperieur;
char *cmpInferieur;

int yylex();
int yyerror(char* s);   
int var[5];
int eax, ebx;
Pile p;
FILE *yyout;

/*int take(int address)
{
    printf("TAKE");
  return var[address -'A'];
}*/

/*void affec(int address)
{
  int val = depiler(&p);
  var[address -'A'] = val;
}
*/
void ajouter()
{
  eax = depiler(&p);
  ebx = depiler(&p);
  
  empiler(&p, eax + ebx);
  
  printf("\tdans add : var1=%d var2=%d resuladd=%d ",eax,ebx,eax + ebx);
}
void multiplication()
{
  eax = depiler(&p);
  ebx = depiler(&p);
  
  empiler(&p,eax * ebx);
  
  printf("\tdans mult: var1=%d var2=%d prod=%d ",eax,ebx,eax * ebx);
}

void soustraire()
{
  ebx = depiler(&p);
  eax = depiler(&p);
  
  empiler(&p, eax - ebx);
  
  printf("\tdans sous : var1=%d var2=%d resulsous=%d ",eax,ebx,eax - ebx);
}

%}
%token DEBUTPROGRAMME FINPROGRAMME NOMBRE OPERATEUR VARIABLE IDFONCTION TANTQUE FAIRE FAIT ALORS BOUCLE COND SEPVAR SEPINSTR SYMBOLE TYPE AFFECTATION SI FSI SINON COMPARAISON
%token PLUS MOINS FOIS DIVISER
%token EGALE
%token SUPERIEUR
%token INFERIEUR
%token DIFFERENT
%token SUPEGALE
%token INFEGALE
%token LIRE 
%token ECRIRE
%token COMPTER
%token MODULO
%%
prog:
            DEBUTPROGRAMME corps FINPROGRAMME
;
corps:
            expr corps {printf("\n Réduction corps ----> expr corps ");}
            |expr {printf("\n Réduction corps ----> expr"); }
expr:   
            binst {printf("\n Réduction expr ----> binst "); }
            |binstsi {printf("\n Réduction expr ----> binstsi"); }
            |blocBoucle {printf("\n Réduction expr ----> blocBoucle"); }
binst:
            inst SEPINSTR {printf("\n Réduction binst ----> inst SEPINSTR"); }
            |inst SEPINSTR binst {printf("\n Réduction binst ----> inst SEPINSTR binst"); }
inst:   
            ECRIRE VARIABLE {fprintf(yyout,"%s [%c] %s",afficher1,$2,afficher2);}
            |LIRE VARIABLE {fprintf(yyout,"%s %c %s",lire1,$2,lire2);}
            |COMPTER VARIABLE {fprintf(yyout,"%s ",compter); }
            |VARIABLE AFFECTATION CONDITION { fprintf(yyout,"%s [%c], eax\n\n",affec,$1); }
            |VARIABLE AFFECTATION SECONDMEMBRE { fprintf(yyout,"%s [%c], eax\n\n",affec,$1); }
SECONDMEMBRE:
            T {printf("\n Réduction SECONDMEMBRE ----> TERME"); }
            |SECONDMEMBRE PLUS T { fprintf(yyout,"%s ",add); }

T:
            TERME
            | T FOIS TERME  { fprintf(yyout,"%s ",mul); }
            | T MODULO TERME { fprintf(yyout,"%s ",mode); }  
TERME:      
            VARIABLE  { fprintf(yyout,"%s [%c] \npush eax\n",take,$1);}
            |NOMBRE   { fprintf(yyout,"push %d\n",$1);}
binstsi:
            SI CONDITION alo expr finsi         {printf(";Condition avec si 2\n");}
            |SI CONDITION alo expr sino expr finsi {printf(";Condition avec sinon 2\n");}

finsi:
      FSI{
	    if(sinonVu)
	    {
	      fprintf(yyout,"suite%d:\n",compteurSi);
	      fprintf(yyout,";Réduction du fsis%d\n",compteurSi);
	      sinonVu = 0;
	    }
	    else{
	      fprintf(yyout,"sinon%d:\n",compteurSi);
	      fprintf(yyout,";Réduction du fsi%d\n",compteurSi);
	    }
	      
	    
	 }


alo:
     ALORS{
	    compteurSi++;
	    fprintf(yyout,";Réduction du alors%d\n",compteurSi);
	    fprintf(yyout,"pop eax\ncmp eax,1\njne sinon%d\n",compteurSi);
	  }

sino:
     SINON{
	    fprintf(yyout,"jmp suite%d\nsinon%d:\n",compteurSi,compteurSi);
	    fprintf(yyout,";Réduction du sinon%d\n",compteurSi);
	    sinonVu = 1;
	  }
    
blocBoucle:
     |TANTQUE etiqueBoucle exp_bool debutboucle blocIntBoucle finboucle {fprintf(yyout,";*************** ***** ****Réduction du bloc while\n");}

blocIntBoucle:
     binst
     |binstsi
     |binstsi blocIntBoucle
     |binst blocIntBoucle

etiqueBoucle:{
		compteurWhile++;
		fprintf(yyout,";********Lieu de l'étiquete\n");
		fprintf(yyout,"debutWhile%d:\n",compteurWhile);
	     }

debutboucle:
      FAIRE {
		  printf(";*************** ***** ****Réduction du faire\n");
         }

exp_bool:
     CONDITION {
		  fprintf(yyout,";*************** ***** ****Réduction de la condition\n");
		  fprintf(yyout,"pop eax\ncmp eax,1\njne finWhile%d\n",compteurWhile);
	  }

finboucle:
    FAIT  {
	    fprintf(yyout,";*************** ***** ****Réduction du done\n");
	    fprintf(yyout,"jmp debutWhile%d\nfinWhile%d:\n",compteurWhile,compteurWhile);
	  }  
CONDITION:
     |'(' TERME EGALE TERME ')' {
			
			compteurTest++;
			cmpEgal = ";Teste d'égalité\n";
			fprintf(yyout,"%s%sjne test%d\npush 1\njmp fintest%d \ntest%d:\npush 0\nfintest%d:\n\n\n",cmpEgal,cmp,compteurTest,compteurTest,compteurTest,compteurTest);
		      }
		      
     |'(' TERME DIFFERENT TERME ')' {
        compteurTest++;
			  cmpDifferent=";Teste de différence\n";
			  fprintf(yyout,"%s%sjne test%d\npush 0\njmp fintest%d \ntest%d:\npush 1\nfintest%d:\n\n\n",cmpDifferent,cmp,compteurTest,compteurTest,compteurTest,compteurTest);

		      }
		      
     |'(' TERME INFERIEUR TERME ')'  {
              compteurTest++;
                       cmpInferieur=";Teste d'infériorité\n";
			fprintf(yyout,"%s%sjge test%d\npush 1\njmp fintest%d \ntest%d:\npush 0\nfintest%d:\n\n\n",cmpInferieur,cmp,compteurTest,compteurTest,compteurTest,compteurTest);		       	      
		      }
     |'(' TERME SUPERIEUR TERME ')'  {
		       compteurTest++;
		       cmpSuperieur=";Teste de superiorité\n";
		       		       
		       fprintf(yyout,"%s%sjg test%d\npush 0\njmp fintest%d \ntest%d:\npush 1\nfintest%d:\n\n\n",cmpSuperieur,cmp,compteurTest,compteurTest,compteurTest,compteurTest);
		      }

%%
int yyerror(char *s)
{
	printf("Syntax Error on line %s\n", s);
	return 0;
}

int main()
{
  init_pile_vide(&p);
  yyout=fopen("generer.asm","w");
  fprintf(yyout,"%s",header);
  yyparse();
  fprintf(yyout,"%s",trailer);
  fclose(yyout);

  return 0;
}