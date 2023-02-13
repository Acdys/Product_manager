package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void shouldSearchByFewProducts(){
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] actual = manager.searchBy("12");
        Product[] expected = {first, fourth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNotFoundProducts(){
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] actual = manager.searchBy("Письмо незнакомки");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductOne() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] actual = manager.searchBy("Манарага");
        Product[] expected = {second};

        Assertions.assertArrayEquals(expected, actual);
    }
}
