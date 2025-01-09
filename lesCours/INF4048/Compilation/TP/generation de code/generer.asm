extern printf,scanf 
section .data
; declaration des variables en memoire
A:  dd  0
B:  dd  0
C:  dd  0
D:  dd  0
fmt:db "%d", 10, 0 
fmtlec:db "%d",0
section .text
global _start

_start:



push 6
 ;affectation
pop eax
mov [A], eax



 ;recuperation en memoire
mov eax, [A] 
push eax
push 1
 ; addition
pop eax
pop ebx
add eax,ebx
push eax

  ;affectation
pop eax
mov [A], eax



;affiher
mov eax, [A] 
push eax
push dword fmt
call printf


mov eax,1 ; sys_exit 
mov ebx,0; Exit with return code of 0 (no error)
int 80h