import java.util.Random;

public class Matrix {
    private int n,m;
    private int[][] map;
    private boolean[][] visited;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j = 0; j<m; j++)
            {
                visited[i][j] = false;
                Random rand = new Random();
                map[i][j] = rand.nextInt(2);;
            }
    }

    public void printMatrix() {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
