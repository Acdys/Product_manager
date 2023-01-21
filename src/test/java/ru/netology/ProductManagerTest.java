package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void shouldSearchByOneProducts(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

       Book first = new Book(1, "Обломов", 800, "Гончаров");
       Book second = new Book(2, "Манарага", 1000, "Сорокин");
       Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
       Smartphone fourth = new Smartphone(44, "iPhone", 100000, "Apple");
       Smartphone fifth = new Smartphone(55, "Galaxy", 80000, "Samsung");

       manager.add(first);
       manager.add(second);
       manager.add(third);
       manager.add(fourth);
       manager.add(fifth);

       Product[] actual = manager.searchBy("Манарага");
       Product[] expected = {second};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByNotFoundProducts(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Book first = new Book(11, "Обломов", 800, "Гончаров");
        Book second = new Book(22, "Манарага", 1000, "Сорокин");
        Book third = new Book(33, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(44, "iPhone", 100000, "Apple");
        Smartphone fifth = new Smartphone(55, "Galaxy", 80000, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] actual = manager.searchBy("Письмо незнакомки");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}
