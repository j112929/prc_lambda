package AA;

public class P {
    protected int age;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("p_f");
    }
}
