package com.tdevelopments.ludo_game;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog;
import com.tdevelopments.ludo_game.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginTv.setOnClickListener(view -> showBottomSheet());
    }

    private void showBottomSheet() {
        RoundedBottomSheetDialog mBottomSheetDialog = new RoundedBottomSheetDialog(LoginActivity.this);
        View sheetView = mBottomSheetDialog.getLayoutInflater().inflate(R.layout.login_bottom_sheet, null);

        mBottomSheetDialog.setContentView(sheetView);

        mBottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mBottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mBottomSheetDialog.setContentView(sheetView);

        TextView sendOtp = mBottomSheetDialog.findViewById(R.id.sendOtp_tv);

        if (sendOtp != null)
            sendOtp.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), OtpActivity.class)));

        mBottomSheetDialog.show();
    }
}