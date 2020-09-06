package com.example.budgetapplication.Models;

import java.util.List;

public class FamilyBudgetModel {
    public String familyBudgetId;
    public String familyBudgetName;
    public List<FamilyExpenseModel> familybudgetLists;
    public String familyBudgetAmount;
    public String familyTotalBudgetAmount;
    public String familyBudgetBalance;
    public String familyDate;

    public FamilyBudgetModel() {
    }

    public FamilyBudgetModel(String familyBudgetId, String familyBudgetName, List<FamilyExpenseModel> familybudgetLists, String familyBudgetAmount, String familyTotalBudgetAmount, String familyBudgetBalance, String familyDate) {
        this.familyBudgetId = familyBudgetId;
        this.familyBudgetName = familyBudgetName;
        this.familybudgetLists = familybudgetLists;
        this.familyBudgetAmount = familyBudgetAmount;
        this.familyTotalBudgetAmount = familyTotalBudgetAmount;
        this.familyBudgetBalance = familyBudgetBalance;
        this.familyDate = familyDate;
    }

    public String getFamilyBudgetId() {
        return familyBudgetId;
    }

    public void setFamilyBudgetId(String familyBudgetId) {
        this.familyBudgetId = familyBudgetId;
    }

    public String getFamilyBudgetName() {
        return familyBudgetName;
    }

    public void setFamilyBudgetName(String familyBudgetName) {
        this.familyBudgetName = familyBudgetName;
    }

    public List<FamilyExpenseModel> getFamilybudgetLists() {
        return familybudgetLists;
    }

    public void setFamilybudgetLists(List<FamilyExpenseModel> familybudgetLists) {
        this.familybudgetLists = familybudgetLists;
    }

    public String getFamilyBudgetAmount() {
        return familyBudgetAmount;
    }

    public void setFamilyBudgetAmount(String familyBudgetAmount) {
        this.familyBudgetAmount = familyBudgetAmount;
    }

    public String getFamilyTotalBudgetAmount() {
        return familyTotalBudgetAmount;
    }

    public void setFamilyTotalBudgetAmount(String familyTotalBudgetAmount) {
        this.familyTotalBudgetAmount = familyTotalBudgetAmount;
    }

    public String getFamilyBudgetBalance() {
        return familyBudgetBalance;
    }

    public void setFamilyBudgetBalance(String familyBudgetBalance) {
        this.familyBudgetBalance = familyBudgetBalance;
    }

    public String getFamilyDate() {
        return familyDate;
    }

    public void setFamilyDate(String familyDate) {
        this.familyDate = familyDate;
    }
}
