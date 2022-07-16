package MainApp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyDate
{
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate()
    {

    }


    public void print()
    {
        if(this != null)
        System.out.println(toString());
    }

    @Override
    public String toString()
    {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
