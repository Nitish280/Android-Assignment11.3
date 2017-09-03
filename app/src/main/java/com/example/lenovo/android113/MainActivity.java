package com.example.lenovo.android113;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaration
    TextView empName,empAge;
    ImageView imageView;
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DBHelper(this);
        //Creating object of Employee
        Employee employee=new Employee("Nitish",22,(BitmapFactory.decodeResource(getResources(),R.drawable.user)));
        //here we are calling open Method
        dbHelper.open();
        //here we are insertEmployee method
        dbHelper.insertEmployee(employee);
        Employee employee1=dbHelper.retriveEmpDetails();
        //Setting up UI Component
        empName=(TextView)findViewById(R.id.name);
        //Setting Name
        empName.setText(employee1.getEmployeeName());
        empAge=(TextView)findViewById(R.id.age);
        //Setting Age
        empAge.setText(String.valueOf(employee1.getEmployeeAge()));
        imageView=(ImageView)findViewById(R.id.imageView);
        //Setting Image
        imageView.setImageBitmap(employee1.employeeimageInByte);


    }
}
