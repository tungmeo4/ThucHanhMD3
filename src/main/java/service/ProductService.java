package service;

import DAO.IProductDAO;
import DAO.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    private final IProductDAO productDAO = new ProductDAO();
    @Override
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }

    @Override
    public void deleteProduct(int id) throws SQLException{
        productDAO.deleteProduct(id);
    }

    @Override
    public void editProduct(Product product, int idCategory) throws SQLException {
        productDAO.editProduct(product, idCategory);
    }

    @Override
    public boolean createProduct(Product product, int idCategory) {
        return productDAO.createProduct(product);
    }
}
