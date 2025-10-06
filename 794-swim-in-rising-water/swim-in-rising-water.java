

class Solution {
    public int swimInWater(int[][] grid) {
        int gridSize = grid.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[gridSize][gridSize];

        priorityQueue.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!priorityQueue.isEmpty()) {
            int[] currentCell = priorityQueue.poll();
            int maxElevation = currentCell[0];
            int currentRow = currentCell[1];
            int currentCol = currentCell[2];

            if (currentRow == gridSize - 1 && currentCol == gridSize - 1) {
                return maxElevation;
            }

            for (int[] direction : directions) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];

                if (nextRow >= 0 && nextRow < gridSize && nextCol >= 0 && nextCol < gridSize && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    int newMaxElevation = Math.max(maxElevation, grid[nextRow][nextCol]);
                    priorityQueue.offer(new int[]{newMaxElevation, nextRow, nextCol});
                }
            }
        }
        return -1;
    }
}