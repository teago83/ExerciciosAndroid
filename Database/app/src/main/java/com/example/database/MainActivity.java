package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText Id, Name, Hr, Mr, Weapon, Monster;

    Button Add, View, Update, Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        Id = (EditText)findViewById(R.id.id);
        Name = (EditText)findViewById(R.id.hunter_name);
        Hr = (EditText)findViewById(R.id.hr);
        Mr = (EditText)findViewById(R.id.mr);
        Weapon = (EditText)findViewById(R.id.favourite_weapon);
        Monster = (EditText)findViewById(R.id.favourite_monster);

        Add = (Button)findViewById(R.id.add);
        View = (Button)findViewById(R.id.view);
        Update = (Button)findViewById(R.id.update);
        Delete = (Button)findViewById(R.id.delete);

        AddData();
        ShowData();
        UpdateData();
        DeleteData();
    }

    public void AddData() {
        Add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        boolean Result = db.InsertData(Name.getText().toString(),
                                                       Hr.getText().toString(),
                                                       Mr.getText().toString(),
                                                       Weapon.getText().toString(),
                                                       Monster.getText().toString());

                        if (Result)
                            Toast.makeText(MainActivity.this, "Data successfully inserted!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Unable to insert data...", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void ShowData() {
        View.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Cursor Result = db.ShowData();

                        if (Result.getCount() == 0){
                            ShowMessage("Error!", "No data was found!");
                            return;
                        }

                        StringBuffer Buffer = new StringBuffer();
                        while (Result.moveToNext()) {
                            Buffer.append("ID: " + Result.getString(0) + "\n");
                            Buffer.append("Hunter's Name: " + Result.getString(1) + "\n");
                            Buffer.append("HR: " + Result.getString(2) + "\n");
                            Buffer.append("MR: " + Result.getString(3) + "\n");
                            Buffer.append("Favourite Weapon: " + Result.getString(4) + "\n");
                            Buffer.append("Favourite Monster: " + Result.getString(5) + "\n");
                        }

                        ShowMessage("Data: ", Buffer.toString());
                    }
                }
        );
    }

    public void UpdateData() {
        Update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        boolean HasUpdated = db.UpdateData(Id.getText().toString(),
                                                           Name.getText().toString(),
                                                           Hr.getText().toString(),
                                                           Mr.getText().toString(),
                                                           Weapon.getText().toString(),
                                                           Monster.getText().toString());

                        if (HasUpdated)
                            Toast.makeText(MainActivity.this, "Data successfully updated!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Unable to update data...", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void DeleteData() {
        Delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        Integer DeletedRows = db.DeleteData(Id.getText().toString());

                        if (DeletedRows > 0)
                            Toast.makeText(MainActivity.this, "Data successfully deleted!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Unable to delete data...", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void ShowMessage(String Title, String Message) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setCancelable(true);
        Builder.setTitle(Title);
        Builder.setMessage(Message);
        Builder.show();
    }


}