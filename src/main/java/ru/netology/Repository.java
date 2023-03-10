package ru.netology;

public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product){
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll(){
        return products;
    }

    public void removeById(int removeId){
        Product productFounded = findById(removeId);
        if (productFounded == null){
            throw new NotFoundException(removeId);
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products){
            if (product.getId() != removeId){
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    private Product findById(int id){
        for (Product product : products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
