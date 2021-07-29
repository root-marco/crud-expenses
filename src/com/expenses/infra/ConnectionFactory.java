package com.expenses.infra;

// psql -h localhost -p 5432 -U postgres

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

  private ConnectionFactory() {
  }

  public static Connection getConnection() {

    String url = "jdbc:postgresql://localhost/ExpensesDB";
    String user = "postgres";
    String password = "0152";

    try {
      return DriverManager.getConnection(url, user, password);
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

  }

}
