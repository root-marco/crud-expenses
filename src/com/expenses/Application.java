package com.expenses;

import com.expenses.dao.ExpenseDAO;
import com.expenses.model.Category;
import com.expenses.model.Expense;

import java.util.Optional;

public class Application {

  public static void main(String[] args) {

    ExpenseDAO dao = new ExpenseDAO();

    Optional<Expense> expenseOptional = dao.findById(1L);
    Expense expense = expenseOptional.get();

    expense.setDescription("payment updated");

    dao.update(expense);

  }

}
