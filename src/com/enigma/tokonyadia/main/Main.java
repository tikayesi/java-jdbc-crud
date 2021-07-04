package com.enigma.tokonyadia.main;

import com.enigma.tokonyadia.config.DBConnector;
import com.enigma.tokonyadia.product.ProductDAO;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
//        ProductDAO productDAO = new ProductDAO();
//        productDAO.updateProduct(4, "Wings");
        DBConnector dbConnector = new DBConnector();
        Connection connection = dbConnector.connect();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Email =");
        String email = scanner.nextLine();
        System.out.print("Password =");
        String password = scanner.nextLine();

        Statement statement = connection.createStatement();
        String querynya = "SELECT * FROM customer where email ='"+ email+"' AND  password = '"+ password +"'";
        ResultSet resultSet = statement.executeQuery(querynya);

        if(resultSet.next()) {
            System.out.println(resultSet.getInt("id")+ ","+ resultSet.getString("name"));
            System.out.println("Success");
        } else {
            System.out.println("Data is not exist");
        }


//        String querySelect = "SELECT * FROM product WHERE price >= ? AND stock >= ?";
//        PreparedStatement statement = connection.prepareStatement(querySelect);
//        statement.setInt(1, 3000);
//        statement.setInt(2, 4);
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("product_name"));
//        }
        statement.close();
        connection.close();



//        ProductDAO productDAO = new ProductDAO();
//        productDAO.insertProduct(5, "G Shock", 5000, 3);

//        ProductDAO productDAO = new ProductDAO();
//        for (String records: productDAO.getAllProduct()){
//            System.out.println(records);
//        }
//        ProductDAO productDAO = new ProductDAO();
//        System.out.println(productDAO.getProductById(4));

//        DBConnector dbConnector = new DBConnector();
//        Connection connection = dbConnector.connect();
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
//        while (resultSet.next()) {
//            Integer productId = resultSet.getInt("id");
//            String productName = resultSet.getString("product_name");
//            Integer price = resultSet.getInt("price");
//            Integer stock = resultSet.getInt("stock");
//            System.out.printf("%d, %s, %d, %d \n", productId, productName, price, stock);
//        }
//        statement.close();
//        connection.close();




//        DBConnection dbConnection = new DBConnection();
//        Connection connection =  dbConnection.connect();
//        Statement statement = connection.createStatement();
//        statement.executeUpdate("INSERT INTO product (id, product_name, price, stock) values (4, 'x wing', 11200, 5)");
//        statement.close();
//        connection.close();
    }
}
