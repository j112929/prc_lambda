package AB;

import java.util.Arrays;
import java.util.List;

public class B {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("o/", "w/", "e/", "./", "./", "./");
//                "x/","y/","../","z/","./");
//                "o/","w/","e/","./","./","./");
        System.out.println(mini(list));
    }

    public static int mini(List<String> list) {
        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);

            if (str.equals("../")) {
                ans--;
            }
            if (!str.equals("./") && !str.equals("../")) {
                ans++;
            }

        }
        return ans;
    }
}
