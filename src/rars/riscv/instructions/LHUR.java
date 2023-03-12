package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class LHUR extends LoadR{

    public LHUR() {
        super("lhur t1, t2(t3)", "Set t1 to zero-extended 16-bit value from effective memory halfword address formed by t2 + t3", "001");
    }
    @Override
    protected long load(int address) throws AddressErrorException {
        return Globals.memory.getByte(address) & 0x0000FFFF;
    }
}