package com.expenses.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  private ConnectionFactory() {
  }

  public static Connection getConnection() {

    String url = "jdbc:postgresql://localhost/ExpenseDB";
    String user = "postgres";
    String password = "0152";

    try {
      return DriverManager.getConnection(url, user, password);
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

  }

}
