package com.expenses.dao;

import com.expenses.infra.ConnectionFactory;
import com.expenses.model.Category;
import com.expenses.model.Expense;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ExpenseDAO implements IExpenseDAO {

    @Override
    public Expense save(Expense expense) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            connection.prepareStatement("INSERT INTO expenses (description, value, date, category) VALUES ()");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        };
        return null;
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
        return null;
    }

    @Override
    public Optional<Expense> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Expense> findByCategory(Category category) {
        return null;
    }

}
