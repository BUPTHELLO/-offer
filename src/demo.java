import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class demo {
//    public static ArrayList<Integer> Permutation(){
//        Queue<Integer[]> queue = new LinkedList<>();
//    }

    public static int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int res = 0;
        int[] offset_x = new int[]{1,-1,0,0};
        int[] offset_y = new int[]{0,0,1,-1};

        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] temp = queue.remove();
                for(int j=0;j<offset_x.length;j++){
                    int x = temp[0] + offset_x[j];
                    int y = temp[1] + offset_y[j];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            if(!queue.isEmpty())
                res++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    }
}
