package com.expenses;

import com.expenses.dao.ExpenseDAO;
import com.expenses.model.Category;
import com.expenses.model.Expense;

import java.time.LocalDate;

public class Application {

  public static void main(String[] args) {

    ExpenseDAO dao = new ExpenseDAO();

    Expense expense = new Expense();
    expense.setDescription("rent payment");
    expense.setCategory(Category.HOME);
    expense.setValue(1200);
    expense.setDate(LocalDate.of(2021, 5, 20));

    dao.save(expense);

  }

}
