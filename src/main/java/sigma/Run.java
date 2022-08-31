package sigma;

public class Run implements Runnable {
    int i = 0;

    public static void main(String[] args) {
        Run obj = new Run();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This code is outside of the thread");
    }

    @Override
    public void run() {
        System.out.println("Run.run() ");
    }
}
