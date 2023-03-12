package rars.riscv.instructions;

import rars.ProgramStatement;
import rars.SimulationException;
import rars.riscv.BasicInstruction;
import rars.riscv.BasicInstructionFormat;
import rars.riscv.hardware.RegisterFile;

public class ISA_TEST extends BasicInstruction {
    public ISA_TEST() {
        super("isa_test t1, t2, t3", "add two to one reg",
                BasicInstructionFormat.EXTEND, "10000 00 sssss fffff 000 ttttt 0110011");
    }
    @Override
    public void simulate(ProgramStatement statement) throws SimulationException {
        int[] operands = statement.getOperands();
        RegisterFile.updateRegister(operands[0], RegisterFile.getValueLong(operands[1]) + RegisterFile.getValueLong(operands[2]));
    }
}
