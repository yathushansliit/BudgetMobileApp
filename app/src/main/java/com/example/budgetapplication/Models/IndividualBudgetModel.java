package com.example.budgetapplication.Models;

import android.provider.ContactsContract;

import java.util.List;

public class IndividualBudgetModel {
    public String individualBudgetId;
    public String individualBudgetName;
    public List<IndividualExpenseModel> budgetLists;
    public String individualBudgetAmount;
    public String individualTotalBudgetAmount;
    public String individualBudgetBalance;
    public String individualDate;

    public IndividualBudgetModel() {
    }

    public IndividualBudgetModel(String individualBudgetId, String individualBudgetName, List<IndividualExpenseModel> budgetLists, String individualBudgetAmount, String individualTotalBudgetAmount, String individualBudgetBalance, String individualDate) {
        this.individualBudgetId = individualBudgetId;
        this.individualBudgetName = individualBudgetName;
        this.budgetLists = budgetLists;
        this.individualBudgetAmount = individualBudgetAmount;
        this.individualTotalBudgetAmount = individualTotalBudgetAmount;
        this.individualBudgetBalance = individualBudgetBalance;
        this.individualDate = individualDate;
    }

    public String getIndividualBudgetId() {
        return individualBudgetId;
    }

    public void setIndividualBudgetId(String individualBudgetId) {
        this.individualBudgetId = individualBudgetId;
    }

    public String getIndividualBudgetName() {
        return individualBudgetName;
    }

    public void setIndividualBudgetName(String individualBudgetName) {
        this.individualBudgetName = individualBudgetName;
    }

    public List<IndividualExpenseModel> getBudgetLists() {
        return budgetLists;
    }

    public void setBudgetLists(List<IndividualExpenseModel> budgetLists) {
        this.budgetLists = budgetLists;
    }

    public String getIndividualBudgetAmount() {
        return individualBudgetAmount;
    }

    public void setIndividualBudgetAmount(String individualBudgetAmount) {
        this.individualBudgetAmount = individualBudgetAmount;
    }

    public String getIndividualTotalBudgetAmount() {
        return individualTotalBudgetAmount;
    }

    public void setIndividualTotalBudgetAmount(String individualTotalBudgetAmount) {
        this.individualTotalBudgetAmount = individualTotalBudgetAmount;
    }

    public String getIndividualBudgetBalance() {
        return individualBudgetBalance;
    }

    public void setIndividualBudgetBalance(String individualBudgetBalance) {
        this.individualBudgetBalance = individualBudgetBalance;
    }

    public String getIndividualDate() {
        return individualDate;
    }

    public void setIndividualDate(String individualDate) {
        this.individualDate = individualDate;
    }
}
