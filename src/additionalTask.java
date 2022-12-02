/*
Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
 что на 0й позиции каждого внутреннего списка содержится название жанра,
 а на остальных позициях - названия книг.
 Напишите метод для заполнения данной структуры.
 */

import java.util.*;

public class additionalTask {
    public static void main(String[] args) {
        List<ArrayList<String>> arrayListList = new ArrayList<>();
        Map<String, String> library = new HashMap<>();
        library.put("Классическая литература", "Фёдор Достоевский:'Бесы', Фёдор Достоевский: 'Идиот', Николай Гоголь: 'Ревизор'");
        library.put("Бизнесс-книги", "Роберт Макки:'Сториномика',Мерилин Аткинсон: 'Четыре типа мышления'");
        library.put("Детская литература", "Филип Пулман:'Северное сияние', Татьяна Мастрюкова: 'Кошачья голова', Клайв Баркер: 'Похититель вечности'");
        library.put("Фантастика", "Лия Арден:'Невеста ноября', Ти Джей Клун: 'Дом в лазурном море', Скарлетт Сент-Клэр: 'Прикосновение тьмы'");
        String[] keys = library.keySet().toArray(new String[0]);
        ArrayList<String> genre = new ArrayList<>();
        Collections.addAll(genre,keys[0], keys[1], keys[2], keys[3]);
        arrayListList.add(0, genre);
        int maxLength = 0;
        ArrayList<String> literature = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (String s : genre) {
                String[] classic = library.get(s).split(",");
                if (i < classic.length) {
                    if (classic[i].length() > maxLength) {
                        maxLength = classic[i].length();
                    }
                    literature.add((classic[i]));
                } else{
                    literature.add("null");
                }
            }
            arrayListList.add(literature);
            literature = new ArrayList<>();
        }
        for (ArrayList<String> s: arrayListList) {
            for (int j = 0; j < s.size(); j++) {
                if (s.get(j).length() < maxLength) {
                    s.set(j, s.get(j) + " ".repeat(maxLength - s.get(j).length()));
                }
            }
        }
        for (int i = 0; i < arrayListList.size(); i++) {
            if (i == 0) {
                System.out.println("-".repeat(maxLength * 4));
                System.out.println(String.join("| ", arrayListList.get(i)));
                System.out.println("-".repeat(maxLength * 4));
            } else {
                System.out.println(String.join("| ", arrayListList.get(i)));
                System.out.println("-".repeat(maxLength * 4));
            }
        }
    }
}
