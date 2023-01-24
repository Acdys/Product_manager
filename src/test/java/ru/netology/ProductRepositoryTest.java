package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

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
        Product[] actual = ProductRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFew() {
        repository.removeById(1);
        repository.removeById(4);

        Product[] expected = {second, third, fifth};
        Product[] actual = ProductRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldAddProductAll() {

        Product[] expected = {first, second, third, fourth, fifth};
        Product[] actual = ProductRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAll() {
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);

        Product[] expected = {};
        Product[] actual = ProductRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}

