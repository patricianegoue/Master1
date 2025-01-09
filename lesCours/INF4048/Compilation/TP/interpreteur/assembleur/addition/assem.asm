bits 32
extern	printf
section .data
	message db 'Hello World !', 10
	fmt:    	db "%d", 10, 0
section .text
	global _start
	_start:
		mov eax, 4
		mov ebx, 1
		mov ecx, message
		mov edx, 15+1
		int 0x80

		mov ebx, 32 ; on doit obtenir le reste de la division de eax par 32
		div ebx ; on divise la valeur contenue dans le registre eax par celle contenue dans le registre ebx (ici 32)
		mov eax, edx ; on récupère le reste de la division (contenu dans edx) et on le met dans eax
		
		; ici ecx vaut 16, on l'affiche avec la fonction printf
		push    edx 		; on met eax (à afficher) dans la pile)
		push    dword fmt 	; on met la fonction d'affichage dans la pile
		call    printf		; on appelle la fonction printf
      		int 0x80 ;interrupt for linux
		
		
		mov eax, 1
		mov ebx, 0
		int 0x80
