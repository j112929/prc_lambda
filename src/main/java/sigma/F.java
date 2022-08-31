package sigma;

import java.io.File;

public class F {
    public static void main(String[] args) {
        File f = new File("/Users/yoshitakurin/Desktop");
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}
