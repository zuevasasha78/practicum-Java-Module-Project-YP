import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private int amountOfPeople;

    public Calculator(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    private Scanner scanner = new Scanner(System.in);
    private List<Goods> goodsList = new ArrayList<>();

    public void requestData() {
        while (true) {
            System.out.println("Введите имя товара");
            String nameOfGoods = scanner.next();
            if (nameOfGoods.equalsIgnoreCase("ЗАВЕРШИТЬ")) {
                break;
            }

            System.out.println("Введите цену товара в формате 'рубли.копейки' например 10.40");

            double priceOfGoods;
            while (true) {
                if (!scanner.hasNextDouble()) {
                    System.out.println("Некорректная цена товара. Введите цену товара в формате 'рубли.копейки' например 10.40");
                    scanner.next();
                } else {
                    priceOfGoods = scanner.nextDouble();
                    if (priceOfGoods > 0) {
                        break;
                    } else {
                        System.out.println("Некорректная цена товара. Цена товара должна быть больше 0" +
                            " Введите цену товара в формате 'рубли.копейки' например 10.40");
                    }
                }
            }

            goodsList.add(new Goods(nameOfGoods, priceOfGoods));

            System.out.println(String.format("Your goods %s with price %.2f was added", nameOfGoods, priceOfGoods));
        }
    }

    public void calculate() {
        System.out.println("Добавленные товары:");
        double totalAmount = 0;

        for (Goods goods : goodsList) {
            double pricePerPerson = goods.price / amountOfPeople;
            totalAmount += pricePerPerson;

            System.out.println(String.format("Цена за %s на челока %.2f %s",
                goods.name, pricePerPerson, rubPlurals(pricePerPerson)));
        }
        System.out.println(String.format("Полная сумма на человека : %.2f %s", totalAmount, rubPlurals(totalAmount)));
    }

    private String rubPlurals(double num) {
        int numInt = (int) Math.floor(num);
        int preLastDigit = numInt % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }

        int lastDigit = numInt % 10;
        return switch (lastDigit) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }
}
