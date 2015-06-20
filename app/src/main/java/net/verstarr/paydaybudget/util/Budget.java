package net.verstarr.paydaybudget.util;

import java.text.NumberFormat;

/**
 * Created by VerStarr22 on 6/13/15.
 */
public class Budget {

    private String title;
    private String description;
    private double percent;

    public Budget() {
        this.title = "New Budget";
        this.description = "Example";
        this.percent = 20.0;
    }

    public Budget(String title, String description, double percent) {
        this.title = title;
        this.description = description;
        this.percent = percent;
    }

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

    public double getAmount() {
        return percent;
    }

    public void setAmount(double percent) { this.percent = percent; }

    // Returns a String percent for the budget_list after calculation
    public String percentString(double percent) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);

        return percentFormat.format(percent);
    }
}
