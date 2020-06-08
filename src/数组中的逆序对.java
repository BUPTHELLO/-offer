public class 数组中的逆序对 {

    private int sum = 0;
    public void MergeSort(int[] arr,int L,int R){
        if (L>=R) return;

        int mid = L+(R-L>>1);
        MergeSort(arr,L,mid);
        MergeSort(arr,mid+1,R);
        Merge(arr,L,mid,R);

    }

    private void Merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R-L+1];
        int i = L;
        int j = mid+1;
        int k=0;

        while (i<=mid && j<=R){
            if (arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
                this.sum++;
            }
        }

        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while (j<=R){
            temp[k++] = arr[j++];
        }

        for (int ii=0;ii<temp.length;ii++){
            arr[L+ii] = temp[ii];
        }

    }

    public static void main(String[] args) {

    }
}
