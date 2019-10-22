import jdk.internal.net.http.common.Pair;

import java.util.LinkedList;
import java.util.Queue;
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

    public int findBiggestIslandDFS() {
        int max = 0;
        int islandSize;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && visited[i][j] == false) {
                    islandSize = 0;
                    islandSize = visitIsland(i,j,islandSize);
                    if(islandSize > max)
                        max = islandSize;
                }

            }
        }
        return max;
    }

    public int visitIsland(int i, int j, int islandSize) {
        visited[i][j] = true;
        islandSize++;
        for(int k = i-1; k <= i+1; k++) {
            for(int l = j-1; l <= j+1; l++)
            {
                if(k >= 0 && k < n && l >= 0 && l < m) {
                    if(map[k][l] == 1 && visited[k][l] == false) {
                        islandSize = visitIsland(k,l,islandSize);
                    }
                }
            }
        }
        return islandSize;
    }

    /*public int findBiggestIslandBFS() {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {

                    }
                }
            }
        }
    }
*/
    public void rekurencja(int i) {
        if(i == 0) return;
        rekurencja(i-1);
    }
}