package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    void deleteProduct(int id) throws SQLException;
    void editProduct(Product product,int id) throws SQLException;
    boolean createProduct(Product product);
}
