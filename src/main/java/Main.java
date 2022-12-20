import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        People.people();
    }

    public static class Calculate {
        public static double count = 0;
        public static double sum;
        public static String productList;

        public static void calculate() {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите продукт ");
                String product = scanner.next();
                productList = productList + " " + product;
                System.out.println("Введите стоимость рубли и копейки");
                try {
                    double cost = scanner.nextDouble();
                    System.out.println(product + " добавлено:)");
                    count = count + cost;
                } catch (Exception ex) {
                    System.out.println("При вводе стоимости возникла следующая ошибка: " + ex.getMessage());
                    continue;
                }

                System.out.println("Стоимость плюс " + count);
                System.out.println("Хотите добавить?");
                String stop = scanner.next();
                String stop1 = "Нет";

                sum = count / People.quest;
                if (stop1.equalsIgnoreCase(stop)) {
                    Result.result();
                    return;
                }

            }
        }
    }

    public static class People {
        public static int quest;

        public static void people() {
            while (true) {
                System.out.println("Как много у вас гостей?");
                Scanner scanner = new Scanner(System.in);
                try {
                    quest = scanner.nextInt();
                } catch (Exception ex) {
                    System.out.println("При вводе количества гостей возникла следующая ошибка: " + ex.getMessage());
                    continue;
                }
                if (quest <= 1) {
                    System.out.println("Плати сам за все!");
                } else if (quest >= 2) {
                    Calculate.calculate();
                    break;
                }
            }
        }
    }


    public static class Result {
        public static String result() {
            System.out.println("Всего блюд заказано: " + Calculate.productList);
            System.out.printf("Окончательный расчет: " + ":%.2f\n", Calculate.count);
            String suffix;
            //double costGeneral = 0;
            int num100 = (int) (Math.floor(Calculate.count % 100));
            if (num100 > 4 && num100 < 21) {
                suffix = " Рублей";
            } else {
                int num10 = num100 % 10;
                if (num10 == 1) {
                    suffix = " Рубль";
                } else if (num10 > 1 && num10 < 5) {
                    suffix = " Рубля";
                } else {
                    suffix = " Рублей";
                    System.out.printf("Каждый должен заплатить: " + "%.2f" + suffix, Calculate.sum);
                }

            }
            return suffix;
        }
    }
}

