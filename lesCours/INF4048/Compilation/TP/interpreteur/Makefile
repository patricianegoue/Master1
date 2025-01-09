default: 
	clear
	bison --defines=simple.h -v -o lexeme.c syntaxe.y
	flex -o lexeme.yy.c lexeme.l
	gcc utilitaire.c lexeme.yy.c lexeme.c -o prog -lfl