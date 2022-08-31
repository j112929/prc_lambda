package AA;

import java.util.function.Predicate;

public class B {
    static void lay(boolean a, Predicate<A> lambda) {
        //a.a();
    }

    public static void main(String[] args) {
        lay(true, A::a);
    }
}
