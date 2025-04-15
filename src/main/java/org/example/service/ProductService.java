package org.example.service;

import org.example.dao.ProductDAO;
import org.example.model.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();

    public boolean save(Product product) {
        var existingProduct = productDAO.findProductByName(product.getName());
        if (existingProduct.isEmpty()) {
            productDAO.save(product);
            return true;
        }
        return false;
    }

    public List<Product> findProductByName(String name) {
        return productDAO.findProductByName(name);
    }
}
