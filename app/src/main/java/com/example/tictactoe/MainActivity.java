package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String b1Value,b2Value,b3Value,b4Value,b5Value,b6Value,b7Value,b8Value,b9Value;
    int flag=0;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findingId();



    }



    public void findingId(){
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
    }

    public void checkingGame(View view){
        Button currentButton=(Button) view;
        if(currentButton.getText().toString().equals("")) {
            count = count + 1;
            if (flag == 0) {
                currentButton.setText("0");
                flag = 1;
            } else {
                currentButton.setText("X");
                flag = 0;
            }

            if (count >= 5) {
                b1Value = b1.getText().toString();
                b2Value = b2.getText().toString();
                b3Value = b3.getText().toString();
                b4Value = b4.getText().toString();
                b5Value = b5.getText().toString();
                b6Value = b6.getText().toString();
                b7Value = b7.getText().toString();
                b8Value = b8.getText().toString();
                b9Value = b9.getText().toString();

                // condition checking

                if (b1Value.equals(b2Value) && b2Value.equals(b3Value) && !b1Value.equals("")) {
                    // first row
                    Toast.makeText(this, "winner is " + b1Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);

                } else if (b4Value.equals(b5Value) && b5Value.equals(b6Value) && !b4Value.equals("")) {
                    // second row
                    Toast.makeText(this, "winner is " + b4Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);
                } else if (b7Value.equals(b8Value) && b8Value.equals(b9Value) && !b7Value.equals("")) {
                    // third row
                    Toast.makeText(this, "winner is " + b7Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);
                } else if (b1Value.equals(b4Value) && b1Value.equals(b7Value) && !b1Value.equals("")) {
                    // first column
                    Toast.makeText(this, "winner is " + b1Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);
                } else if (b2Value.equals(b5Value) && b5Value.equals(b8Value) && !b2Value.equals("")) {
                    //second column
                    Toast.makeText(this, "winner is " + b2Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);
                } else if (b3Value.equals(b6Value) && b6Value.equals(b9Value) && !b3Value.equals("")) {
                    // third column
                    Toast.makeText(this, "winner is " + b3Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);
                } else if (b1Value.equals(b5Value) && b5Value.equals(b9Value) && !b1Value.equals("")) {
                    //top left - bottom right -- diagonal
                    Toast.makeText(this, "winner is " + b1Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);
                } else if (b7Value.equals(b5Value) && b5Value.equals(b3Value) && !b7Value.equals("")) {
                    // bottom left - top right -- diagonal
                    Toast.makeText(this, "winner is " + b7Value, Toast.LENGTH_SHORT).show();
                    showAlertBox(b1Value);

                }

            }
        }
    }

    public  void newGame(){
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        count=0;
        flag=0;

    }

    private void showAlertBox(String winner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Winner is player '" +winner+"'" );
        builder.setMessage("Do you want to paly again..");
        builder.setIcon(R.drawable.ic_baseline_videogame_asset_24);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newGame();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();



    }

}