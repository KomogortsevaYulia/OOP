package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    public static final String PATH_TO_DB_FILE="MyShop.db";
    public static final String URL="jdbc:sqlite:"+PATH_TO_DB_FILE;
    public static Connection connection;

    public static void initDB(){
        try {
            connection= DriverManager.getConnection(URL);
            if (connection!=null){
                DatabaseMetaData metaData=connection.getMetaData();
                DBWorker.createDB();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeDB(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createDB(){
        try {
            Statement statement=connection.createStatement();
            statement.execute("CREATE TABLE if not exists 'product' " +
                    "(" +
                    " 'id_product' int PRIMARY KEY," +
                    " 'name' text," +
                    " 'price' float );");
            statement.execute("CREATE TABLE if not exists 'existence' " +
                    "(" +
                    " 'id_product' int PRIMARY KEY," +
                    " 'name' text," +
                    " 'number_deliver' int," +
                    " 'number_sold' int," +
                    " 'number' int );");
            statement.execute("CREATE TABLE if not exists 'sales' " +
                    "(" +
                    " 'id_sales' int PRIMARY KEY," +
                    " 'id_product' int, " +
                    " 'name' text, " +
                    " 'data' text, " +
                    " 'price' float, " +
                    " 'quantity' int ," +
                    " 'sum' float );");
            statement.execute("CREATE TABLE if not exists 'deliveries' " +
                    "(" +
                    " 'id_deliveries' int PRIMARY KEY," +
                    " 'distributor' text ," +
                    " 'id_product' int," +
                    " 'name' text," +
                    " 'producer' text ," +
                    " 'number' int );");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addProduct(Product p){
        try {
            PreparedStatement S = connection.prepareStatement("INSERT INTO product ('id_product','name', 'price') "+
                    "VALUES(?,?,?)");
            S.setObject(1,p.getId());
            S.setObject(2,p.getName());
            S.setObject(3,p.getPrice());
            S.execute();
            S.close();
            PreparedStatement S1 = connection.prepareStatement("INSERT INTO existence ('id_product','name', 'number_deliver','number_sold','number') "+
                    "VALUES(?,?,?,?,?)");
            S1.setObject(1,p.getId());
            S1.setObject(2,p.getName());
            S1.setObject(3,0);
            S1.setObject(4,0);
            S1.setObject(5,0);
            S1.execute();
            S1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addSales(Sales s){
        try {
            PreparedStatement S = connection.prepareStatement("INSERT INTO sales ('id_sales','id_product','name', 'data','price','quantity','sum') "+
                    "VALUES(?,?,?,?,?,?,?)");
            S.setObject(1,s.getId());
            S.setObject(2,s.getProduct().getId());
            S.setObject(3,s.getProduct().getName());
            S.setObject(4,s.getData());
            S.setObject(5,s.getProduct().getPrice());
            S.setObject(6,s.getQuantity());
            S.setObject(7,s.getSum());
            S.execute();
            S.close();
            PreparedStatement S1 = connection.prepareStatement("UPDATE existence SET 'number_sold'=?  WHERE id_product =? ");
            S1.setObject(1,s.getQuantity());
            S1.setObject(2,s.getProduct().getId());
            S1.execute();
            S1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addDeliveries(Deliveries d){
        try {
            PreparedStatement S = connection.prepareStatement("INSERT INTO deliveries ('id_deliveries','distributor','id_product','name','producer' ,'number') "+
                    "VALUES(?,?,?,?,?,?)");
            S.setObject(1,d.getId());
            S.setObject(2,d.getDistributor());
            S.setObject(3,d.getProduct().getId());
            S.setObject(4,d.getProduct().getName());
            S.setObject(5,d.getProducer());
            S.setObject(6,d.getNumber());
            S.execute();
            S.close();
            PreparedStatement S1 = connection.prepareStatement("UPDATE existence SET 'number_deliver'=?  WHERE id_product =? ");
            S1.setObject(1,d.getNumber());
            S1.setObject(2,d.getProduct().getId());
            S1.execute();
            S1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteProduct(int id){
        try {
            PreparedStatement S = connection.prepareStatement("DELETE FROM product WHERE id_product=?");
            S.setObject(1,id);
            S.execute();
            S.close();
            PreparedStatement S1 = connection.prepareStatement("DELETE FROM existence WHERE id_product=?");
            S1.setObject(1,id);
            S1.execute();
            S1.close();
            PreparedStatement S2 = connection.prepareStatement("DELETE FROM sales WHERE id_product=?");
            S2.setObject(1,id);
            S2.execute();
            S2.close();
            PreparedStatement S3 = connection.prepareStatement("DELETE FROM deliveries WHERE id_product=?");
            S3.setObject(1,id);
            S3.execute();
            S3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteDeliveries(int id){
        try {
            PreparedStatement S = connection.prepareStatement("DELETE FROM deliveries WHERE id_deliveries=?");
            S.setObject(1,id);
            S.execute();
            S.close();
            //нужно написать при удаление поставки перерасчет наличия
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteSales(int id){
        try {
            PreparedStatement S = connection.prepareStatement("DELETE FROM sales WHERE id_sales=?");
            S.setObject(1,id);
            S.execute();
            S.close();
            //нужно написать при удаление продажи перерасчет наличия
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteProduct(){
        try {
            Statement S = connection.createStatement();
            S.execute("DELETE From product");
            S.close();
            Statement S1 = connection.createStatement();
            S1.execute("DELETE From existence");
            S1.close();
            Statement S2 = connection.createStatement();
            S2.execute("DELETE FROM sales");
            S2.close();
            Statement S3 = connection.createStatement();
            S3.execute("DELETE FROM deliveries");
            S3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteDeliveries(){
        try {
            Statement S = connection.createStatement();
            S.execute("DELETE From deliveries");
            S.close();
            //надо что бы пересчитывалось наличие
            /*PreparedStatement S1 = connection.prepareStatement("UPDATE existence SET 'number_deliver'=?");
            S1.setObject(1,0);
            S1.execute();
            S1.close();*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteSales(){
        try {
            Statement S = connection.createStatement();
            S.execute("DELETE From sales");
            S.close();
            //надо что бы пересчитывалось наличие
            /*PreparedStatement S1 = connection.prepareStatement("UPDATE existence SET 'number_sold'=? ");
            S1.setObject(1,0);
            S1.execute();
            S1.close();*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List selectProduct(){
        try {
            List<Product> List=new ArrayList();
            Statement statmt = connection.createStatement();
            ResultSet resSet = statmt.executeQuery("SELECT * FROM product");
            while(resSet.next())
            {
                Product p=new Product(
                        resSet.getInt("id_product"),
                        resSet.getString("name") ,
                        resSet.getFloat("price"));
                List.add(p);
            }
            statmt.close();
            return List;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static List selectDeliveries(){
        try {
            List<Deliveries> List=new ArrayList();
            Statement S = connection.createStatement();
            ResultSet resSet = S.executeQuery("SELECT * FROM deliveries");
            while(resSet.next())
            {
                Deliveries p=new Deliveries(
                        resSet.getInt("id_deliveries"),
                        resSet.getString("distributor") ,
                        new Product(resSet.getInt("id_product"),resSet.getString("name"),0),
                        resSet.getString("producer"),
                        resSet.getInt("number"));
                List.add(p);
            }
            S.close();
            return List;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static List selectSales(){
        try {
            List<Sales> List=new ArrayList();
            Statement S = connection.createStatement();
            ResultSet resSet = S.executeQuery("SELECT * FROM sales");
            while(resSet.next())
            {
                Sales p=new Sales(
                        resSet.getInt("id_sales"),
                        new Product(resSet.getInt("id_product"),resSet.getString("name"), resSet.getFloat("price")),
                        resSet.getString("data"),
                        resSet.getInt("quantity")
                );
                List.add(p);
            }
            S.close();
            return List;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List selectExistence(){
        /*try {
            List<Sales> List=new ArrayList();
            Statement S = connection.createStatement();
            ResultSet resSet = S.executeQuery("SELECT * FROM existence");
            while(resSet.next())
            {
                Sales p=new Sales(
                        resSet.getInt("id_product"),
                        new Product(resSet.getInt("id_product"),resSet.getString("name"), resSet.getFloat("price")),
                        resSet.getString("data"),
                        resSet.getInt("quantity"),
                        resSet.getFloat("sum")
                );
                List.add(p);
            }
            S.close();
            return List;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        return null;
    }


    public static void changeProduct(int id,Product p){
        try {
            PreparedStatement S = connection.prepareStatement("UPDATE product SET id_product=? ,'name'=? ,'price'=?  WHERE id_product =? ");
            S.setObject(1,p.getId());
            S.setObject(2,p.getName());
            S.setObject(3,p.getPrice());
            S.setObject(4,id);
            S.execute();
            S.close();
            PreparedStatement S1 = connection.prepareStatement("UPDATE existence SET id_product=? ,'name'=?   WHERE id_product =? ");
            S1.setObject(1,p.getId());
            S1.setObject(2,p.getName());
            S1.setObject(3,id);
            S1.execute();
            S1.close();
            PreparedStatement S2 = connection.prepareStatement("UPDATE deliveries SET id_product=? ,'name'=?   WHERE id_product =? ");
            S2.setObject(1,p.getId());
            S2.setObject(2,p.getName());
            S2.setObject(3,id);
            S2.execute();
            S2.close();
            PreparedStatement S3 = connection.prepareStatement("UPDATE sales SET id_product=? ,'name'=?,'sum'=?   WHERE id_product =? ");
            S3.setObject(1,p.getId());
            S3.setObject(2,p.getName());
            S3.setObject(3,p.getPrice());
            S3.setObject(4,id);
            S3.execute();
            S3.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void changeDeliveries(int id, Deliveries d){
        try {
            PreparedStatement S = connection.prepareStatement("UPDATE deliveries SET id_deliveries=?,'distributor'=?,id_product=? ,'name'=?,'producer'=? ,'number'=?  WHERE id_deliveries =? ");
            S.setObject(1,d.getId());
            S.setObject(2,d.getDistributor());
            S.setObject(3,d.getProduct().getId());
            S.setObject(4,d.getProduct().getName());
            S.setObject(5,d.getProducer());
            S.setObject(6,d.getNumber());
            S.setObject(7,id);
            S.execute();
            S.close();
            //надо написать перерасчет наличия
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void changeSales(int id,Sales s){
        try {
            PreparedStatement S = connection.prepareStatement("UPDATE sales SET id_sales=?,id_product=? ,'name'=?,'data'=? ,'price'=?,'quantity'=?,'sum'=?  WHERE id_sales =? ");
            S.setObject(1,s.getId());
            S.setObject(2,s.getProduct().getId());
            S.setObject(3,s.getProduct().getName());
            S.setObject(4,s.getData());
            S.setObject(5,s.getProduct().getPrice());
            S.setObject(6,s.getQuantity());
            S.setObject(7,s.getSum());
            S.setObject(8,id);
            S.execute();
            S.close();
            //надо написать перерасчет наличия
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
