extern printf,scanf 
section .data
; declaration des variables en memoire
A:  dd  0
B:  dd  0
C:  dd  0
D:  dd  0
E:  dd  0
fmt:db "%d", 10, 0 
fmtlec:db "%d",0
section .text
global _start

_start:


;lire
push  A 
push dword fmtlec
call scanf


;lire
push  B 
push dword fmtlec
call scanf


 ;recuperation en memoire
mov eax, [A] 
push eax
 ;recuperation en memoire
mov eax, [B] 
push eax
;Teste de superiorité
pop ebx
pop eax
cmp eax, ebx

jg test1
push 0
jmp fintest1 
test1:
push 1
fintest1:


;Réduction du alors1
pop eax
cmp eax,1
jne sinon1

 ;recuperation en memoire
mov eax, [B] 
push eax
 ;affectation
pop eax
mov [D], eax


 ;recuperation en memoire
mov eax, [A] 
push eax
 ;recuperation en memoire
mov eax, [B] 
push eax
 ; modulo
mov edx,0
pop ebx
pop eax
idiv ebx
mov eax,edx
push eax

  ;affectation
pop eax
mov [C], eax


sinon1:
;Réduction du fsi1

 ;recuperation en memoire
mov eax, [A] 
push eax
 ;recuperation en memoire
mov eax, [B] 
push eax
;Teste d'infériorité
pop ebx
pop eax
cmp eax, ebx

jge test2
push 1
jmp fintest2 
test2:
push 0
fintest2:


;Réduction du alors2
pop eax
cmp eax,1
jne sinon2

 ;recuperation en memoire
mov eax, [A] 
push eax
 ;affectation
pop eax
mov [D], eax


 ;recuperation en memoire
mov eax, [B] 
push eax
 ;recuperation en memoire
mov eax, [A] 
push eax
 ; modulo
mov edx,0
pop ebx
pop eax
idiv ebx
mov eax,edx
push eax

  ;affectation
pop eax
mov [C], eax


sinon2:
;Réduction du fsi2

;********Lieu de l'étiquete
debutWhile1:
 ;recuperation en memoire
mov eax, [C] 
push eax
push 0
;Teste de différence
pop ebx
pop eax
cmp eax, ebx

jne test3
push 0
jmp fintest3 
test3:
push 1
fintest3:


;*************** ***** ****Réduction de la condition
pop eax
cmp eax,1
jne finWhile1

 ;recuperation en memoire
mov eax, [D] 
push eax
 ;affectation
pop eax
mov [E], eax


 ;recuperation en memoire
mov eax, [C] 
push eax
 ;affectation
pop eax
mov [D], eax


 ;recuperation en memoire
mov eax, [E] 
push eax
 ;recuperation en memoire
mov eax, [D] 
push eax
 ; modulo
mov edx,0
pop ebx
pop eax
idiv ebx
mov eax,edx
push eax

  ;affectation
pop eax
mov [C], eax


;*************** ***** ****Réduction du done
jmp debutWhile1
finWhile1:
;*************** ***** ****Réduction du bloc while

;affiher
mov eax, [D] 
push eax
push dword fmt
call printf






mov eax,1 ; sys_exit 
mov ebx,0; Exit with return code of 0 (no error)
int 80h