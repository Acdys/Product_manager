package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book first = new Book(1, "Обломов", 800, "Гончаров");
    Book second = new Book(2, "Манарага", 1000, "Сорокин");
    Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
    Smartphone fourth = new Smartphone(4, "iPhone", 100000, "Apple");
    Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

    @Test
    public void shouldSearchByNotFoundProducts(){

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Письмо незнакомки");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldAddProductOne() {
        manager.add(first);

        Product[] expected = {first};
        Product[] actual = ProductRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldAddProductAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] expected = {first, second, third, fourth, fifth};
        Product[] actual = ProductRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldProductName() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        String name = "Обломов";

        Product[] expected = {first};
        Product[] actual = manager.searchBy(name);

        Assertions.assertArrayEquals(expected, actual);
    }

}
