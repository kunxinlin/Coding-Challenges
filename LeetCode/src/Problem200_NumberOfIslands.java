public class Problem200_NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }

    static public int numIslands(char[][] grid) {
        int count = 0;

        //loop through the whole grid
        //when we encounter a 1, we zero out all the ones connected to it
        //increment island count by 1
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    count++;
                }
        }
        return count;
    }

    //recursive goes through all the neighboring 1s and zero them out
    private static void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j); //down
        DFSMarking(grid, i - 1, j); //up
        DFSMarking(grid, i, j + 1); //right
        DFSMarking(grid, i, j - 1); //left
    }
}
