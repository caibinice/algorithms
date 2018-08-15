package algorithms.leetcode;

import java.util.*;

public class PossibleBipartition {

    /**
     * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
     * <p>
     * Each person may dislike some other people, and they should not go into the same group.
     * <p>
     * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
     * <p>
     * Return true if and only if it is possible to split everyone into two groups in this way.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
     * Output: true
     * Explanation: group1 [1,4], group2 [2,3]
     * Example 2:
     * <p>
     * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
     * Output: false
     * Example 3:
     * <p>
     * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
     * Output: false
     */

    //失败方法
    public boolean possibleBipartitionV0(int N, int[][] dislikes) {
        if (dislikes.length <= N / 2 || N == 1) return true;
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            left.add(i);
            right.add(i);
        }
        for (int i = 0; i < dislikes.length; i++) {
            boolean leftHas0 = left.contains(dislikes[i][0]);
            boolean leftHas1 = left.contains(dislikes[i][1]);
            boolean rightHas0 = right.contains(dislikes[i][0]);
            boolean rightHas1 = right.contains(dislikes[i][1]);
            if (!leftHas0 && !rightHas0) return false;
            if (!leftHas1 && !rightHas1) return false;
            if (!leftHas0 && !leftHas1) return false;
            if (!rightHas0 && !rightHas1) return false;
            if (leftHas0 && rightHas1) {
                left.remove(dislikes[i][1]);
                right.remove(dislikes[i][0]);
            } else if (leftHas1 && rightHas0) {
                left.remove(dislikes[i][0]);
                right.remove(dislikes[i][1]);
            }
        }
        return true;
    }

    //DFS方法
    public boolean possibleBipartitionV1(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) {
                    return false;
                }
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }

    //填色法
    public boolean possibleBipartitionV2(int N, int[][] dislikes) {
        int[] color = new int[N + 1];
        List<List<Integer>> adj = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) adj.add(new ArrayList<Integer>());
        for(int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        for(int i = 1; i <= N; i++) {
            if(color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int nb : adj.get(cur)) {
                        if(color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            q.add(nb);
                        } else {
                            if(color[nb] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{4,7},{4,8},{2,8},{8,9},{1,6},{5,8},{1,2},{6,7},{3,10},{8,10},{1,5},{7,10},{1,10},
                {3,5},{3,6},{1,4},{3,9},{2,3},{1,9},{7,9},{2,7},{6,8},{5,7},{3,4}};
        System.out.println(new PossibleBipartition().possibleBipartitionV1(10, arr));
    }

}
