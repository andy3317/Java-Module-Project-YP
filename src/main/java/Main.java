import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Automobile> listOfAuto = new ArrayList<>();

    public static void main(String[] args) {

        // Получаем список участников
        for (int i = 1; i <= 3; i++) {
            GetUserData(i);
        }
        // Вычисляем победителя и выводим результат
        WhoIsWinner winner = new WhoIsWinner(listOfAuto);
        winner.ThisIsAWinner();
        System.out.println("Победитель этой непростой гонки автомобиль " + winner.ThisIsAWinner() +"!\n" +
                           " Поздравляем нового Чемпиона!!!");

    }

    public static void GetUserData(int member) {
        String autoBrand;
        int autoSpeed;

        System.out.print("Введите марку машины - " + member + "-ого участника соревнований: ");
        autoBrand = scanner.nextLine();

        System.out.print("Введите скорость машины: ");
        while(true) {
            autoSpeed = scanner.nextInt();
            if ((autoSpeed > 0) && (autoSpeed <= 250)) {
                break;
            } else {
                System.out.print("Вы ввели неверную скорость. Введите скорость машины в пределах от 0 до 250 включительно: ");
            }

        }

        // Так как scanner.nextInt() не читает конец строки, добавляем команду,
        // Чтобы не было пропусков запросов.
        scanner.nextLine();
        // Добавляем участника в список
        listOfAuto.add(new Automobile( autoBrand, autoSpeed ));

    }

}

