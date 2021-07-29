package com.expenses.model;

import java.time.LocalDate;

public class Expense {

  private Long id;
  private String description;
  private LocalDate date;
  private double value;
  private Category category;

  public Expense(Long id, String description, LocalDate date, double value, Category category) {
    this.id = id;
    this.description = description;
    this.date = date;
    this.value = value;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}