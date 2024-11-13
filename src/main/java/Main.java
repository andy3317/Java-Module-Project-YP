import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //private static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Automobile> listOfAuto = new ArrayList<>();

    public static void main(String[] args) {

        // Получаем список участников
        for ( int i = 1; i <= 3; i++ ) {
            GetUserData(i);
        }
        // Вычисляем победителя и выводим результат
        WhoIsWinner winner = new WhoIsWinner(listOfAuto);
        winner.ThisIsAWinner();
        System.out.println("Победитель этой непростой гонки автомобиль " + winner.ThisIsAWinner() + "!\n" +
                "Поздравляем нового Чемпиона!!!");

    }

    public static void GetUserData(int member) {
        String autoBrand = "";
        String autoSpeedAsStr = "";
        int autoSpeed = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите название машины - " + member + "-ого участника соревнований: ");

        while (true) {
            autoBrand = scan.nextLine();
                if (!autoBrand.trim().isEmpty() ) {
                    boolean isPresent = false;
                    for ( int i = 0; i < listOfAuto.size() ; i++ ) {
                        if (listOfAuto.get(i).autoBrand.equals(autoBrand)) {
                           isPresent = true;
                           break;  // break для цикла for
                        }
                    }
                    // Пройдены следующие проверки на ввод названия машины:
                    //    Введено не пустое значение
                    //    Введеное название не было введено ранее. Уникальность важна для определения победителя
                    if (!isPresent) {
                        break;  // break для цикла while
                    } else {
                        System.out.print("Такой участник уже есть. ");
                    }
                }
            System.out.print("Введите, пожалуйста, название автомобиля для регистрации в системе " + member + "-ого участника соревнований: ");
        }

        System.out.print("Введите скорость машины: ");
        while (true) {
            autoSpeedAsStr = scan.nextLine();
            if (autoSpeedAsStr.matches("[0-9]+") && (autoSpeedAsStr.length() < 4 ) ) {
                autoSpeed = Integer.parseInt(autoSpeedAsStr);
                if ( ( autoSpeed > 0) && (autoSpeed <= 250) ) {
                    // Пройдены следующие проверки на ввод скорости:
                    //    Введено только числовое значение
                    //    Введено трехзначное значение
                    //    Введено значение в рамках диапазона техзадания
                    break;
                }
            }
            System.out.print("Вы ввели неверную скорость. Введите скорость машины в пределах от 0 до 250 включительно: ");
        }

        // Добавляем участника в список
        listOfAuto.add(new Automobile(autoBrand, autoSpeed));
    }

}


