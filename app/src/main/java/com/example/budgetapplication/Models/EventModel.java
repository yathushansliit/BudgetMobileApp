package com.example.budgetapplication.Models;

public class EventModel {
    String eventExpenseId;
    String eventExpenseName;
    String eventExpenseAmount;
    String eventExpenseDate;
    String expenseType;

    public EventModel(){

    }

    public EventModel(String eventExpenseId, String eventExpenseName, String eventExpenseAmount, String eventExpenseDate, String expenseType) {
        this.eventExpenseId = eventExpenseId;
        this.eventExpenseName = eventExpenseName;
        this.eventExpenseAmount = eventExpenseAmount;
        this.eventExpenseDate = eventExpenseDate;
        this.expenseType = expenseType;
    }

    public String getEventExpenseId() {
        return eventExpenseId;
    }

    public void setEventExpenseId(String eventExpenseId) {
        this.eventExpenseId = eventExpenseId;
    }

    public String getEventExpenseName() {
        return eventExpenseName;
    }

    public void setEventExpenseName(String eventExpenseName) {
        this.eventExpenseName = eventExpenseName;
    }

    public String getEventExpenseAmount() {
        return eventExpenseAmount;
    }

    public void setEventExpenseAmount(String eventExpenseAmount) {
        this.eventExpenseAmount = eventExpenseAmount;
    }

    public String getEventExpenseDate() {
        return eventExpenseDate;
    }

    public void setEventExpenseDate(String eventExpenseDate) {
        this.eventExpenseDate = eventExpenseDate;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}
