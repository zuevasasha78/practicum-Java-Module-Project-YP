import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("How much people in your bill? ");

            Scanner scanner = new Scanner(System.in);
            int amountOfPeople = scanner.nextInt();

            if (amountOfPeople == 1) {
                System.out.println("You should pay the bill by yourself.");
            } else if (amountOfPeople < 1) {
                System.out.println("It is the wrong amount of people. The Amount of people should be bigger than 1.");
            } else {
                Calculator calculator = new Calculator(amountOfPeople);
                calculator.requestData();
                calculator.calculate();
                break;
            }

        }
    }
}
