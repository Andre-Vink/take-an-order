package cc.vink.takeanorder;

import java.io.Serializable;

/**
 * Person that can order.
 */

public class Person implements Serializable {
    String name;
    int bami;
    int broodjeBami;
    int kroket;
    int broodjeKroket;
    int frikandel;
    int broodjeFrikandel;
    boolean isOpen;

    public Person(String name) {
        this.name = name;
    }

    public String getBamiOrderText() {
        boolean prev = false;
        StringBuilder builder = new StringBuilder();
        if (bami > 0) {
            if (prev) builder.append(", ");
            builder.append(bami).append(" Bami");
            prev = true;
        }
        if (broodjeBami > 0) {
            if (prev) builder.append(", ");
            builder.append(broodjeBami).append(" Broodje Bami");
        }
        return builder.toString();
    }

    public String getFrikandelOrderText() {
        boolean prev = false;
        StringBuilder builder = new StringBuilder();
        if (frikandel > 0) {
            if (prev) builder.append(", ");
            builder.append(frikandel).append(" Frikandel");
            prev = true;
        }
        if (broodjeFrikandel > 0) {
            if (prev) builder.append(", ");
            builder.append(broodjeFrikandel).append(" Broodje Frikandel");
        }
        return builder.toString();
    }

    public String getKroketOrderText() {
        boolean prev = false;
        StringBuilder builder = new StringBuilder();
        if (kroket > 0) {
            if (prev) builder.append(", ");
            builder.append(kroket).append(" Kroket");
            prev = true;
        }
        if (broodjeKroket > 0) {
            if (prev) builder.append(", ");
            builder.append(broodjeKroket).append(" Broodje Kroket");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "Person[name=" + name + "]";
    }
}
