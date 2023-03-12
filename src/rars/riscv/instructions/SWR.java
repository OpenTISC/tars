package rars.riscv.instructions;

import rars.Globals;
import rars.riscv.hardware.AddressErrorException;

public class SWR extends StoreR{
    public SWR() {
        super("swr t1, t2(t3)", "Store word : Store contents of t1 into effective memory word address from t2 + t3", "101");
    }
    @Override
    protected void store(int address, long value) throws AddressErrorException {
        Globals.memory.setWord(address, (int) value);
    }
}
