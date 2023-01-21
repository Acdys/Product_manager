package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();

    private final Book first = new Book(1, "Обломов", 800, "Гончаров");
    private final Book second = new Book(2, "Манарага", 1000, "Сорокин");
    private final Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
    private final Smartphone fourth = new Smartphone(4, "iPhone", 100000, "Apple");
    private final Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

    @BeforeEach
    public void setUp() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        repository.add(fifth);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);

        Product[] expected = {second, third, fourth, fifth};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}

