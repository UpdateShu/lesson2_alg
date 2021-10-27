package ru.geekbrains.lessons;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class MainApp {

    static Random random = new Random();

    public static void main(String[] args) {

        int n = 20;
        MyArrayList<Integer> mal = getRandomMass(n);
        mal.add(999);
        System.out.println("Добавление элемента: " + mal);
        //mal.add(-1, 111);ошибка
        //mal.add(n + 1, 111);ошибка
        int k = n - 2;
        mal.add(k, 111);
        System.out.println("Вставка в позицию[" + k + "]: " + mal);
        mal.delete(n + 1);
        System.out.println("Удаление [" + (n + 1) + "]-позиции " + mal);
        System.out.println();

        System.out.println("Проверяем скорость сортировок...");
        int length1 = 100000;
        testSorting(1, length1);
        int length2 = 10000;
        testSorting(1, length2);

        testSorting(2, length1);
        testSorting(2, length2);
        testSorting(3, length1);
        testSorting(3, length2);

        mal = getRandomMass(length1);
        int addVal = 200;
        mal.add(99000, addVal);
        long start = System.nanoTime();
        int s = mal.indexOf(addVal);
        float speed = System.nanoTime() - start;
        System.out.println();
        System.out.println("Линейный поиск: элемент " + addVal + " найден в " + s + " позиции за " + speed / 1000000 + " мс");
        System.out.println("Сортировка массива...");
        MySortedArrayList<Integer> sortedMal = new MySortedArrayList<>();
        for (int i = 0; i < length1; i++) {
            sortedMal.add(random.nextInt(100));
        }
        start = System.nanoTime();
        s = sortedMal.bynaryFind(99);
        speed = System.nanoTime() - start;
        System.out.println("Бинарный поиск: элемент 99 найден в " + s + " позиции за " + speed / 1000000 + " мс");
    }

    static void testSorting(int type, int length)
    {
        String info = "Сортировка";
        MyArrayList<Integer> mal = getRandomMass(length);
        long start = System.nanoTime();
        switch (type)
        {
            case 1:
                mal.selectionSort();
                info += " методом выбора";
                break;
            case 2:
                mal.insertionSort();
                info += " методом вставки";
                break;
            case 3:
                mal.bubbleSort();
                info += " пузырьковым методом";
                break;
        }
        float speed = System.nanoTime() - start;
        System.out.println(info + " для " + length + "-элементов выполнена за " + speed / 1000000000 + " с");
    }

    static MyArrayList<Integer> getRandomMass(int n)
    {
        MyArrayList<Integer> mal = new MyArrayList<>();
        for (int i = 0; i < n; i++) {
            mal.add(random.nextInt(100));
        }
        return mal;
    }
}
