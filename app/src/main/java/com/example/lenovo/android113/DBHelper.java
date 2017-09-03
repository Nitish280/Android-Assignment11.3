package com.example.lenovo.android113;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.icu.lang.UProperty.AGE;

/**
 * Created by lenovo on 8/12/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    //all static variable
    //database name
    public static final String DATABASE_NAME = "employeeDBName.db";
    //database version
    private static final int DATABASE_VERSION = 1;
    //table name
    public static final String EMPLOYEE_TABLE_NAME = "employees";
    public static final String EMPLOYEE_NAME = "employeeName";
    public static final String EMPLOYEE_ID = "id";
    public static final String EMPLOYEE_AGE = "employeeAge";
    private static final String EMPLOYEE_IMAGE = "employeeImage";

    private static final String CREATE_EMPLOYEE_TABLE = ("CREATE TABLE " + EMPLOYEE_TABLE_NAME + " ("
            + EMPLOYEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + EMPLOYEE_NAME + " text,"
            + EMPLOYEE_AGE + " text,"
            + EMPLOYEE_IMAGE + " BLOB NOT NULL );");

    private SQLiteDatabase db = null;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //oncreate method
    public void onCreate(SQLiteDatabase db) {
        //creating table in db
        db.execSQL(CREATE_EMPLOYEE_TABLE);
        this.db = db;


    }

    @Override
    //onUpgrade method
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS employees");
        onCreate(db);
    }

    //here we are opening the database
    public void open() {
        if (this.db == null) {
            this.db = this.getWritableDatabase();
        }
    }

    //here we are close the db
    public void close() {
        if (this.db != null) {
            if (this.db.isOpen())
                this.db.close();
        }
    }
    //here we are creating insertEmployee() method
    public boolean insertEmployee(Employee employee) {
        //here we are creating object of contentValues
        ContentValues contentValues = new ContentValues();
        //here we putting employee name
        contentValues.put(EMPLOYEE_NAME, employee.getEmployeeName());
        //here we putting employee age
        contentValues.put(EMPLOYEE_AGE, employee.getEmployeeAge());
        contentValues.put(EMPLOYEE_IMAGE, Utilities.getBytes(employee.getEmployeeimageInByte()));
        //here we insterting table name in db
        db.insert(EMPLOYEE_TABLE_NAME, null, contentValues);
        return true;
    }
    //here we are creating retriveEmpDetails() method
    public Employee retriveEmpDetails() throws SQLException {
        //Applying Query on db
        Cursor cur = db.query(true, EMPLOYEE_TABLE_NAME, new String[]{EMPLOYEE_IMAGE,
                EMPLOYEE_NAME, EMPLOYEE_AGE}, null, null, null, null, null, null);
        //Applying Condition
        if (cur.moveToLast()) {
            String employeeName = cur.getString(cur.getColumnIndex(EMPLOYEE_NAME));
            int employeeAge = cur.getInt(cur.getColumnIndex(EMPLOYEE_AGE));
            byte[] blob = cur.getBlob(cur.getColumnIndex(EMPLOYEE_IMAGE));
            cur.close();
            return new Employee(employeeName, employeeAge, Utilities.getPhoto(blob));

        }
        cur.close();
        return null;
    }
}


