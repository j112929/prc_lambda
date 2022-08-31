package codesignal;

public class Task3_2 {
    public static void main(String[] args) {

    }

    public static char[][] rotateTheBox(char[][] box) {
        // 思路：从右往的遍历，统计碰到的empty的个数，直到遇到stone后重新清零，最后将整个数据旋转90即可
        if (box == null || box[0] == null || box[0].length == 0) {
            return new char[0][];
        }

        char empty = '.';
        char obstacle = '*';
        char stone = '#';

        int m = box.length;
        int n = box[0].length;
        for (int i = 0; i < m; i++) {
            int emptyCount = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == empty) {
                    emptyCount++;
                } else if (box[i][j] == stone) {
                    box[i][j] = empty;
                    box[i][j + emptyCount] = stone;
                } else if (box[i][j] == obstacle) {
                    emptyCount = 0;
                }
            }
        }

        // 旋转数组，从下往上每行竖直（从左往右竖直）
        char[][] res = new char[n][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }
        return res;
    }

    public static char[][] rotateTheBox2(char[][] box) {
//                def solution(board):
        /*directions = [(1, 0),(0, 1)]
        def dfsRight (row, col, isFromUp):
        m = len(res)
        n = len(res[0])

        if row< 0 or col <0:
        return
        if col >= n:
        res[row][col - 1] = "#"
        return
        if row >= m:
        res[row - 1][col] = "#"
        return

        if res[row][col] == "*" or res[ row][col] =="#":
        if isFromUp:
        res[row - 1][col] = "#"
            else:
        res[row][col - 1] = "#"
        return

                res[row][col] = "."
        dfsRight(row, col + 1, False)

        def dfsDown (row, col, isFromUp):
        m = len(res)
        n = len(res[0])

        if row< 0 or col <0:
        return
        if col >= n:
        res[row][col - 1] = "#"
        return
        if row >= m:
        res[row - 1][col] = "#"
        return

        if res[row][col] == "*" or res[ row][col] =="#":
        if isFromUp:
        res[row - 1][col] = "#"
            else:
        res[row][col - 1] = "#"
        return

                res[row][col] = "."
        dfsDown(row + 1, col, True)


        res = board[:]
        m = len(board)
        n = len(board[0])
        for i in range(m):
        for j in range(n):
        if res[i][j] == "#":
        res[i][j] = "."
        dfsRight(i, j, False)

        print(res)

        for i in range(m):
        for j in range(n):
        if res[i][j] == "#":
        res[i][j] = "."
        dfsDown(i, j, True)

        return res

        board = [
            ['.', '#', '.', '.', '.'],
            ['.', '.', '.', '.', '.'],
            ['#', '.', '#', '#', '.'],
            ['.', '.', '.', '.', '#']]
        print(solution(board))*/
        return new char[0][0];
    }

}
