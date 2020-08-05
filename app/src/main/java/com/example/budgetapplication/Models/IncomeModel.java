package com.example.budgetapplication.Models;

public class IncomeModel {
    public String incomeId;
    public String incomeType;
    public String incomeAmount;
    public String incomeDate;

    public IncomeModel() {
    }

    public IncomeModel(String incomeId, String incomeType, String incomeAmount, String incomeDate) {
        this.incomeId = incomeId;
        this.incomeType = incomeType;
        this.incomeAmount = incomeAmount;
        this.incomeDate = incomeDate;
    }

    public String getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(String incomeId) {
        this.incomeId = incomeId;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }
}
