package com.example.baitap3;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText etUsername, etEmailRegister, etPasswordRegister, etConfirmPassword;
    Button btnRegisterSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView btn = findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        etUsername = findViewById(R.id.inputUsername);
        etEmailRegister = findViewById(R.id.inputEmail);
        etPasswordRegister = findViewById(R.id.inputPassword);
        etConfirmPassword = findViewById(R.id.inputConformPassword);
        btnRegisterSubmit = findViewById(R.id.btnRegister);

        btnRegisterSubmit.setOnClickListener(v -> {
            String username = etUsername.getText().toString();
            String email = etEmailRegister.getText().toString();
            String password = etPasswordRegister.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if (password.equals(confirmPassword)) {
                showDialog("Đăng ký thành công", "Lưu Ngọc Yến Như 22115053122128");

            } else {
                Toast.makeText(RegisterActivity.this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}