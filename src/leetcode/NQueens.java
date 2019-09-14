import java.util.ArrayList;
import java.util.List;

public class NQueens {

    private int n;
    private int[] colIdx;  // currently occupied column, e.g. second column occupied: colIdx[1] = 1
    private int[] diag;    // diagonal occupied: diag[row + col] = 1
    private int[] anti;    // anti-diagonal:     anti[row - col + n] = 1
    private int[] queens;  // queens[2] = 4, queen on row: 2, col: 4
    private List<List<String>> res;

    public List<List<String>> nqueens(int n) {
        this.n = n;
        colIdx = new int[n];
        diag = new int[2 * n];
        anti = new int[2 * n];
        queens = new int[n];
        res = new ArrayList<>();
        dfs(0);
        return res;
    }

    private void dfs(int row) {

        if (row == n) {
            addSolution();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (underAttack(row, col)) continue;
            addQueen(row, col);
            dfs(row + 1);
            removeQueen(row, col);
        }
    }

    private void addQueen(int row, int col) {
        colIdx[col] = 1;
        diag[row + col] = 1;
        anti[row - col + n] = 1;
        queens[row] = col;
    }

    private void removeQueen(int row, int col) {
        colIdx[col] = 0;
        diag[row + col] = 0;
        anti[row - col + n] = 0;
        queens[row] = 0;
    }

    private boolean underAttack(int row, int col) {
        return colIdx[col] + diag[row + col] + anti[row - col + n] != 0;
    }

    private void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            solution.add(sb.toString());
        }
        res.add(solution);
    }

}