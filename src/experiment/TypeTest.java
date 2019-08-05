package experiment;

public class TypeTest {
    public static void main(String[] args) {
        int i = 1;
        float f =1.1f;
        double d = 1.1;
        long l = 100;
        short s = 1;
        s = (short) (s+1);
        s++;
        s += 1;
        i = s+1;
        i = (int) (l+1);
        f = (float) (d+1);
        d = f+1;
        char c = 'a';
        s = (short) (c+1);
    }
}
