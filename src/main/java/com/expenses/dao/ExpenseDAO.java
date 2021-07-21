package com.expenses.dao;

import com.expenses.infra.ConnectionFactory;
import com.expenses.model.Category;
import com.expenses.model.Expense;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExpenseDAO implements IExpenseDAO {

  @Override
  public Expense save(Expense expense) {

    String sql = "INSERT INTO expenses (description, value, date, category) VALUES (?, ?, ?, ?)";

    try (Connection connection = ConnectionFactory.getConnection()) {

      PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, expense.getDescription());
      preparedStatement.setDouble(2, expense.getValue());
      preparedStatement.setDate(3, java.sql.Date.valueOf(expense.getDate()));
      preparedStatement.setString(4, expense.getCategory().toString());
      preparedStatement.executeUpdate();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      Long generatedId = resultSet.getLong("id");

      expense.setId(generatedId);

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

    return expense;
  }

  @Override
  public Expense update(Expense expense) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<Expense> findAll() {

    String sql = "SELECT id, description, date, value, category FROM expenses";

    List<Expense> expenses = new ArrayList<>();

    try (Connection connection = ConnectionFactory.getConnection()) {

      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Long id_rs = resultSet.getLong("id");
        String description_rs = resultSet.getString("description");
        LocalDate date_rs = resultSet.getDate("date").toLocalDate();
        double value_rs = resultSet.getDouble("value");
        Category category_rs = Category.valueOf(resultSet.getString("category"));

        Expense expense = new Expense(id_rs, description_rs, date_rs, value_rs, category_rs);
        expenses.add(expense);
      }

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

    return expenses;

  }

  @Override
  public Optional<Expense> findById(Long id) {

    String sql = "SELECT id, description, date, value, category FROM expenses WHERE id = ?";

    Expense expense = null;

    try (Connection connection = ConnectionFactory.getConnection()) {

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setLong(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Long id_rs = resultSet.getLong("id");
        String description_rs = resultSet.getString("description");
        LocalDate date_rs = resultSet.getDate("date").toLocalDate();
        double value_rs = resultSet.getDouble("value");
        Category category_rs = Category.valueOf(resultSet.getString("category"));
        expense = new Expense(id_rs, description_rs, date_rs, value_rs, category_rs);
      }

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

    return Optional.ofNullable(expense);

  }

  @Override
  public List<Expense> findByCategory(Category category) {

    String sql = "SELECT id, description, date, value, category FROM expenses WHERE category = ?";
    List<Expense> expenses = new ArrayList<>();

    try (Connection connection = ConnectionFactory.getConnection()) {

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, category.toString());

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Long id_rs = resultSet.getLong("id");
        String description_rs = resultSet.getString("description");
        LocalDate date_rs = resultSet.getDate("date").toLocalDate();
        double value_rs = resultSet.getDouble("value");
        Category category_rs = Category.valueOf(resultSet.getString("category"));

        Expense expense = new Expense(id_rs, description_rs, date_rs, value_rs, category_rs);
        expenses.add(expense);
      }

    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }

    return expenses;

  }

}
