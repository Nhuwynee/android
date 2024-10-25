package com.example.sharded_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText masinhvien, hoten;
    CheckBox remember;
    Button login, showInf;
    TextView textMasv, textHoten;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Anhxa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        masinhvien.setText(sharedPreferences.getString("masinhvien",""));
        hoten.setText(sharedPreferences.getString("hotensv",""));
        remember.setChecked(sharedPreferences.getBoolean("Checked", false));

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String ma = masinhvien.getText().toString().trim();
                String ten = hoten.getText().toString().trim();

                if (ma.equals("22115053122128") && ten.equals("Luu Ngoc Yen Nhu")) {
                    Toast.makeText(MainActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                    if (remember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("masinhvien", ma);
                        editor.putString("hotensv", ten);
                        editor.putBoolean("Checked", true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("masinhvien");
                        editor.remove("hotensv");
                        editor.remove("Checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Lỗi !!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedUsername = sharedPreferences.getString("masinhvien", "Chưa có dữ liệu");
                String savedPassword = sharedPreferences.getString("hotensv", "Chưa có dữ liệu");

                textMasv.setText("Mã sinh viên: " + savedUsername);
                textHoten.setText("Họ và tên: " + savedPassword);
            }
        });
    }

    private void Anhxa() {
        masinhvien = findViewById(R.id.et_msv);
        hoten = findViewById(R.id.et_hoten);
        remember = findViewById(R.id.cb_remeber);
        login = findViewById(R.id.btn_login);
        showInf = findViewById(R.id.btn_showinf);
        textMasv = findViewById(R.id.textMsv);
        textHoten = findViewById(R.id.textHoten);
    }
}
