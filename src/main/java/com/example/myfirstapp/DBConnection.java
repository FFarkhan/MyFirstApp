package com.example.myfirstapp;

import java.sql.*;

public class DBConnection {
    private static final String URL_DB = "jdbc:mysql://localhost:3306/users";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "password";

    public Statement DBConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        return connection.createStatement();
    }
    public void addUsersDataToDB(User user) throws SQLException, ClassNotFoundException {
        Statement statement = DBConnector();
        statement.executeUpdate("insert into user(name, surname, login, password, gender, location)\n" +
                "values(" + "'" + user.getName()+"'" + ", " + "'"+user.getSurname()+"'" + ", "
                +"'"+ user.getLogin()+"'" + ", " + "'"+user.getPassword() +"'"+ ", " +"'"+ user.getGender()+"'" + ", " + "'"+
                user.getLocation() +"'"+ ");");
    }
    public ResultSet getUserDataFromDB(String login, String password) throws SQLException, ClassNotFoundException {
        DBConnection connection = new DBConnection();
        Statement statement = connection.DBConnector();
        return statement.executeQuery("select user.id from user where user.login =" +
                " '" + login + "' and user.password = '" + password + "';");
    }
}
