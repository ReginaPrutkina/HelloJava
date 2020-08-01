package com.company.task4;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        System.out.println("Задача 1 - ГСМ");
        List<String> inputList =Arrays.asList("C100_1-100", "C200_1-120-1200",
                "C300_1-120-30", "C400_1-80-20",
                "C100_2-50", "C200_2-40-1000",
                "C300_2-200-45", "C400_2-10-20",
                "C100_3-10", "C200_3-170-1100",
                "C300_3-150-29", "C400_3-100-28",
                "C100_1-300", "C200_1-100-750", "C300_1-32-15");
        UtilsCars utilsCars=new UtilsCars();
        //Создаем HashMap-ы для каждого типа авто
        Map<String,Cars100> cars100Map=new HashMap<>();
        Map<String,CarsOthers> cars200Map=new HashMap<>();
        Map<String,CarsOthers> cars300Map=new HashMap<>();
        Map<String,CarsOthers> cars400Map=new HashMap<>();
        List<String> tempArray;
        int type,probeg,dopZnach=0;
        String gosNumber;
           for (String str: inputList
             ) {
            tempArray=Arrays.asList(str.split("-"));
            type=Integer.parseInt(tempArray.get(0).substring(1,4));
            gosNumber=tempArray.get(0).substring(1);
            probeg=Integer.parseInt(tempArray.get(1));
            if (type!=100) dopZnach=Integer.parseInt(tempArray.get(2));
            switch (type){
                case 100->{
                   if (cars100Map.containsKey(gosNumber))
                        probeg=probeg+cars100Map.get(gosNumber).probeg;
                    cars100Map.put(gosNumber,new Cars100(gosNumber,type,"Легковой автомобиль",probeg));
                }
                case 200->{
                     if (cars200Map.containsKey(gosNumber)){
                        probeg=probeg+cars200Map.get(gosNumber).probeg;
                        dopZnach=dopZnach+cars200Map.get(gosNumber).dopZnach;}
                        cars200Map.put(gosNumber,new CarsOthers(gosNumber,type,"Грузовой авто",probeg,"Объем перевезенных грузов (см.куб.)",dopZnach));
                }
                case 300->{
                    if (cars300Map.containsKey(gosNumber)){
                        probeg=probeg+cars300Map.get(gosNumber).probeg;
                        dopZnach=dopZnach+cars300Map.get(gosNumber).dopZnach;}
                    cars300Map.put(gosNumber,new CarsOthers(gosNumber, type, "Пассажирский транспорт", probeg,"Число перевезенных пассажиров", dopZnach));
                }

                case 400->
                        {if (cars400Map.containsKey(gosNumber)){
                            probeg=probeg+cars400Map.get(gosNumber).probeg;
                            dopZnach=dopZnach+cars400Map.get(gosNumber).dopZnach;}
                            cars400Map.put(gosNumber,new CarsOthers(gosNumber,type,"Тяжелая техника, краны",probeg,"вес поднятых грузов тонн",dopZnach));
                        }
                }
        }
       //  Вывод на печать без сортировки.
         //перевожу List<Cars*> в List<Object>
        utilsCars.printCarsList(new ArrayList<>(cars200Map.values()));
      // utilsCars.printCarsList(cars200Map.values()); - так не работает, требует точное совпадение по классу-наследнику

        //Сортировка коллекции с компараторами
        Comparator<Cars> carProbegComparator=new CarProbegComparator();
        List<Cars> carList=new ArrayList(cars100Map.values());
        System.out.println("Сортировка по пробегу тип 100 и тип 200:");
        carList.sort(carProbegComparator);
        for (Cars car:carList
             ) {
            System.out.println(car);
        }
        carList=new ArrayList(cars200Map.values());
        carList.sort(carProbegComparator);
        for (Object car:carList
        ) {
            System.out.println(car);
        }
        System.out.println("Сортировка по доп значению тип 300:");
        Comparator carDopZnachComparator=new CarDopZnachComparator();
        carList=new ArrayList(cars300Map.values());
        carList.sort(carDopZnachComparator);
        for (Cars car: carList
             )
            System.out.println(car);
        System.out.println("Сортировка по пробегу и доп значению тип 300:");
        Comparator<Cars> carProbegDopZnachComparator=new CarProbegComparator().thenComparing(carDopZnachComparator);
        carList=new ArrayList(cars400Map.values());
        carList.sort(carProbegDopZnachComparator);
        for (Object car: carList
        ) {
            System.out.println(car);
        }

//Расход топлива на каждый тип машин
        double r100 = utilsCars.rashodType(new ArrayList(cars100Map.values()),12.5,46.10);
        double r200 = utilsCars.rashodType(new ArrayList(cars200Map.values()),12,48.90);
        double r300 = utilsCars.rashodType(new ArrayList(cars300Map.values()),11.5,47.50);
        double r400 = utilsCars.rashodType(new ArrayList(cars400Map.values()),20,48.90);
        double rAll=r100+r200+r300+r400;

        System.out.println("Расход ГСМ всего на легковые автомобили "  + r100);
        System.out.println("Расход ГСМ всего на грузовые авто " + r200);
        System.out.println("Расход ГСМ всего на пассажирский транспорт " +  r300);
        System.out.println("Расход ГСМ всего на тяжелую технику, краны " +  r400);
        System.out.println("Расход ГСМ всего "+ rAll);

        double minRashod = Math.min(Math.min(r100,r200), Math.min(r300,r400));
        double maxRashod = Math.max(Math.max(r100,r200), Math.max(r300,r400));
        if (minRashod==r100)
            System.out.println("Минимальный расход для типа 'легковые авто': " + r100);
        else if (minRashod==r200)
            System.out.println("Минимальный расход для типа 'грузоваые авто': " + r200);
        else if (minRashod==r300)
            System.out.println("Минимальный расход для типа 'пассажирский транспорт': " + r300);
        else if (minRashod==r400)
            System.out.println("Минимальный расход для типа 'тяжелая техника': " + r400);

        if (maxRashod==r100)
            System.out.println("Максимальный расход для типа 'легковые авто': " + r100);
        else if (maxRashod==r200)
            System.out.println("Максимальный расход для типа 'грузоваые авто': "+ r200);
        else if (maxRashod==r300)
            System.out.println("Максимальный расход для типа 'пассажирский транспорт':" + r300);
        else if (maxRashod==r400)
            System.out.println("Максимальный расход для типа 'тяжелая техника': " +  + r400);

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
