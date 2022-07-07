package com.tdevelopments.ludo_game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tdevelopments.ludo_game.databinding.ActivityPlayerConfigureBinding;

import java.util.ArrayList;

public class PlayerConfigureActivity extends AppCompatActivity {

    private final int NO_PLAYER = 0;
    private final int HUMAN_PLAYER = 1;
    private final ArrayList<Integer> players = new ArrayList<>();
    private ActivityPlayerConfigureBinding binding;
    private int RedP, BlueP, GreenP, YellowP;
    private int totalPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        YellowP = HUMAN_PLAYER;
        GreenP = HUMAN_PLAYER;
        totalPlayers = 2;
        RedP = NO_PLAYER;
        BlueP = NO_PLAYER;

        binding = ActivityPlayerConfigureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startGameTv.setOnClickListener(view -> startGame());

        binding.icBack.setOnClickListener(view -> finish());

//        binding.twoPlayerLayout.setOnClickListener(view -> changeCheck(binding.twoPlayerIc));
//        binding.threePlayerLayout.setOnClickListener(view -> changeCheck(binding.threePlayerIc));
//        binding.fourPlayerLayout.setOnClickListener(view -> changeCheck(binding.fourPlayerIc));

        binding.redPlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.redPlayerIc));
        binding.greenPlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.greenPlayerIc));
        binding.bluePlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.bluePlayerIc));
        binding.yellowPlayerLayout.setOnClickListener(view -> changePlayerStatus(binding.yellowPlayerIc));
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
        if (RedP == HUMAN_PLAYER) players.add(1);
        if (GreenP == HUMAN_PLAYER) players.add(2);
        if (BlueP == HUMAN_PLAYER) players.add(3);
        if (YellowP == HUMAN_PLAYER) players.add(4);
    }

//    private ArrayList<Integer> getPlayers() {
//        ArrayList<Integer> players = new ArrayList<>();
//        for (int playerId : playerIds) {
//            if (playerId != 0) {
//                players.add(playerId);
//            }
//        }
//        return players;
//    }

    private void changePlayerStatus(ImageView imageView) {
        if (imageView == binding.redPlayerIc) {
            RedP += 1;
            if (RedP == 2) {
                RedP = 0;
                totalPlayers -= 1;
            }
        } else if (imageView == binding.bluePlayerIc) {
            BlueP += 1;
            if (BlueP == 2) BlueP = 0;
        } else if (imageView == binding.greenPlayerIc) {
            GreenP += 1;
            if (GreenP == 2) GreenP = 0;
        } else if (imageView == binding.yellowPlayerIc) {
            YellowP += 1;
            if (YellowP == 2) YellowP = 0;
        }
        changePlayerImage();
    }

    private void changePlayerImage() {
        if (RedP == NO_PLAYER) {
            binding.redPlayerIc.setImageResource(R.drawable.custom_empty_drawable);
            totalPlayers += 1;
        } else if (RedP == HUMAN_PLAYER) {
            binding.redPlayerIc.setImageResource(R.drawable.ic_person);
            totalPlayers -= 1;
        }
//        else if (RedP == COMP_PLAYER) binding.redPlayerIc.setImageResource(R.drawable.ic_ai);

        if (GreenP == NO_PLAYER) {
            binding.greenPlayerIc.setImageResource(R.drawable.custom_empty_drawable);
            totalPlayers += 1;
        } else if (GreenP == HUMAN_PLAYER) {
            binding.greenPlayerIc.setImageResource(R.drawable.ic_person);
            totalPlayers -= 1;
        }
//        else if (GreenP == COMP_PLAYER) binding.greenPlayerIc.setImageResource(R.drawable.ic_ai);

        if (BlueP == NO_PLAYER) {
            binding.bluePlayerIc.setImageResource(R.drawable.custom_empty_drawable);
            totalPlayers += 1;
        } else if (BlueP == HUMAN_PLAYER) {
            totalPlayers -= 1;
            binding.bluePlayerIc.setImageResource(R.drawable.ic_person);
        }
//        else if (BlueP == COMP_PLAYER) binding.bluePlayerIc.setImageResource(R.drawable.ic_ai);

        if (YellowP == NO_PLAYER) {
            binding.yellowPlayerIc.setImageResource(R.drawable.custom_empty_drawable);
            totalPlayers += 1;
        } else if (YellowP == HUMAN_PLAYER) {
            totalPlayers -= 1;
            binding.yellowPlayerIc.setImageResource(R.drawable.ic_person);
        }
//        else if (YellowP == COMP_PLAYER) binding.yellowPlayerIc.setImageResource(R.drawable.ic_ai);
        changeCheck();
    }

    private void changeCheck() {
        Log.i("PlayerConfiguration", "changeCheck: TotalPlayers - "+totalPlayers);
        binding.twoPlayerIc.setImageResource(R.drawable.custom_empty_drawable);
        binding.threePlayerIc.setImageResource(R.drawable.custom_empty_drawable);
        binding.fourPlayerIc.setImageResource(R.drawable.custom_empty_drawable);

        if (totalPlayers == 2)
            binding.twoPlayerIc.setImageResource(R.drawable.ic_check);
        if (totalPlayers == 3)
            binding.threePlayerIc.setImageResource(R.drawable.ic_check);
        if (totalPlayers == 4)
            binding.fourPlayerIc.setImageResource(R.drawable.ic_check);


//        imageView.setImageResource(R.drawable.ic_check);
//        if (imageView == binding.twoPlayerIc) ;
//        else if (imageView == binding.threePlayerIc) ;
//        else if (imageView == binding.fourPlayerIc) ;
    }
}