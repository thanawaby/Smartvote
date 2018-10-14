package com.example.smartvote;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        final EditText one = findViewById(R.id.sum);
        Button check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String id = one.getText().toString();

                if (id.length()!=13){
                    Toast t = Toast.makeText(page2.this, "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    String print = "";
                    boolean check = checkID(id);
                    if (check == true) {
                        print = "คุณเป็นผู้มีสิทธิเลือกตั้ง";
                    } else {
                        print = "คุณไม่มีสิทธิเลือกตั้ง";
                    }

                    AlertDialog.Builder dialog = new AlertDialog.Builder(page2.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setMessage(print);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.setCancelable(true);
                    dialog.show();


                }






            }
            private boolean checkID(String number) {
                char c = number.charAt(0);
                int lenght = number.length();
                int count = 0;
                for (int i = 0; i < lenght; i++) {
                    if (number.charAt(i) == c) {
                        count++;
                    }
                }
                if (count == lenght)
                    return true;
                else
                    return false;
            }
        });

    }
}
