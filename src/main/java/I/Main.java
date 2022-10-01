package I;

// Uncomment below classes to send network request if needed.
// import java.net.HttpURLConnection;
// import java.net.URL;
import java.security.SecureRandom;
import  java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        String inputData = "5 10";
//        String thisLine = null;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        while ((thisLine = br.readLine()) != null) {
//            inputData += thisLine + "\n";
//        }
//        // Output the solution to the console
//        System.out.println(codeHere(inputData));

//        List<Integer> list = Arrays.asList(1,2);
        Random random = new SecureRandom();
//                new Random();
        IntStream ints = random.ints(10, 1, 10);
        ints.forEach(e->System.out.println(e));

//        PriorityQueue
//        LinkedList
    }

    public static String codeHere(String inputData) {
        // Use this function to write your solution;
        String[] arr = inputData.split(" ");
//        String[] ans = new String[arr.length];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (Integer.valueOf(arr[i]) % 5 == 0) {
                sb.append(arr[i]).append(" ");
            }
        }

        return sb.toString();
    }
}