package com.expenses;

import com.expenses.dao.ExpenseDAO;
import com.expenses.model.Category;
import com.expenses.model.Expense;

import java.util.List;
import java.util.Optional;

public class Application {

  public static void main(String[] args) {

    ExpenseDAO dao = new ExpenseDAO();

    List<Expense> expenses = dao.findByCategory(Category.TRANSPORT);

    for (Expense expense : expenses) {
      System.out.println("--------------------------------------------------");
      System.out.println("ID: " + expense.getId());
      System.out.println("DESCRIPTION: " + expense.getDescription());
      System.out.println("CATEGORY: " + expense.getCategory());
      System.out.println("VALUE: " + expense.getValue());
    }


    /*
    Optional<Expense> expenseOptional = dao.findById(2L);

    expenseOptional.ifPresent(expense -> {
      System.out.println("ID: " + expense.getId());
      System.out.println("DESCRIPTION: " + expense.getDescription());
      System.out.println("VALUE: " + expense.getValue());
    });
    */

    /*
    List<Expense> expenses = dao.findAll();

    for (Expense expense : expenses) {
      System.out.println("ID: " + expense.getId());
      System.out.println("DESCRIPTION: " + expense.getDescription());
      System.out.println("VALUE: " + expense.getValue());
    }
    */

  }

}
