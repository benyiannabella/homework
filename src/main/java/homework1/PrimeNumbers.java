package homework1;

//Display all the prime numbers lower than a given number
public class PrimeNumbers {
    public static void main(String[] args) {
        int num = 1;
        int prime = 0;

        System.out.println("Prime numbers lower than 100: ");
        while(num <= 100) {
            if (num % 2 != 0) {
                prime = num;
                System.out.print(prime + ", ");
            }
            num++;
        }
    }
}
