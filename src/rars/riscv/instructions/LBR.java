package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class LBR extends LoadR{

    public LBR() {
        super("lbr t1, t2(t3)", "Set t1 to sign-extended 8-bit value from effective memory byte address formed by t2 + t3", "100");
    }
    @Override
    protected long load(int address) throws AddressErrorException {
        return (Globals.memory.getByte(address) << 24) >> 24;
    }
}
