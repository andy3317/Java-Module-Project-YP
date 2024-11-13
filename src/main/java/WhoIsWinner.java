import java.util.ArrayList;

public class WhoIsWinner {

    private final ArrayList<Automobile> listAuto;
    // Конструктор получает параметром список участников
    public WhoIsWinner(ArrayList<Automobile> listOfAuto) {
       this.listAuto = listOfAuto;
    }

    // Метод вычисления победителя, возвращает марку автомобиля.
    public String ThisIsAWinner() {
        int distance = 0;
        int maxDistance = 0;
        String brandWinner = "";
        // Проходим forEach по списку участников и сравниваем скорости
        for (Automobile i : listAuto) {
            // Расстояние пройденное автомобилем под указателем forEach
            distance = i.autoSpeed * 24;
            if (distance > maxDistance ){
                maxDistance = distance;
                brandWinner = i.autoBrand;
              // Если победителя более одного (скорости были равны), выводим их тоже
            } else if (distance == maxDistance) {
                brandWinner = brandWinner + " и " + i.autoBrand;
            }
        }
        // Возвращаем марку автомобиля победителя
        return brandWinner;
    }

}
