
.globl main
.data
buffer: .space 8
.text
main:
	la t0, buffer
	li t1, -1000
	sw t1, 0(t0)
	lh  t5, 0(t0)
	lbu t2, 0(t0)
	lbur t3, t4(t0)
	bne t2, t3, failure
success:
	li a0, 42
	li a7, 93
	ecall
failure:	
	li a0, 0
	li a7, 93
	ecall

