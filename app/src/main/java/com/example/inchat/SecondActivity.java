package com.example.inchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        textView.setText(message);
        textView.setVisibility(View.VISIBLE);

    }

    public void returnToMainActivity(View view) {

        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();

        Intent returnIntent = new Intent();
        returnIntent.putExtra("MESSAGE", message);

        if (message.isEmpty()) {
            setResult(RESULT_CANCELED, returnIntent);
        } else {
            setResult(RESULT_OK, returnIntent);
        }
        finish();
    }
}