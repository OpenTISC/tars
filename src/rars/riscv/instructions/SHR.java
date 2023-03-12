package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class SHR extends StoreR{
    public SHR() {
        super("shr t1, t2(t3)", "Store halfword : Store the low-order 16 bits of t1 into the effective memory halfword address from t2 + t3", "101");
    }
    @Override
    protected void store(int address, long value) throws AddressErrorException {
        Globals.memory.setHalf(address, (int)value & 0x0000FFFF);
    }
}
