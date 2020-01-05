package homework1;

// Display the smallest number from an array of number
public class SmallestInArray {
    public static void main(String[] args) {
        int[] num = new int[] {62,5,14,81,7};
        int smallest = num[0];

        forSmallest(num, smallest);
    }

    private static void forSmallest(int[] num, int smallest) {
        for(int a = 0; a < num.length; a++) {
            if(num[a]<smallest) {
                smallest = num[a];
            }
        }
        System.out.println("The smallest number in the array is: "+ smallest);
    }
}
