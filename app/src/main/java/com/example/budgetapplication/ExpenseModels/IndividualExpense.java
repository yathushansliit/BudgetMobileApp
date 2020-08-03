package com.example.budgetapplication.ExpenseModels;

public class IndividualExpense {
    public String individualExpenseId;
    public String individualExpenseName;
    public String individualExpenseAmount;
    public String individualExpenseDate;
    public String expenseType;

    public IndividualExpense(){}

    public IndividualExpense(String individualExpenseId, String individualExpenseName, String individualExpenseAmount, String individualExpenseDate, String expenseType) {
        this.individualExpenseId = individualExpenseId;
        this.individualExpenseName = individualExpenseName;
        this.individualExpenseAmount = individualExpenseAmount;
        this.individualExpenseDate = individualExpenseDate;
        this.expenseType = expenseType;
    }

    public String getIndividualExpenseId() {
        return individualExpenseId;
    }

    public void setIndividualExpenseId(String individualExpenseId) {
        this.individualExpenseId = individualExpenseId;
    }

    public String getIndividualExpenseName() {
        return individualExpenseName;
    }

    public void setIndividualExpenseName(String individualExpenseName) {
        this.individualExpenseName = individualExpenseName;
    }

    public String getIndividualExpenseAmount() {
        return individualExpenseAmount;
    }

    public void setIndividualExpenseAmount(String individualExpenseAmount) {
        this.individualExpenseAmount = individualExpenseAmount;
    }

    public String getIndividualExpenseDate() {
        return individualExpenseDate;
    }

    public void setIndividualExpenseDate(String individualExpenseDate) {
        this.individualExpenseDate = individualExpenseDate;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}
