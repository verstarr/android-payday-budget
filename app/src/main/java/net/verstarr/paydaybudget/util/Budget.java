package net.verstarr.paydaybudget.util;

import java.text.NumberFormat;

/**
 * Created by VerStarr22 on 6/13/15.
 */
public class Budget {

    private String title;
    private String description;
    private double percent;
    private double amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Returns a String percent for the budget_list after calculation
    public String percentString(double percent) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);

        return percentFormat.format(percent);
    }
}
