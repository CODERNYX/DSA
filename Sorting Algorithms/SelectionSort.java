import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int smallest = i;
            for(int j= i+1; j<arr.length;j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {100,64,53,20,36};
        selectionSort(arr);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
