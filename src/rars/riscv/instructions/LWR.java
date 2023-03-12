package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class LWR extends LoadR{

    public LWR() {
        super("lwr t1, t2(t3)", "Set t1 to contents of effective memory word address formed by t2 + t3", "110");
    }
    @Override
    protected long load(int address) throws AddressErrorException {
        return Globals.memory.getWord(address);
    }
}