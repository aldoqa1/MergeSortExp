import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] numbers = new int[] {5,3,4,6,3,145,43,3};

        int []sorted = mergeSort(numbers);

        for(int number : sorted){
            System.out.println(number);
        }
    }

    public static int[] divide(int[] arr, int start, int end) {

        if(end - start >=2) {

            int half = (end+start)/2;
            return merge(divide(arr, start, half), divide(arr, half, end));

        }else{

                return  Arrays.copyOfRange(arr,start,end);

        }

    }

    public static int[] merge(int[] arr1, int[] arr2) {

        int[] newArray = new int[arr1.length + arr2.length];
        int count1 = 0;
        int count2 = 0;

        do{

            if(count1 == arr1.length){
                newArray[count1 + count2] = arr2[count2];
                count2++;
                continue;
            }

            if(count2 == arr2.length){
                newArray[count1 + count2] = arr1[count1];
                count1++;
                continue;
            }

            if (arr1[count1] <= arr2[count2]) {
                newArray[count1 + count2] = arr1[count1];
                count1++;
            } else {
                newArray[count1 + count2] = arr2[count2];
                count2++;
            }

        }while((count1+count2) < newArray.length);

        return newArray;
    }

    public static int[] mergeSort(int[] arr) {
        return divide(arr, 0, arr.length);
    }
}