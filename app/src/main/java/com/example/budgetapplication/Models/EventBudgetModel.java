package com.example.budgetapplication.Models;

import java.util.List;

public class EventBudgetModel {
    public String eventBudgetId;
    public String eventBudgetName;
    public String eventCrowd;
    public String eventExpenseAmount;
    public String eventTotalBudgetAmount;
    public List<EventModel> eventLists;
    public String eventType;


    public EventBudgetModel() {
    }

    public EventBudgetModel(String eventBudgetId, String eventBudgetName, String eventCrowd, String eventExpenseAmount, String eventTotalBudgetAmount, List<EventModel> eventLists, String eventType) {
        this.eventBudgetId = eventBudgetId;
        this.eventBudgetName = eventBudgetName;
        this.eventCrowd = eventCrowd;
        this.eventExpenseAmount = eventExpenseAmount;
        this.eventTotalBudgetAmount = eventTotalBudgetAmount;
        this.eventLists = eventLists;
        this.eventType = eventType;
    }

    public String getEventBudgetId() {
        return eventBudgetId;
    }

    public void setEventBudgetId(String eventBudgetId) {
        this.eventBudgetId = eventBudgetId;
    }

    public String getEventBudgetName() {
        return eventBudgetName;
    }

    public void setEventBudgetName(String eventBudgetName) {
        this.eventBudgetName = eventBudgetName;
    }

    public String getEventCrowd() {
        return eventCrowd;
    }

    public void setEventCrowd(String eventCrowd) {
        this.eventCrowd = eventCrowd;
    }

    public String getEventExpenseAmount() {
        return eventExpenseAmount;
    }

    public void setEventExpenseAmount(String eventExpenseAmount) {
        this.eventExpenseAmount = eventExpenseAmount;
    }

    public String getEventTotalBudgetAmount() {
        return eventTotalBudgetAmount;
    }

    public void setEventTotalBudgetAmount(String eventTotalBudgetAmount) {
        this.eventTotalBudgetAmount = eventTotalBudgetAmount;
    }

    public List<EventModel> getEventLists() {
        return eventLists;
    }

    public void setEventLists(List<EventModel> eventLists) {
        this.eventLists = eventLists;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}