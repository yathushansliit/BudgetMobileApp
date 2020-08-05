package com.example.budgetapplication.Models;

public class FamilyExpenseModel {
    String familyExpenseId;
    String familyExpenseName;
    String familyExpenseAmount;
    String familyExpenseDate;
    String expenseType;

    public FamilyExpenseModel(){

    }

    public FamilyExpenseModel(String familyExpenseId, String familyExpenseName, String familyExpenseAmount, String familyExpenseDate, String expenseType) {
        this.familyExpenseId = familyExpenseId;
        this.familyExpenseName = familyExpenseName;
        this.familyExpenseAmount = familyExpenseAmount;
        this.familyExpenseDate = familyExpenseDate;
        this.expenseType = expenseType;
    }

    public String getFamilyExpenseId() {
        return familyExpenseId;
    }

    public void setFamilyExpenseId(String familyExpenseId) {
        this.familyExpenseId = familyExpenseId;
    }

    public String getFamilyExpenseName() {
        return familyExpenseName;
    }

    public void setFamilyExpenseName(String familyExpenseName) {
        this.familyExpenseName = familyExpenseName;
    }

    public String getFamilyExpenseAmount() {
        return familyExpenseAmount;
    }

    public void setFamilyExpenseAmount(String familyExpenseAmount) {
        this.familyExpenseAmount = familyExpenseAmount;
    }

    public String getFamilyExpenseDate() {
        return familyExpenseDate;
    }

    public void setFamilyExpenseDate(String familyExpenseDate) {
        this.familyExpenseDate = familyExpenseDate;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}
