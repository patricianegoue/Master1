%{
#include<stdio.h>
#include<string.h>
#include "simple.h"
#include "utilitaire.h"

int sinonVu = 0;

int compteurSi = 0, compteurTest = 0, compteurWhile = 0;
char *cmpEgal;
char *testGene;
char *cmpDifferent;
char *cmpSuperieur;
char *cmpInferieur;

int yylex();
int yyerror(char* s);   
int var[4];
int eax, ebx;
Pile p;
FILE *yyout;

int take(int address)
{
    printf("TAKE");
  return var[address -'A'];
}

void affec(int address)
{
  int val = depiler(&p);
  var[address -'A'] = val;
}

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
%token LIRE 
%token ECRIRE
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
            ECRIRE VARIABLE {printf("\n%d", take($2));}
            |LIRE VARIABLE {printf("lire ici");}
            |VARIABLE AFFECTATION SECONDMEMBRE  {affec($1); printf("\n Réduction OOO %d inst ----> VARIABLE AFFECTATION SECONDMEMBRE",$1);printf("  var = SECONDMEMBRE"); }
SECONDMEMBRE:
            T {printf("\n Réduction SECONDMEMBRE ----> TERME"); }
            |SECONDMEMBRE PLUS T {ajouter();printf("\n Réduction SECONDMEMBRE ----> TERME OPERATEUR SECONDMEMBRE" ); printf(" op %d ",$3); }

T:
            TERME
            | T FOIS TERME {multiplication();printf("MULTIP"); }
TERME:      
            VARIABLE  {empiler(&p, take($1)); printf("\n Réduction TERME ----> VARIABLE"); printf(" %d",take($1));}
            |NOMBRE   {empiler(&p, $1); printf("\n Réduction TERME ----> NOMBRE");  printf(" le %d",$1);}
binstsi:
            SI CONDITION alo expr finsi         {printf(";Condition avec si 2\n");}
            |SI CONDITION alo expr sino expr finsi {printf(";Condition avec sinon 2\n");}

finsi:
      FSI{
	    if(sinonVu)
	    {
	      printf("suite%d:\n",compteurSi);
	      printf(";Réduction du fsis%d\n",compteurSi);
	      sinonVu = 0;
	    }
	    else{
	      printf("sinon%d:\n",compteurSi);
	      printf(";Réduction du fsi%d\n",compteurSi);
	    }
	      
	    
	 }


alo:
     ALORS{
	    compteurSi++;
	    printf(";Réduction du alors%d\n",compteurSi);
	    printf("pop eax\ncmp eax,1\njne sinon%d\n",compteurSi);
	  }

sino:
     SINON{
	    printf("jmp suite%d\nsinon%d:\n",compteurSi,compteurSi);
	    printf(";Réduction du sinon%d\n",compteurSi);
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
		printf(";********Lieu de l'étiquete\n");
		printf("debutboucle\n");
		
	     }

debutboucle:
      FAIRE {
		printf(";*************** ***** ****Réduction du faire\n");
         }

exp_bool:
     CONDITION {
		printf(";*************** ***** ****Réduction de la condition\n");
		printf("condition");
	  }

finboucle:
    FAIT  {
	    printf(";*************** ***** ****Réduction du done\n");
	    printf("fin de la boucle");
	  }  
CONDITION:
     |'(' TERME'=='TERME ')' {
			compteurTest++;
			cmpEgal = ";Teste d'égalité\n";
			printf("verification égalité");
		      }
		      
     |'(' TERME'!='TERME ')' {
			compteurTest++;
			cmpDifferent=";Teste de différence\n";
			printf("verification égalité: different");
		      }
		      
     |'(' TERME'<'TERME ')'  {
			compteurTest++;
                       cmpInferieur=";Teste d'infériorité\n";
            printf("verification inf");		       	      
		      }
     |'(' TERME'>'TERME ')'  {
		       compteurTest++;
		       cmpSuperieur=";Teste de superiorité\n";
                printf("verification supp");
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
    yyparse();
    return 0;
}