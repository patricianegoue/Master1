default: 
	clear
	bison --defines=simple.h -v -o lexeme.c syntaxe.y
	flex -o lexeme.yy.c lexeme.l
	gcc utilitaire.c lexeme.yy.c lexeme.c -o prog -lfl
	nasm -f elf -o prog.o generer.asm
	ld -s -o progasm prog.o -melf_i386 -I/lib/ld-linux.so.2 -lc


