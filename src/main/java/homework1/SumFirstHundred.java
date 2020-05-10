package homework1;

//Calculate the sum of the first 100 numbers higher than 0
public class SumFirstHundred {
    public static void main(String[] args) {

        int a=-50;
        int sum=0;

        whileLoop(a, sum);
        forLoop(a, sum);
    }

    private static void whileLoop(int a, int sum) {
        while (a<=50) {
            sum += a;
            a++;
        }
    System.out.println("The sum of first 100 numbers is: "  + sum);
    }

    private static void forLoop(int a, int sum) {
        for(a = 1; a <= 100; a++) {
            sum += a;
        }
    System.out.println("The sum of first 100 numbers is: " + sum);
    }
}
