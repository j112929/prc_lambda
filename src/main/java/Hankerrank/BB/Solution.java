package Hankerrank.BB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'getRelevantFoodOutlets' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<
     * pageNumber>
     *
     * The function is expected to return an array of strings.
     *
     * The function accepts a city argument (String) and maxCost argument(Integer).
     */

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) {
        int i = 1;
        String path = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=";
        List<String> ans = new ArrayList<>();
        while (true) {
            try {
                // if(ans.size()==2){
                // break;
                // }
                String resp = req(path + i);
                if (resp.isEmpty()) {
                    break;
                }
                Object obj = new JSONParser().parse(resp);
                // System.out.println(obj);
                JSONObject json = (JSONObject) obj;
                JSONArray data = (JSONArray) json.get("data");
                if (data.size() == 0)
                    break;
                Iterator itr2 = data.iterator();

                while (itr2.hasNext()) {
                    Map<String, Object> map = (Map) itr2.next();
                    if (map.get("city").equals(city) && ((long) map.get("estimated_cost")) <= maxCost) {
                        ans.add(map.get("name") + "");
                        System.out.println(map.get("name"));
                    }

                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return ans;
    }

    public static String req(String path) {
        HttpURLConnection client = null;
        try {
            URL url = new URL(path);
            client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("GET");
            client.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            StringBuffer resp = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                resp.append(inputLine);
            }
            in.close();
            return resp.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String city = bufferedReader.readLine();

        int maxCost = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.getRelevantFoodOutlets(city, maxCost);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
