	.file	"Aruna1.c"
	.section	.rodata
	.align 32
.LC0:
	.string	"the value of head %d and it contents %d %d\n"
	.text
.globl foo
	.type	foo, @function
foo:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$8, %esp
	movl	8(%ebp), %eax
	movl	%eax, -4(%ebp)
	movl	8(%ebp), %eax
	pushl	4(%eax)
	movl	8(%ebp), %eax
	pushl	(%eax)
	pushl	8(%ebp)
	pushl	$.LC0
	call	printf
	addl	$16, %esp
	movl	8(%ebp), %eax
	movl	4(%eax), %eax
	movl	%eax, 8(%ebp)
	subl	$12, %esp
	pushl	-4(%ebp)
	call	free
	addl	$16, %esp
	movl	-4(%ebp), %eax
	pushl	4(%eax)
	movl	-4(%ebp), %eax
	pushl	(%eax)
	pushl	-4(%ebp)
	pushl	$.LC0
	call	printf
	addl	$16, %esp
	leave
	ret
	.size	foo, .-foo
	.section	.rodata
.LC1:
	.string	"Value of head here is %p\n"
.LC2:
	.string	"%d\n"
	.text
.globl main
	.type	main, @function
main:
	pushl	%ebp
	movl	%esp, %ebp
	pushl	%ebx
	subl	$4, %esp
	andl	$-16, %esp
	movl	$0, %eax
	subl	%eax, %esp
	subl	$12, %esp
	pushl	$8
	call	malloc
	addl	$16, %esp
	movl	%eax, -8(%ebp)
	movl	-8(%ebp), %eax
	movl	$1, (%eax)
	movl	-8(%ebp), %ebx
	subl	$12, %esp
	pushl	$8
	call	malloc
	addl	$16, %esp
	movl	%eax, 4(%ebx)
	movl	-8(%ebp), %eax
	movl	4(%eax), %eax
	movl	$2, (%eax)
	movl	-8(%ebp), %eax
	movl	4(%eax), %ebx
	subl	$12, %esp
	pushl	$8
	call	malloc
	addl	$16, %esp
	movl	%eax, 4(%ebx)
	movl	-8(%ebp), %eax
	movl	4(%eax), %eax
	movl	4(%eax), %eax
	movl	$3, (%eax)
	movl	-8(%ebp), %eax
	movl	4(%eax), %eax
	movl	4(%eax), %eax
	movl	$0, 4(%eax)
	movl	-8(%ebp), %eax
	pushl	4(%eax)
	movl	-8(%ebp), %eax
	pushl	(%eax)
	pushl	-8(%ebp)
	pushl	$.LC0
	call	printf
	addl	$16, %esp
	subl	$8, %esp
	pushl	-8(%ebp)
	pushl	$.LC1
	call	printf
	addl	$16, %esp
	subl	$12, %esp
	pushl	-8(%ebp)
	call	foo
	addl	$16, %esp
.L3:
	cmpl	$0, -8(%ebp)
	jne	.L5
	jmp	.L4
.L5:
	subl	$8, %esp
	movl	-8(%ebp), %eax
	pushl	(%eax)
	pushl	$.LC2
	call	printf
	addl	$16, %esp
	movl	-8(%ebp), %eax
	movl	4(%eax), %eax
	movl	%eax, -8(%ebp)
	jmp	.L3
.L4:
	movl	-4(%ebp), %ebx
	leave
	ret
	.size	main, .-main
	.section	.note.GNU-stack,"",@progbits
	.ident	"GCC: (GNU) 3.3.1 (Mandrake Linux 9.2 3.3.1-2mdk)"
