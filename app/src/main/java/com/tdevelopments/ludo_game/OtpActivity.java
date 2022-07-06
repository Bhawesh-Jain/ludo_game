package com.tdevelopments.ludo_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.tdevelopments.ludo_game.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {

    private ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnVerify.setOnClickListener(view -> verify());

        binding.icBack.setOnClickListener(view -> finish());
    }

    private void verify() {
        if (binding.otpPinView.getText() != null && binding.otpPinView.getText().length() == 4) {
            Intent intent = new Intent(OtpActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else Toast.makeText(this, "Enter a valid Otp first!", Toast.LENGTH_SHORT).show();
    }
}