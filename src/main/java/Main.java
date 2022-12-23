import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        People.people();
    }

    public static class Calculate {
        public static double count = 0;// Изначально начинаем считать с 0
        public static double sum; // это числа с двойной точностью, максимально приближённые к заданным
        public static String productList; // Класс продакт лист объявили

        public static void calculate() {
            while (true) { // Создаем цикл
                Scanner scanner = new Scanner(System.in);// Создаем объект класса Scaner
                System.out.println("Введите продукт ");//Ввод с клавиатуры
                String product = scanner.next(); // Присваевыеам переменный ввод с клавиатуры
                productList = productList + " " + product; // Список заказов (продуктов)
                System.out.println("Введите стоимость рубли и копейки");
                try {
                    double cost = scanner.nextDouble();
                    System.out.println(product + " добавлено:)");
                    count = count + cost;
                } catch (Exception ex) {
                    System.out.println("При вводе стоимости возникла следующая ошибка: " + ex.getMessage());
                    continue;
                }

                System.out.println("Стоимость плюс " + count);// Вывод поля  + стоимость
                System.out.println("Хотите добавить?");
                String stop = scanner.next();
                String stop1 = "Нет"; // При вводе нет конец цикла

                sum = count / People.quest;  // Делим общюю суммму на количество участников
                if (stop1.equalsIgnoreCase(stop)) { //Условие при котором
                    Result.result();
                    return;
                }

            }
        }
    }

    public static class People { // Создали класс
        public static int quest; // Ввод переменной количества гостей

        public static void people() {
            while (true) {// Запускаем цикл
                System.out.println("Как много у вас гостей?"); // Ввод с клавиатуры количества гостей
                Scanner scanner = new Scanner(System.in);
                try {
                    quest = scanner.nextInt();
                } catch (Exception ex) { // определяем блок кода в котором происходит обработка исключения
                    System.out.println("При вводе количества гостей возникла следующая ошибка: " + ex.getMessage());
                    continue;
                }
                if (quest <= 1) {// При вводе 1 система выдаст ошибку
                    System.out.println("Плати сам за все!");
                } else if (quest >= 2) { // Иначе наченаем "калькулировать", гостей
                    Calculate.calculate();
                    break;
                }
            }
        }
    }


    public static class Result {
        public static String result() {// Ввводим класс результат
            System.out.println("Всего блюд заказано: " + Calculate.productList); // Калькулируем заказаные блюда
            System.out.printf("Окончательный расчет: " + ":%.2f\n", Calculate.count); // Вывод окончательного расчета с переносом строки
            String suffix;
            //double costGeneral = 0;
            int num100 = (int) (Math.floor(Calculate.count % 100)); // Для определения суффикса)падежа) нужно проверить 1-2 последние числа.Возвращает блтжайщее число
            if (num100 > 4 && num100 < 21) {// Условие если вывод больше 4 и менее 21 суффикс выводиться как "Рублей"
                suffix = " Рублей";
            } else { //Иначе если окончание на единицу то суффикс "Рубль"
                int num10 = num100 % 10;
                if (num10 == 1) {
                    suffix = " Рубль";
                } else if (num10 > 1 && num10 < 5) { // Если больше 1 и меньше 5 выводит "Рубля"
                    suffix = " Рубля";
                } else {
                    suffix = " Рублей";
                    System.out.printf("Каждый должен заплатить: " + "%.2f" + suffix, Calculate.sum);
                }

            }
            return suffix; // Возвращаем
        }
    }
}