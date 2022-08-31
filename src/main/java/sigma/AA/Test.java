package sigma.AA;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        PrintThread t = new PrintThread();
        t.start();
        t.join();    //print thread join called in main thread

        for (int i = 1; i <= 10; i++) {
            System.out.println("main printing: " + i);
        }
    }
}