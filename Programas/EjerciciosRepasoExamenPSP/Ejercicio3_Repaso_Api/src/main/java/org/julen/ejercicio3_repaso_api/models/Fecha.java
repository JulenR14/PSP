package org.julen.ejercicio3_repaso_api.models;

import lombok.Data;

/**
 * This is a model class for Fecha.
 * It uses Lombok's @Data annotation to generate getters, setters, equals, hashCode, and toString methods.
 */
@Data
public class Fecha {

    // Day of the month
    private int day;

    // Month of the year
    private int month;

    // Year
    private int year;

    /**
     * This is a constructor for the Fecha class.
     * It initializes the day, month, and year of the Fecha object.
     * @param day The day of the month.
     * @param month The month of the year.
     * @param year The year.
     */
    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

}