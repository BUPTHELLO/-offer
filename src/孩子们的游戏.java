import java.util.LinkedList;
import java.util.Queue;

//从这里开始
public class 孩子们的游戏 {
    public static int LastRemaining_Solution(int n, int m) {
        Queue<Integer> res = new LinkedList<>();
        for(int i=0;i<n;i++){
            res.add(i);
        }

        int count = 0;
        while(res.size()>1){
            int temp = res.poll();
            count++;
            if(count % m == 0){
                count = 0;
            }else{
                res.add(temp);
            }
        }
        return res.size() == 1? res.poll():-1;
    }
    public static void main(String[] args) {
        LastRemaining_Solution(5,3);
    }
}
