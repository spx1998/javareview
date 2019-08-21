package jvm;

public class FinalizeTest {
    private static FinalizeTest Finalize =null;
    public static void main(String[] args) {

        FinalizeTest finalizeTest = new FinalizeTest();
        finalizeTest=null;
        System.out.println("gc start");
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("i am still alive~");
        Finalize = this;
    }
}
