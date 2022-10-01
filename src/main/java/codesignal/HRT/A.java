package codesignal.HRT;

import java.util.*;

public class A {
    public static void main(String[] args) {

    }

    static boolean addEven(boolean[][] graph) {
        int odd = 0;
        List<Integer> odd_vertices = new ArrayList<Integer>();

        for (int i = 0; i < graph.length; i++) {
            int deg = 0;
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == true) {
                    deg++;
                }
            }
            if (deg % 2 == 1) {
                odd++;
                odd_vertices.add(i);
            }
        }
// Given that we have at most 2 new edges to be added the number of odd nodes should not be more than 2
        if (odd == 0) {
            return true;
        } else if (odd == 2) {
            int a = odd_vertices.get(0);
            int b = odd_vertices.get(1);
            for (int k = 0; k < graph.length; k++) {
                if (!graph[a][k] && !graph[b][k]) {
                    return true;
                }
            }
            return false;
        } else if (odd == 4) {
            int a = odd_vertices.get(0);
            int b = odd_vertices.get(1);
            int c = odd_vertices.get(2);
            int d = odd_vertices.get(3);
            return (!graph[a][b] && !graph[c][d]) ||
                    (!graph[a][c] && !graph[b][d]) ||
                    (!graph[a][d] && !graph[b][c]);
        } else {
            return false;
        }
    }
}
