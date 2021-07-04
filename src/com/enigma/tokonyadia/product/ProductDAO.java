package com.enigma.tokonyadia.product;

import com.enigma.tokonyadia.config.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;

    public void insertProduct(Integer productId, String productName, Integer price, Integer stock) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        connection = dbConnection.connect();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO product (id, product_name, price, stock) values ("+productId+",'"+productName+"'," + price +","+stock+")";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    public List<String> getAllProduct() throws SQLException {
        DBConnector dbConnection = new DBConnector();
        connection = dbConnection.connect();
        Statement statement = connection.createStatement();

        List<String> result = new ArrayList();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
        while (resultSet.next()) {
            Integer productId = resultSet.getInt("id");
            String productName = resultSet.getString("product_name");
            Integer price = resultSet.getInt("price");
            Integer stock = resultSet.getInt("stock");
            result.add(String.format("%d, %s, %d, %d", productId, productName, price, stock));
//            System.out.printf("%d, %s, %d, %d \n", productId, productName, price, stock);
        }
        statement.close();
        connection.close();
        return result;
    }

    public String getProductById(Integer productId) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        connection = dbConnection.connect();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM product where id = " + productId);
        resultSet.next();
        productId = resultSet.getInt("id");
        String productName = resultSet.getString("product_name");
        Integer price = resultSet.getInt("price");
        Integer stock = resultSet.getInt("stock");
        String result = String.format("%d, %s, %d, %d", productId, productName, price, stock);

        return result;
    }

    public void updateProduct(Integer id, String value) throws SQLException {
        DBConnector dbConnection = new DBConnector();
        connection = dbConnection.connect();
        String queryUpdate = "UPDATE product SET product_name = ? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
        preparedStatement.setString(1, value);
        preparedStatement.setInt(1, id);
        preparedStatement.close();
        connection.close();
    }
}
