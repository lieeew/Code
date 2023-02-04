class Value {
    public int i=15;
}

public class JavaTest {
    public static void main(String argv[]) {
        JavaTest t=new JavaTest();
        t.first();
    }

    public void first() {
        int i=5;
        Value v=new Value();
        v.i=25;
        second(v, i); // v.i此时为25 i 为5 -> v.i = 20 i = 0
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v=val;
        System.out.println(v.i + " " + i);
    }
}