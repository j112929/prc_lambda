package Hankerrank.AA;

import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {

        String result = "YES";
        char lastMin = ' ';
        for (int j = 0; j < grid.size(); j++) {
            char[] arr = grid.get(j).toCharArray();
            Arrays.sort(arr);
            // char currentChar = arr[0];
            if (arr[0] < lastMin) {
                result = "NO";
                break;
                // return "NO";
            } else {
                lastMin = arr[0];
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }

}


