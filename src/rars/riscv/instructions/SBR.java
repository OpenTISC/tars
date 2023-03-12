package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class SBR extends StoreR{
    public SBR() {
        super("sbr t1, t2(t3)", "Store byte : Store the low-order 8 bits of t1 into the effective memory byte address from t2 + t3", "100");
    }
    @Override
    protected void store(int address, long value) throws AddressErrorException {
        Globals.memory.setByte(address, (int)value & 0x000000FF);
    }
}
