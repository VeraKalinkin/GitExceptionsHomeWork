import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        try {
            numberFourException(number);
        } catch (UnluckyNumberException une){
            System.out.println(une.getMessage());
        }
    }

    public static void numberFourException(int number) throws UnluckyNumberException{
        if (number == 4)
            throw new UnluckyNumberException();
    }
}