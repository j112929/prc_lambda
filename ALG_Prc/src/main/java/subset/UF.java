package subset;

import java.util.*;

class UF {
    public UF() {}

    public static void main(String[] args) {
        int n=4;
        String[] queryType={"Friend","Friend","Total" };
        int[] s1={1,2,1};
        int[] s2={2,3,4};
        UF uf= new UF(n);

//        System.out.println(Arrays.toString(uf.getTheGroup(n,queryType,s1,s2)));
    }
    int[] parent,size;
    int cnt=0;
    public UF(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        cnt=n;
        for (int i = 1; i < n+1; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }
    public List<Integer> getTheGroup(int n, String[] queryType, int[] s1, int[] s2){
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> set=null;
        int max= 0;
        for (int i = 0; i < queryType.length; i++) {
            if(queryType[i].equals("Friend")) {
                if (map.containsKey(s1[i])) {
                    set = map.get(s1[i]);
                }else{
                    set = new HashSet<>();
                }
                set.add(s2[i]);
                map.put(s1[i],set);

                if (map.containsKey(s2[i])) {
                    set = map.get(s2[i]);
                }else{
                    set = new HashSet<>();
                }
                set.add(s1[i]);
                map.put(s2[i], set);
            }else{
                for(Integer k : map.keySet()){
                    max=Math.max(max,map.get(k).size());
                }
            }
        }
        List<Integer> ans =new ArrayList<>();
        ans.add(max+1);
        return ans;

//        UF uf = new UF(n);
//        int cur = 0;
//        int[] ans = new int[n];
//        for (int i = 0; i < queryType.length; i++) {
//            if(queryType[i].equals("Friend")){
//                uf.union(s1[i],s2[i]);
//            }
//            if(queryType[i].equals("Total")){
////                if(uf.connected(s1[i],s2[i])){
////                    return uf.groupSize(s1[i]);
////                }else{
////                    return uf.groupSize(s1[i]) + uf.groupSize(s2[i]);
////                }
//                int x = root(s1[i]), y =root(s2[i]);
//                if(x==y) ans[cur++]=size[x];
//                else ans[cur++] = size[x]+size[y];
//            }
//        }
//        return ans;
    }
    private int root(int a){
        if(a==parent[a]) return  a;
        return parent[a]=root(parent[a]);
    }

    private int groupSize(int x) {
        int root = find(x);
        return size[root];
    }

    private boolean connected(int s1, int s2) {
        int rootP = this.find(s1);
        int rootQ = this.find(s2);
        return rootP==rootQ;
    }

    public void union(int s1, int s2){
        int rootP = this.find(s1);
        int rootQ = this.find(s2);
        if(rootP==rootQ) return;
        if(rootP<rootQ){
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }else{
            parent[rootQ]=rootP;
            size[rootP] +=size[rootQ];
        }
        cnt--;
    }
    public int find(int x){
        while (x!=parent[x]){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }

}