package ru.netology.manager;


import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;

public class ProductManager {
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);

    }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: ProductRepository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}