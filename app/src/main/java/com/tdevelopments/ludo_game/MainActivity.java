package com.tdevelopments.ludo_game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.tdevelopments.ludo_game.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    public void onBackPressed() {
        exit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.localMultiplayer.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PlayerConfigureActivity.class)));
        binding.vsComputer.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PlayerConfigureActivity.class)));

        binding.icExit.setOnClickListener(view -> exit());

        binding.icSettings.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SettingsActivity.class)));

        binding.shareApp.setOnClickListener(view -> shareApp());
    }


    private void exit() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialogInterface, i) -> this.finishAffinity())
                .setNegativeButton("No", null)
                .show();
    }

    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBody = "Your body here";
        String shareSub = "Your Link here";
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
        intent.putExtra(Intent.EXTRA_TEXT,shareSub);
        startActivity(Intent.createChooser(intent, "Share using"));
    }


}
