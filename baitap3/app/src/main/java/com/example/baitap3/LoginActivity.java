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

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLogin, etPasswordLogin;
    Button btnLoginSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        Button btnWithIcon = findViewById(R.id.button10);
        btnWithIcon.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_gg, 0, 0, 0);
        Button btnWithIcon1 = findViewById(R.id.button12);
        btnWithIcon1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_fb, 0, 0, 0);

        etEmailLogin = findViewById(R.id.inputEmail);
        etPasswordLogin = findViewById(R.id.inputUsername);
        btnLoginSubmit = findViewById(R.id.btnLogin);

        btnLoginSubmit.setOnClickListener(v -> {
            String email = etEmailLogin.getText().toString();
            String password = etPasswordLogin.getText().toString();

            if (email.equals("yennhu810@gmail.com") && password.equals("123")) {
                showDialog("Đăng nhập thành công", "Lưu Ngọc Yến Như 22115053122128\n" + "\nEmail: " + email + "\nPassword: " + password);
            } else {
                Toast.makeText(LoginActivity.this, "Email hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
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
