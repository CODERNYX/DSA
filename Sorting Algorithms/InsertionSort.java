import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        int j = 0;
        for(int i=1 ; i<arr.length; i++){
            int current = arr[i];
            j = i-1;
            while(j>=0 && current < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {100,64,53,20,36};
        insertionSort(arr);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
