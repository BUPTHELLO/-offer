public class 把数组排成最小的数 {
//    冒泡排序的思路
    public static String PrintMinNumber(int [] numbers) {
        StringBuilder res= new StringBuilder();

        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                String s12 = String.valueOf(numbers[i]) + String.valueOf(numbers[j]);
                String s21 = String.valueOf(numbers[j]) + String.valueOf(numbers[i]);
                if (Integer.parseInt(s12) > Integer.parseInt(s21))
                    swap(numbers,i,j);
            }
        }
        for (int i=0;i<numbers.length;i++){
            res.append(numbers[i]);
        }

        return res.toString();

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {

    }
}
