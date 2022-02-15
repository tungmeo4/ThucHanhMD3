package DAO;

import connect.SQLConnect;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private final SQLConnect connect = new SQLConnect();
    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int quantity = rs.getInt(4);
                String color = rs.getString(5);
                String description = rs.getString(6);
                String category = rs.getString(7);
                products.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void deleteProduct(int id) {
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `product`.`product` WHERE (`id` = ?);");
            statement.setInt(1,id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editProduct(Product product, int id) {
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE `product`.`product` SET `name_product` = ?, `price` = ?, `quantity` = ?, `color` = ?, `description` = ?, `category` = ? WHERE (`id` = ?);");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getCategory());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean createProduct(Product product, int idCategory) {
        boolean check = false;
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `product`.`product` (`name_product`, `price`, `quantity`, `color`, `description`, `category`) VALUES (?,?,?,?,?,?);");
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getCategory());
            check = statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return check;
    }
}
