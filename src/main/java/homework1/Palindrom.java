package homework1;

//Check if a number is palindrom( e.g palindrom 1221, 34143)
public class Palindrom {

    public static void main(String[] args) {
        int num = 2332;
        int mirror = 0;

        while (num > 0) {
            mirror = mirror * 10 + num % 10;
            num /= 10;
        }

        num = 2332;
        if (mirror == num) {
            System.out.println("The number " + mirror + " is palindrom!");
        } else {
            System.out.println("The number " + mirror + " is NOT palindrom");
        }
    }
}
