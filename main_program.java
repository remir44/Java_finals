import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main_program {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Asus", "4", "1000", "Windows", "blue");
        Notebook nb2 = new Notebook("Asus", "4", "1000", "Linux", "black");
        Notebook nb3 = new Notebook("Asus", "4", "2000", "Windows", "black");
        Notebook nb4 = new Notebook("Asus", "16", "1000", "Windows", "grey");
        Notebook nb5 = new Notebook("Huawei", "8", "1000", "Windows", "black");

        Set<Notebook> notebooks = new HashSet<>(List.of(nb1, nb2, nb3, nb4, nb5));
        Map<String, String> sel = selectCriteria();
        sortOptions(sel, notebooks);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> selectCriteria() {
        System.out.println("Приветсвуем в нашем магазине техники! Предлагаем вам посмотреть наши ноутбуки.");
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
            System.out
                    .println("Если вас интересует что-то конкретное, введите 'yes', если нет, нажмите любую клавишу: ");
            String question = scanner();
            if (question.equals("yes")) {
                System.out.println(
                        "Введите цифру, соответствующую необходимому критерию: \n 1 - Название \n 2 - ОЗУ \n 3 - Объем ЖД \n 4 - Операционная система \n 5 - Цвет");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();
                resultCriterias.put(key, value);
            } else {
                break;
            }
        }
        return resultCriterias;
    }

    public static void sortOptions(Map<String, String> criterias, Set<Notebook> notebooks) {

        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) {
            for (Object pair : criterias.keySet()) {
                if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                for (Object pair1 : criterias.keySet()) {
                    if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                        temp.remove(notebook);
                    }
                    for (Object pair2 : criterias.keySet()) {
                        if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                            temp.remove(notebook);
                        }
                        for (Object pair3 : criterias.keySet()) {
                            if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                                temp.remove(notebook);
                            }
                            for (Object pair4 : criterias.keySet()) {
                                if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                                    temp.remove(notebook);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (temp.isEmpty()) {
            System.out.println("К сожалению, того, что вы ищете, нет у нас в наличии.");
        } else {
            System.out.println("Вот что мы можем предложить: \n" + temp.toString());
        }
    }
}