
.globl main
.data
buffer: .space 8
.text
main:
	la t0, buffer
	li t1, 0x4444
	sw t1, 0(t0)
	lw t2, 0(t0)
	lhr t3, t4(t0)
	# lhr t3, t0(t4)
	bne t2, t3, failure
success:
	li a0, 42
	li a7, 93
	ecall
failure:	
	li a0, 0
	li a7, 93
	ecall

