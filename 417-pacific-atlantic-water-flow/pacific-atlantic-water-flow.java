class Solution{
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int rows=heights.length, cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];

        for(int r=0;r<rows;r++){
            dfs(heights,pacific,r,0);
            dfs(heights,atlantic,r,cols-1);
        }
        for(int c=0;c<cols;c++){
            dfs(heights,pacific,0,c);
            dfs(heights,atlantic,rows-1,c);
        }

        List<List<Integer>> result=new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited,int r,int c){
        visited[r][c]=true;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:directions){
            int nr=r+dir[0], nc=c+dir[1];
            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length
               && !visited[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(heights,visited,nr,nc);
            }
        }
    }
}
