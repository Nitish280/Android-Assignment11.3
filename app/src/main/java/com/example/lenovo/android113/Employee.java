package com.example.lenovo.android113;

import android.graphics.Bitmap;

/**
 * Created by lenovo on 8/12/2017.
 */

public class Employee {
    //Declaration
    String employeeName;
    int employeeAge;
    Bitmap employeeimageInByte;
    //Creating Constructor
    public Employee(String employeeName, int employeeAge, Bitmap employeeimageInByte){
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeimageInByte = employeeimageInByte;
    }

    //Using Geeter and Seeter
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public Bitmap getEmployeeimageInByte() {
        return employeeimageInByte;
    }

    public void setEmployeeimageInByte(Bitmap employeeimageInByte) {
        this.employeeimageInByte = employeeimageInByte;
    }


}
