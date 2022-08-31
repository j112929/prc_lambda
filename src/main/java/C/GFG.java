package C;// { Driver Code Starts
//Initial Template for Java

import java.io.IOException;
import java.util.LinkedList;

class GFG {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
////        int t = Integer.parseInt(br.readLine());
////
////        while(t > 0){
//
//            String input_line1[] = br.readLine().trim().split("\\s+");
//		System.out.println(input_line1.length);
//            int X = Integer.parseInt(input_line1[0]);
//            int Y = Integer.parseInt(input_line1[1]);
//
//            String S = br.readLine();
//
        Solution ob = new Solution();

//        System.out.println(ob.solve(5, 4, "abppprrr"));

//            t--;
//        }
//		System.out.println();
    }
//} // } Driver Code Ends


//User function Template for Java

//class Solution1 {

    static long solve(int X, int Y, String S) {
        long answer = 0;
        String a = "pr";
        String b = "rp";
        if (X < Y) {
            int t1 = X;
            X = Y;
            Y = t1;

            String t2 = a;
            a = b;
            b = t2;
        }
        LinkedList<Character> st = new LinkedList<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (st.size() > 0 && S.charAt(i) == a.charAt(0) && st.peekLast() == a.charAt(1)) {
                st.pollLast();
                answer += X;
            } else {
                st.addLast(S.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        while (st.size() > 0) {
            str.append(st.pollLast());
        }
        S = str.toString();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (st.size() > 0 && S.charAt(i) == b.charAt(0) && st.peekLast() == b.charAt(1)) {
                st.pollLast();
                answer += Y;
            } else {
                st.addLast(S.charAt(i));
            }
        }
        return answer;
    }
    /*static long solve(int X,int Y, String S)
	{

	    int len = S.length();
	    String SA = S;
	    String SB = S;
	    int tmpLenA = len;
	    int tmpLenB = len;
	    int countA = 0;
	    int countB = 0;
	    while(true){
			SA = SA.replace("pr","");
	        if(tmpLenA ==SA.length()){
	            break;
	        }
	        if(tmpLenA-2 == SA.length()){
	            tmpLenA = SA.length();
	            countA++;
	        }
	    }
	    while(true){
			SB = SB.replace("rp","");
	        if(SB.length() ==tmpLenB){
	            break;
	        }
	        if(tmpLenB-2 == SB.length()){
	            tmpLenB = SB.length();
	            countB++;
	        }
	    }
	    return countA*X + countB*Y;
	}*/
} 
