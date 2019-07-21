package com.example.helloworld;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageButton imageButton;
    private EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edittext);
        imageButton = (ImageButton) findViewById(R.id.imagebutton);
    }
    public void onButtonClicked(View view){
        showDialog();

    }
    public void showTost(){
        String input = "입력하였습니다";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, input, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }
    public void showDialog(){
        Editable input = editText.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(input+"");
        builder.setTitle("입력 정보 확인");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showTost();
                Editable input = editText.getText();
                textView.setText(input+"");
                editText.setText("");
            }
        });
        builder.setNegativeButton("취소",null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
