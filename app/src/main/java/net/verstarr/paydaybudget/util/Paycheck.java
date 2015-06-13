package net.verstarr.paydaybudget.util;

import java.util.Date;

/**
 * Created by VerStarr22 on 6/13/15.
 */
public class Paycheck {

    private Date date;
    private Integer amount;
    private String name;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
