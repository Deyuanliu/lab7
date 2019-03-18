package com.example.lab7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.lab7.R.layout.dialog;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private View middle;
    private EditText et;
    private Dialog dialog;
    private Button n;
    private Button p;
    private Snackbar sb;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        message="You clicked on the overflow menu";
        setSupportActionBar(mToolbar);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.choice1:
                Toast.makeText(this, "This is the initial message", Toast.LENGTH_SHORT).show();
                break;

            case R.id.choice2:
                openDialog();
                break;

            case R.id.choice4:
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                  break;

            case R.id.choice3:
                sb = Snackbar.make(mToolbar, "", Snackbar.LENGTH_LONG);
                sb.setAction("Go back?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

                sb.show();
                break;

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void openDialog() {
        View middle = getLayoutInflater().inflate(R.layout.dialog, null);
        final EditText et = (EditText) middle.findViewById(R.id.edittext);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("What is your new messsage");
        builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Toast.makeText(getApplicationContext(), et.getText().toString(), Toast.LENGTH_SHORT).show();
                message = et.getText().toString();
            }
        });
        builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        builder.setView(middle);

        builder.create().show();
    }

}
