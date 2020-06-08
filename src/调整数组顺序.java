import java.util.ArrayList;

//时间复杂度O（n），空间复杂度O(n)
public class 调整数组顺序 {

    public static void reOrderArray(int [] array) {

        ArrayList<Integer> res = new ArrayList<>();
//        ou
        ArrayList<Integer> res1 = new ArrayList<>();

        for (int i = 0;i<array.length;i++){
            if (array[i] % 2 == 0)
                res.add(array[i]);
            else
                res1.add(array[i]);
        }

        res1.addAll(res);

        for (int i=0;i<array.length;i++){
            array[i] = res1.get(i);
        }

    }

    public static void main(String[] args) {

    }
}
