package com.example.budgetapplication;

public class BHFragment03Model {

    private String BhItem;
    private String BhDate;
    private String BhPrice;

    public BHFragment03Model() {
    }

    public BHFragment03Model(String bhItem, String bhDate, String bhPrice) {
        BhItem = bhItem;
        BhDate = bhDate;
        BhPrice = bhPrice;
    }


    public String getBhItem() {
        return BhItem;
    }

    public void setBhItem(String bhItem) {
        BhItem = bhItem;
    }

    public String getBhDate() {
        return BhDate;
    }

    public void setBhDate(String bhDate) {
        BhDate = bhDate;
    }

    public String getBhPrice() {
        return BhPrice;
    }

    public void setBhPrice(String bhPrice) {
        BhPrice = bhPrice;
    }
}
