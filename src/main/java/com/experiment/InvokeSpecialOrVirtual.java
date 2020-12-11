package com.experiment;

/**
 * 调用final方法的字节码指令是 invoke virtual
 * @author sunpengxiang
 */
public class InvokeSpecialOrVirtual {
    public static void main(String[] args) {
        new InvokeSpecialOrVirtual().test();
    }

    public final void test(){
        System.out.println("final~");
    }
}
