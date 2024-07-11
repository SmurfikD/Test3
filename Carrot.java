import java.util.ArrayList;
import java.util.List;

public class Carrot {

    static class Field {
        int weight;
        int count;

        Field(int weight, int count) {
            this.weight = weight;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        List<Field> fields = new ArrayList<>();
        fields.add(new Field(1, 10)); // первая полянка
        fields.add(new Field(2, 10)); // вторая полянка
        fields.add(new Field(3, 10)); // третья полянка
        fields.add(new Field(4, 10)); // четвертая полянка
        fields.add(new Field(5, 10)); // пятая полянка

        int maxWeight = 5; // максимальный вес, который может нести заяц за одну ходку
        int ways = 10; // количество ходок

        System.out.println("Максимальная масса моркови, которую можно перенести: "
                           + maxCarrotWeight(fields, maxWeight, ways));
    }

    public static int maxCarrotWeight(List<Field> fields, int maxWeight, int trips) {
        int amount = 0;

        for (int i = 0; i < trips; i++) {
            int currentWeight = 0;

            // Проходим по полянкам, начиная с самой тяжелой моркови
            for (int j = fields.size() - 1; j >= 0; j--) {
                while (fields.get(j).count > 0 && currentWeight + fields.get(j).weight <= maxWeight) {
                    currentWeight += fields.get(j).weight;
                    fields.get(j).count--;
                }

                if (currentWeight == maxWeight) {
                    break;
                }
            }

            amount += currentWeight;
        }

        return amount;
    }
}
