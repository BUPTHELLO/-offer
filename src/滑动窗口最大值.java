import java.util.*;

//跟最小k个数相似，用堆的思路
public class 滑动窗口最大值 {

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();

        for(int i=0;i<num.length;i++){
            while (!q.isEmpty() && num[q.peekLast()]<=num[i]){
                q.pollLast();
            }
            q.add(i);

            if(q.peekFirst() == i-size){
                q.removeFirst();
            }

            if (i>=size-1){
                res.add(num[q.peekFirst()]);
            }

        }
        return res;
    }

    public static int[] dailyTemperatures(int[] T) {


        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty() && T[stack.peek()]<T[i]){
                int index = stack.pop();

                res[index] = i - stack.peek();
            }

            stack.push(i);
        }
        return res;
    }



    public static void main(String[] args) {
//        int[] num = new int[]{2,3,4,2,6,2,5,1};
//        maxInWindows(num,3);



    }
}
