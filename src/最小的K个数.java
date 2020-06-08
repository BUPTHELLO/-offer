import java.util.*;

public class 最小的K个数 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k>input.length) return res;

        for(int i=0;i<k;i++){
            heapInsert(input,i);
        }

        for(int i=k;i<input.length;i++){
            if(input[0]>input[i]){
                swap(input,0,i);
                adjust(input,0,k);
            }
        }

        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        Collections.sort(res);
        return res;


    }

    private static void heapInsert(int[] arr,int index){
        if(arr == null || arr.length <= 1) return;
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void adjust(int[] arr,int index,int heapsize){
        int left = index*2+1;
        while(left < heapsize){
            int largest = (left+1<heapsize) && (arr[left+1]>arr[left]) ? left+1 : left;
            largest = arr[index]<arr[largest] ? largest:index;
            if(largest == index)
                break;
            swap(arr,index,largest);
            index = largest;
            left = 2*index+1;
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static ArrayList<Integer> test(int [] input, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k>input.length) return res;

        Queue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2) return -1;
                else return 1;
            }
        });

        for (int i=0;i<input.length;i++){
            if (i<k){
                q.add(input[i]);
            }else {
                int temp = q.poll();
                temp = temp>input[i] ? input[i] : temp;
                q.add(temp);

            }
        }


        for (int i=0;i<k;i++){
            res.add(q.poll());
        }
        Collections.sort(res);
        return res;

    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(arr,4);
        test(arr,4);


    }



    private int[] help(int[] arr,int k){
        Queue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1-o2<0)return 1;
                else return -1;
            }
        });

        for(int i=0;i<arr.length;i++){
            if(i<k){
                q.add(arr[i]);
            }else {
                if(arr[i]<q.peek()){
                    q.poll();
                    q.add(arr[i]);
                }
            }
        }

        int[] res = new int[q.size()];
        for(int i=0;i<res.length;i++){
            res[i] = q.poll();
        }
        return res;
    }

}
