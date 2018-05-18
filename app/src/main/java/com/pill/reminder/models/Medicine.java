package com.pill.reminder.models;

/**
 * Created by SO356253 on 5/4/2018.
 */

public class Medicine {
    String name;
    String quantity;

    public Medicine(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
