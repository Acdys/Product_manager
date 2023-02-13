package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void shouldRemoveById() {
        Repository repo = new Repository();

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        repo.add(first);
        repo.add(second);
        repo.add(third);
        repo.add(fourth);
        repo.add(fifth);

        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {second, third, fourth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductAll() {
        Repository repo = new Repository();

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        repo.add(first);
        repo.add(second);
        repo.add(third);
        repo.add(fourth);
        repo.add(fifth);

        Product[] actual = repo.findAll();
        Product[] expected = {first, second, third, fourth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFew() {
        Repository repo = new Repository();

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        repo.add(first);
        repo.add(second);
        repo.add(third);
        repo.add(fourth);
        repo.add(fifth);

        repo.removeById(3);
        repo.removeById(4);

        Product[] actual = repo.findAll();
        Product[] expected = {first, second, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductOne() {
        Repository repo = new Repository();

        Book first = new Book(1, "12 стульев", 800, "Петров");

        repo.add(first);

        Product[] actual = repo.findAll();
        Product[] expected = {first};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAll() {
        Repository repo = new Repository();

        Book first = new Book(1, "12 стульев", 800, "Петров");
        Book second = new Book(2, "Манарага", 1000, "Сорокин");
        Book third = new Book(3, "Фердидурке", 650, "Гомбрович");
        Smartphone fourth = new Smartphone(4, "iPhone 12", 70000, "Apple");
        Smartphone fifth = new Smartphone(5, "Galaxy", 80000, "Samsung");

        repo.add(first);
        repo.add(second);
        repo.add(third);
        repo.add(fourth);
        repo.add(fifth);

        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);
        repo.removeById(4);
        repo.removeById(5);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}
