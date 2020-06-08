public class 字符串左移 {
//    (A^T B^T)^T = B A
    public static String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0) return str;
        n = n%str.length();
        String s1 = str.substring(0,n);
        String s2 = str.substring(n,str.length());
        s1 = reverse(s1);
        s2 = reverse(s2);
        String res = s1+s2;
        return reverse(res);

    }
    private static String reverse(String s){

        char[] res = s.toCharArray();
        for (int i=0;i<res.length/2;i++){
            swap(res,i,res.length-1-i);
        }
        return String.valueOf(res);
    }

    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
