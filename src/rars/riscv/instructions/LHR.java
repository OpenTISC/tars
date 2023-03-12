package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class LHR extends LoadR{

    public LHR() {
        super("lhr t1, t2(t3)", "Set t1 to sign-extended 16-bit value from effective memory halfword address formed by t2 + t3", "101");
    }
    @Override
    protected long load(int address) throws AddressErrorException {
        return (Globals.memory.getHalf(address) << 16) >> 16;
    }
}
