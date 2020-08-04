package com.company.task4;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {

        //Задача 2 Частота букв в тексте
        System.out.println("Задача 2 Частота букв в тексте  ");
        String text = "fhsjg;s jsf;ojlkjlkFFhlj";
        Map<Character, Integer> fraqDic = new TreeMap<>();
        // перводим строку в массив прописных символов
        char[] arrText = text.toLowerCase().toCharArray();
        Character c;
        int count = 0;
        for (int i = 0; i < arrText.length; i++) {
            c = arrText[i];
            count = 0;
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if (fraqDic.containsKey(c)) count = fraqDic.get(c);
                fraqDic.put(c, ++count);
            }
        }
        for (Character key : fraqDic.keySet())
            System.out.printf("%s: частота %d\n", key, fraqDic.get(key));

        // Задача 3 - удаление дубликатов из коллекции
        List<String> myList = new ArrayList<>(Arrays.asList("1","2","3","2","4"));

        for (String s : removeDublicates(myList)) {
            System.out.println(s);
        }

        //Задача 4 поменять местами ключи и значения в MAP
        System.out.println("Задача 4 поменять местами ключи и значения в MAP    ");
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Hana", 13);
        myMap.put("Lana", 2);
        myMap.put("Petr", 13);
        myMap.put("Dana", 15);
        for (Map.Entry<Integer, ArrayList<String>> entry :changeKeyValue(myMap).entrySet()
        ) {
            for (String value : entry.getValue()
            ) System.out.printf("key: %d Value: %s\n", entry.getKey(), value);
        };

        //Задача 5 выбор победителя
        System.out.println("Задача 5 выбор победителя ");
        List<String> strArray = Arrays.asList("Ivan 5", "Petr 3", "Alex 10", "Petr 8",
                "Ivan 6", "Alex 5", "Ivan 1", "Petr 5", "Alex 1");
        Map<String, Integer> mapCompetition = new LinkedHashMap<>();
        String key;
        Integer score;
        String[] keyScore = {"", ""};

        for (String str : strArray
        ) {
            keyScore = str.split(" ");
            if (mapCompetition.containsKey(keyScore[0]))
                score = Integer.parseInt(keyScore[1]) + mapCompetition.get(keyScore[0]);
            else {


                score = Integer.parseInt(keyScore[1]);
            }
            mapCompetition.put(keyScore[0], score);
        }

        for (Map.Entry<String, Integer> entry : mapCompetition.entrySet()
        ) {
            System.out.printf("key: %s Value: %d\n", entry.getKey(), entry.getValue());

        }
        for (Map.Entry<Integer, ArrayList<String>> entry :changeKeyValue(mapCompetition).entrySet()
        ) {
            System.out.println("Победитель:");
            for (String value : entry.getValue()
            ) {
                System.out.printf("key: %d Value: %s\n", entry.getKey(), value);
            break;}
            break;
        };
        


    }


    private static Collection<String> removeDublicates(Collection<String> myList) {
        return new HashSet<>(myList);
    } ;

    private static Map<Integer, ArrayList<String>> changeKeyValue(Map<String, Integer> myMap) {
        Map<Integer, ArrayList<String>> newMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : myMap.entrySet()
        ) {
            if (newMap.containsKey(entry.getValue()))
                newMap.get(entry.getValue()).add(entry.getKey());
            else {
                newMap.put(entry.getValue(), new ArrayList<String>());
                newMap.get(entry.getValue()).add(entry.getKey());
            }
        }
        return newMap;
    }
}
