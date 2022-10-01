package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class D {
    public static void main(String[] args) {

    }
    //covert LinkedList to ArrayList

    public ArrayList<Integer> convert(LinkedList<Integer> linkedList){
        //1
//        return  new ArrayList<Integer>(linkedList);
        //2
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//        for (int i = 0; i < linkedList.size(); i++) {
//            ans.add(linkedList.get(i));
//        }
//        return ans;
        //3
        return (ArrayList<Integer>) linkedList.stream().collect(Collectors.toList());


    }
}
