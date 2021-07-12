package com.expenses.dao;

import com.expenses.model.Category;
import com.expenses.model.Expense;

import java.util.List;
import java.util.Optional;

public interface IExpenseDAO {

  Expense save(Expense expense);

  Expense update(Expense expense);

  void delete(Long id);

  List<Expense> findAll();

  Optional<Expense> findById(Long id);

  List<Expense> findByCategory(Category category);

}
