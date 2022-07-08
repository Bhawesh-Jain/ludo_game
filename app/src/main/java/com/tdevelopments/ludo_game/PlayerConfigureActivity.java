package com.tdevelopments.ludo_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tdevelopments.ludo_game.databinding.ActivityPlayerConfigureBinding;

import java.util.ArrayList;

public class PlayerConfigureActivity extends AppCompatActivity {

    private final ArrayList<Integer> players = new ArrayList<>();
    private ActivityPlayerConfigureBinding binding;
    private boolean redP, blueP, greenP, yellowP;
    private int totalPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        yellowP = true;
        greenP = true;
        totalPlayers = 2;
        redP = false;
        blueP = false;

        binding = ActivityPlayerConfigureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startGameTv.setOnClickListener(view -> startGame());

        binding.icBack.setOnClickListener(view -> finish());

        binding.redPlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.redPlayerIc));
        binding.greenPlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.greenPlayerIc));
        binding.bluePlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.bluePlayerIc));
        binding.yellowPlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.yellowPlayerIc));
    }

    private void changePlayerStatus(ImageView imageView) {
        boolean result = false;
        if (binding.redPlayerIc == imageView) {
            if (redP) {
                redP = false;
                totalPlayers -= 1;
            } else {
                redP = true;
                result = true;
                totalPlayers += 1;
            }
        } else if (binding.bluePlayerIc == imageView) {
            if (blueP) {
                blueP = false;
                totalPlayers -= 1;
            } else {
                blueP = true;
                result = true;
                totalPlayers += 1;
            }
        } else if (binding.greenPlayerIc == imageView) {
            if (greenP) {
                greenP = false;
                totalPlayers -= 1;
            } else {
                greenP = true;
                result = true;
                totalPlayers += 1;
            }
        } else if (binding.yellowPlayerIc == imageView) {
            if (yellowP) {
                yellowP = false;
                totalPlayers -= 1;
            } else {
                yellowP = true;
                result = true;
                totalPlayers += 1;
            }
        }
        if (result) imageView.setImageResource(R.drawable.ic_person);
        else imageView.setImageResource(R.drawable.custom_empty_drawable);
        changeCheck();
    }

    private void startGame() {
        Intent intent = new Intent(getApplicationContext(), LudoActivity.class);
        checkPlayers();
        if (players.size() < 2) {
            Toast.makeText(this, "At Least 2 Players Required!", Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra("players", players);
        startActivity(intent);
    }

    private void checkPlayers() {
        players.clear();
        if (redP) players.add(1);
        if (greenP) players.add(2);
        if (blueP) players.add(3);
        if (yellowP) players.add(4);
    }

    private void changeCheck() {
        binding.twoPlayerIc.setImageResource(R.drawable.custom_empty_drawable);
        binding.threePlayerIc.setImageResource(R.drawable.custom_empty_drawable);
        binding.fourPlayerIc.setImageResource(R.drawable.custom_empty_drawable);

        if (totalPlayers == 2) binding.twoPlayerIc.setImageResource(R.drawable.ic_check);
        if (totalPlayers == 3) binding.threePlayerIc.setImageResource(R.drawable.ic_check);
        if (totalPlayers == 4) binding.fourPlayerIc.setImageResource(R.drawable.ic_check);
    }
}