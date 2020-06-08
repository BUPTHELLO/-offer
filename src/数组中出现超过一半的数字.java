import java.util.HashMap;

public class 数组中出现超过一半的数字 {

//    arr[i] is key, time is value
    public static int MoreThanHalfNum_Solution(int [] array) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (map.containsKey(array[i])){
                int times = map.get(array[i]);
                times++;
                map.put(array[i],times);
            }else{
                map.put(array[i],1);
            }
        }

        for (int i=0;i<array.length;i++){
            if (map.get(array[i]) > (array.length/2))
                return array[i];
        }

        return 0;
    }
    public static void main(String[] args) {

    }
}
