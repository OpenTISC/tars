.globl main
.data
buffer: .space 8
.text
main:
	la t0, buffer
	li t1, 8
	# sw t1, 0(t0)
	# ERROE:
	# swr t1 t2(t0)
	swr t1 t0(t2)
	lw t2, 0(t0)
	lbr t3, t0(t4)
	bne t2, t3, failure
success:
	li a0, 42
	li a7, 93
	ecall
failure:	
	li a0, 0
	li a7, 93
	ecall