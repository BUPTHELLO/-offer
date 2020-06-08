public class 数组中重复数字 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i=0;i<length;i++){
            while(numbers[i]!=numbers[numbers[i]]){
                swap(numbers,i,numbers[i]);
            }
        }
        for(int i=0;i<length;i++){
            if(i!=numbers[i]){
                duplication[0] = numbers[i];
                return true;
            }

        }
        return false;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
