package DAO;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();
    void deleteProduct(int id) throws SQLException;
    void editProduct(Product product,int idCategory) throws SQLException;
    boolean createProduct(Product product, int idCategory);
}
