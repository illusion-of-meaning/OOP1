package com.asherbakov;

import com.asherbakov.transport.Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    static Flower[] flowers = new Flower[5];

    public static void main(String[] args) {
        // HW 1.1
//        task1();

        // HW 1.3
//        task2();


        // HW OOP2 1.1
//        System.out.println("======================HW OOP2===================");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//        LocalDate dateOfBirthday = LocalDate.parse("2001.11.10", dtf);
//        Person personVladimir = new Person(dateOfBirthday, "Владимир", "Казань");
//        personVladimir.setJob("");
//        System.out.println("================================================");

        // HW OOP2 1.2
        taskFlower();
        System.out.println("================================================");

        FlowersBouquet flowersBouquet = new FlowersBouquet(flowers);
        System.out.println(flowersBouquet.toString());
        System.out.println("================================================");

        // HW OOP2 2.1
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "желтого", 2015, "России");
        Car.Key ladaKey = ladaGranta.new Key(false, false);
        Car.Insurance ladaInsurance = ladaGranta.new Insurance(LocalDate.parse("2023-06-09"), 9800, "1234567890");
        ladaGranta.setKey(ladaKey);
        ladaGranta.setInsurance(ladaInsurance);
        System.out.println(ladaGranta);
        System.out.println("================================================");
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германии");
        Car.Key audiA8Key = audiA8.new Key(true, true);
        Car.Insurance audiA8Insurance = audiA8.new Insurance(LocalDate.parse("2022-09-09"), 13900.40, "123456789");
        audiA8.setKey(audiA8Key);
        audiA8.setInsurance(audiA8Insurance);
        System.out.println(audiA8);

    }

    private static void taskFlower() {

        Flower flower1 = new Flower("Роза");
        flower1.setCountry("Голландия");
        flower1.setCost(35.59);
        flowers[0] = flower1;
        Flower flower2 = new Flower("Хризантема");
        flower2.setCost(15);
        flower2.setLifeSpan(5);
        flowers[1] = flower2;
        Flower flower3 = new Flower("Пион из Англии");
        flower3.setCost(69.9);
        flower3.setLifeSpan(1);
        flowers[2] = flower3;
        Flower flower4 = new Flower("Гипсофила");
        flower4.setCountry("Турция");
        flower4.setCost(19.5);
        flower4.setLifeSpan(10);
        flowers[3] = flower4;
        Flower flower5 = new Flower("Роза");
        flower5.setCountry("Россия");
        flower5.setCost(48.90);
        flowers[4] = flower5;
        for (Flower f : flowers) {
            if (f != null) {
                System.out.println(f);
            }
        }
    }

    private static void task1() {
        // 1.1
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate dateOfBirthday = LocalDate.parse("1987.11.10", dtf);
        Person person1 = new Person(dateOfBirthday, "Максим", "Минск");
        System.out.println(person1);
        dateOfBirthday = LocalDate.parse("1993.08.13", dtf);
        Person person2 = new Person(dateOfBirthday, "Аня", "Москва");
        System.out.println(person2);
        dateOfBirthday = LocalDate.parse("1994.05.06", dtf);
        Person person3 = new Person(dateOfBirthday, "Катя", "Калининград");
        System.out.println(person3);
        dateOfBirthday = LocalDate.parse("1995.06.08", dtf);
        Person person4 = new Person(dateOfBirthday, "Артем", "Москва");
        System.out.println(person4);
        dateOfBirthday = LocalDate.parse("1995.06.08", dtf);
        Person person5 = new Person(dateOfBirthday, "", "");
        System.out.println(person5);
        System.out.println("================================================");

        // 1.2
        person1.setJob("бренд-менеджером");
        System.out.println(person1);
        person2.setJob("методистом образовательных программ");
        System.out.println(person2);
        person3.setJob("продакт-менеджером");
        System.out.println(person3);
        person4.setJob("директором по развитию бизнеса");
        System.out.println(person4);
    }

    private static void task2() {
        System.out.println("================================================");
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "желтого", 2015, "России");
        System.out.println(String.format("%s %s, %s год выпуска, сборка в %s, %s цвета, объем двигателя - %.1f.",
                ladaGranta.getBrand(),
                ladaGranta.getModel(),
                ladaGranta.getProductionYear(),
                ladaGranta.getProductionCountry(),
                ladaGranta.getColor(),
                ladaGranta.getEngineVolume()
        ));
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германии");
        System.out.println(String.format("%s %s, %s год выпуска, сборка в %s, %s цвет кузова, объем двигателя %.1f литра.",
                audiA8.getBrand(),
                audiA8.getModel(),
                audiA8.getProductionYear(),
                audiA8.getProductionCountry(),
                audiA8.getColor(),
                audiA8.getEngineVolume()
        ));
        Car bmwZ8 = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германии");
        System.out.println(String.format("%s %s, сборка в %s в %s году, %s цвет кузова, объем - %.1f.",
                bmwZ8.getBrand(),
                bmwZ8.getModel(),
                bmwZ8.getProductionCountry(),
                bmwZ8.getProductionYear(),
                bmwZ8.getColor(),
                bmwZ8.getEngineVolume()
        ));
        Car kiaSportage4 = new Car("Kia", "Sportage 4", 2.4, "красный", 2018, "Южной Корее");
        System.out.println(String.format("%s %s поколение, %s год выпуска, сборка в %s, цвета кузова %s, объем двигателя - %.1f литра.",
                kiaSportage4.getBrand(),
                kiaSportage4.getModel(),
                kiaSportage4.getProductionYear(),
                kiaSportage4.getProductionCountry(),
                kiaSportage4.getColor(),
                kiaSportage4.getEngineVolume()
        ));
        Car hyundaiAvante = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южной Корее");
        System.out.println(String.format("%s %s, сборка в %s, цвет кузова %s, объем двигателя - %.1f литра, год выпуска - %s год.",
                hyundaiAvante.getBrand(),
                hyundaiAvante.getModel(),
                hyundaiAvante.getProductionCountry(),
                hyundaiAvante.getColor(),
                hyundaiAvante.getEngineVolume(),
                hyundaiAvante.getProductionYear()
        ));
        Car emptyCar = new Car("", "", 0.0, "", 0, "");
        System.out.println(emptyCar);
    }
}