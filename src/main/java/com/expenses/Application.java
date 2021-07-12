package com.expenses;

import com.expenses.dao.ExpenseDAO;
import com.expenses.model.Expense;

import java.util.List;

public class Application {

  public static void main(String[] args) {

    ExpenseDAO dao = new ExpenseDAO();
    List<Expense> expenses = dao.findAll();

    for (Expense expense : expenses) {
      System.out.println("ID: " + expense.getId());
      System.out.println("DESCRIPTION: " + expense.getDescription());
      System.out.println("VALUE: " + expense.getValue());

      System.out.println("--------------------");
    }

  }

}
