package honors;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 1;
        }

        int len = arr.length;

        for(int i = 0; i < arr.length; i++) {
            while(arr[i] != i+1) {
                if(arr[i] <= 0 || arr[i] > len || arr[i] == arr[arr[i] - 1]) {
                    break;
                }

                swap(arr, i, arr[i] - 1);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != i + 1) {
                return i+1;
            }
        }
        return arr.length + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,4,-1,5,1,-1};
        System.out.println("first missing positive: " + firstMissingPositive(arr));
    }
}
