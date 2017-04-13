package com.example.manasa.sql;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private EditText TextID;
     private Button AddButton;
     private Button DeleteButton;
     DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextID =(EditText) findViewById (R.id.TextID);
        AddButton= (Button) findViewById(R.id.AddButton);
        mDatabaseHelper=new DatabaseHelper(this);

        AddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newEntry = TextID.getText().toString();
                if(TextID.length()!=0){
                    AddData(newEntry);
                    TextID.setText("");
                }
                else
                    toastMessage("You must enter something!");
            }
        });

        DeleteButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String newEntry){
        boolean insertData=mDatabaseHelper.addData(newEntry);
        if(insertData)
            toastMessage("Data successfully inserted");
        else
            toastMessage("Something went wrong");
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
