import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流中的中位数 {

    private static int total = 0;

//    小根堆，存较大的数字
    private static Queue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1>o2) return 1;
            else return -1;
        }
    });

//    大根堆，存较小的数字
    private static Queue<Integer> big = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1>o2) return -1;
            else return 1;
        }
    });


//    总数是奇数时，总是调节大根堆
//    总数是偶数时，总是调节小根堆

    public static void Insert(Integer num) {
        total++;
        if (total%2 == 1){
            if (small.isEmpty()) big.add(num);
            else {
                if (small.peek()<num){
                    small.add(num);
                    num = small.remove();
                    big.add(num);
                }else {
                    big.add(num);
                }
            }
        }else {
            if (big.peek()>num){
                big.add(num);
                num = big.remove();
                small.add(num);
            }else {
                small.add(num);
            }
        }
    }

    public static Double GetMedian() {
        if (total % 2 == 1)
            return  1.0*big.peek();
        else
            return (big.peek()+small.peek())/2.0;

    }

    public static void main(String[] args) {

    }
}
