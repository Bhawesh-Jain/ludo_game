package com.tdevelopments.ludo_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.tdevelopments.ludo_game.databinding.ActivityPlayerConfigureBinding;

public class PlayerConfigureActivity extends AppCompatActivity {

    private ActivityPlayerConfigureBinding binding;
    private boolean twoPlayers, threePlayers, fourPlayers = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        twoPlayers = true;
        binding = ActivityPlayerConfigureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startGameTv.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LudoActivity.class)));

        binding.icBack.setOnClickListener(view -> finish());

        binding.twoPlayerLayout.setOnClickListener(view -> changeCheck(binding.twoPlayerIc));
        binding.threePlayerLayout.setOnClickListener(view -> changeCheck(binding.threePlayerIc));
        binding.fourPlayerLayout.setOnClickListener(view -> changeCheck(binding.fourPlayerIc));
    }

    private void changeCheck(ImageView imageView) {
        twoPlayers = false;
        threePlayers = false;
        fourPlayers = false;
        binding.twoPlayerIc.setImageResource(R.drawable.custom_empty_drawable);
        binding.threePlayerIc.setImageResource(R.drawable.custom_empty_drawable);
        binding.fourPlayerIc.setImageResource(R.drawable.custom_empty_drawable);

        imageView.setImageResource(R.drawable.ic_check);
        if (imageView == binding.twoPlayerIc) twoPlayers = true;
        else if (imageView == binding.threePlayerIc) threePlayers = true;
        else if (imageView == binding.fourPlayerIc) fourPlayers = true;
    }
}