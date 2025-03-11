import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("Enter a number: ");

        while (!flag){

        flag = true;
        int number = scanner.nextInt();

        try {
            numberFourException(number);
        } catch (UnluckyNumberException une){
            flag = false;
            System.out.println(une.getMessage());
            System.out.println("Please try again");
        }

        }

        System.out.println("Good choice!");
        scanner.close();
    }

    public static void numberFourException(int number) throws UnluckyNumberException{
        if (number == 4)
            throw new UnluckyNumberException();
    }
}