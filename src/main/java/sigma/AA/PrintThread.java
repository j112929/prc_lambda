package sigma.AA;

public class PrintThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("My thread Printing: " + i);
        }
    }
}



