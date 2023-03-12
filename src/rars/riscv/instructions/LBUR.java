package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class LBUR extends LoadR{

    public LBUR() {
        super("lbur t1, t2(t3)", "Set t1 to zero-extended 8-bit value from effective memory byte address formed by t2 + t3", "000");
    }
    @Override
    protected long load(int address) throws AddressErrorException {
        return Globals.memory.getByte(address) & 0x000000FF;
    }
}
