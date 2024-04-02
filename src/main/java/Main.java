import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Сколько человек в счете? ");

            Scanner scanner = new Scanner(System.in);
            Integer amountOfPeople = null;

            while (amountOfPeople == null) {
                try {
                    amountOfPeople = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Некоррекное число людей в счете. Это не целое число.");
                    scanner.next();
                }
            }

            if (amountOfPeople == 1) {
                System.out.println("Вы должны заплатить за себя");
            } else if (amountOfPeople < 1) {
                System.out.println("Некоррекное число людей в счете. Число людей должно быть больще 1");
            } else {
                Calculator calculator = new Calculator(amountOfPeople);
                calculator.requestData();
                calculator.calculate();
                break;
            }

        }
    }
}
