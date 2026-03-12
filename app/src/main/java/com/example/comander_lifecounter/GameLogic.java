package com.example.comander_lifecounter;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comander_lifecounter.model.Player;

import java.util.ArrayList;
import java.util.Set;

public class GameLogic extends AppCompatActivity implements View.OnClickListener{

    boolean isToggled1 = false;
    boolean isToggled2 = false;
    boolean isToggled3 = false;
    boolean isToggled4 = false;

    TextView tv1;
    TextView tvCdmg2to1;
    TextView tvCdmg3to1;
    TextView tvCdmg4to1;

    TextView tv2;
    TextView tvCdmg1to2;
    TextView tvCdmg3to2;
    TextView tvCdmg4to2;

    TextView tv3;
    TextView tvCdmg2to3;
    TextView tvCdmg1to3;

    TextView tvCdmg4to3;

    TextView tv4;
    TextView tvCdmg2to4;
    TextView tvCdmg3to4;
    TextView tvCdmg1to4;

    Player p1;
    Player p2;
    Player p3;
    Player p4;

    Button posionBt1;
    Button posionBt2;
    Button posionBt3;
    Button posionBt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_players);
        Bundle extras = getIntent().getExtras();

        p1 = new Player("Player 1", (short) 40);
        p2 = new Player("Player 2", (short) 40);
        p3 = new Player("Player 3", (short) 40);
        p4 = new Player("Player 4", (short) 40);

        posionBt1 = (Button) findViewById(R.id.poison1);
        posionBt2 = (Button) findViewById(R.id.poison2);
        posionBt3 = (Button) findViewById(R.id.poison3);
        posionBt4 = (Button) findViewById(R.id.poison4);

        Button plusP1 = (Button) findViewById(R.id.plus_player1);
        Button plusP2 = (Button) findViewById(R.id.plus_player2);
        Button plusP3 = (Button) findViewById(R.id.plus_player3);
        Button plusP4 = (Button) findViewById(R.id.plus_player4);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);

        tvCdmg2to1 = (TextView) findViewById(R.id.damageRecievebyplayer2to1);
        tvCdmg3to1 = (TextView) findViewById(R.id.damageRecievebyplayer3to1);
        tvCdmg4to1 = (TextView) findViewById(R.id.damageRecievebyplayer4to1);

        tvCdmg1to2 = (TextView) findViewById(R.id.damageRecievebyplayer1to2);
        tvCdmg3to2 = (TextView) findViewById(R.id.damageRecievebyplayer3to2);
        tvCdmg4to2 = (TextView) findViewById(R.id.damageRecievebyplayer4to2);

        tvCdmg2to1 = (TextView) findViewById(R.id.damageRecievebyplayer2to1);
        tvCdmg3to1 = (TextView) findViewById(R.id.damageRecievebyplayer3to1);
        tvCdmg4to1 = (TextView) findViewById(R.id.damageRecievebyplayer4to1);


        plusP1.setOnClickListener(this);
        plusP2.setOnClickListener(this);
        plusP3.setOnClickListener(this);
        plusP4.setOnClickListener(this);

        isToggled();
        activatePoison();
        newGame();
    }

    //Multiples botones
    //No se hace con switch porque da problemas con las nuevas versiones de android studio
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.plus_player1) {
           gainLife(p1,tv1, tvCdmg2to1,tvCdmg3to1,tvCdmg4to1);
            Log.d("funciona", String.valueOf(p1.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.plus_player2) {
            gainLife(p2,tv2, tvCdmg1to2,tvCdmg3to2,tvCdmg4to2);
            Log.d("funciona", String.valueOf(p2.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.plus_player3) {
            gainLife(p3,tv3, tvCdmg1to3,tvCdmg2to3,tvCdmg4to3);
            Log.d("funciona", String.valueOf(p3.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.plus_player4) {
            gainLife(p4,tv4, tvCdmg1to4,tvCdmg2to4,tvCdmg3to4);
            Log.d("funciona", String.valueOf(p4.getLifeTotal() + " -> total normal"));
        }

    }

    private void gainLife (Player player ,TextView tv, TextView tvCdmg2, TextView tvCdmg3, TextView tvCdmg4) {
        if (isToggled4) {
            player.setCmDmgFrom4((short) (player.getCmDmgFrom4() - (short) 1));
            tvCdmg4.setText(String.valueOf(player.getCmDmgFrom4()));
        }else if (isToggled3) {
            player.setCmDmgFrom3((short) (player.getCmDmgFrom3() - (short) 1));
            tvCdmg3.setText(String.valueOf(player.getCmDmgFrom3()));
        }else {
            player.setCmDmgFrom2((short) (player.getCmDmgFrom2() - (short) 1));
            tvCdmg2.setText(String.valueOf(player.getCmDmgFrom2()));
        }
        player.setLifeTotal((short) (player.getLifeTotal()+1));
        Log.d("funciona", player.getName() + ":  " + String.valueOf(player.getLifeTotal()));
        tv.setText(String.valueOf(player.getLifeTotal()));
    }

    //Comander damage
    private void isToggled() {
        ImageButton button = findViewById(R.id.searchImageButton);
        ImageButton button2 = findViewById(R.id.searchImageButton2);
        ImageButton button3 = findViewById(R.id.searchImageButton3);
        ImageButton button4 = findViewById(R.id.searchImageButton4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isToggled1) {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }else {
                    isToggled2 = isToggled3 = isToggled4 = false;
                    isToggled1 = true;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isToggled2) {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }else {
                    isToggled1 = isToggled3 = isToggled4 = false;
                    isToggled2 = true;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isToggled3) {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }else {
                    isToggled1 = isToggled2 = isToggled4 = false;
                    isToggled3 = true;
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isToggled4) {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }else {
                    isToggled1 = isToggled2 = isToggled3 = false;
                    isToggled4 = true;
                }
            }
        });
    }

    public void activatePoison() {
        Button button = (Button) findViewById(R.id.Poison);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button bt1 = (Button) findViewById(R.id.poison1);
                Button bt2 = (Button) findViewById(R.id.poison2);
                Button bt3 = (Button) findViewById(R.id.poison3);
                Button bt4 = (Button) findViewById(R.id.poison4);

                bt1.setVisibility(v.VISIBLE);
                bt2.setVisibility(v.VISIBLE);
                bt3.setVisibility(v.VISIBLE);
                bt4.setVisibility(v.VISIBLE);
            }
        });
    }

    public void newGame() {
        Button button = (Button) findViewById(R.id.newGame);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                p1.resetPlayer( (short) 40);
                p2.resetPlayer( (short) 40);
                p3.resetPlayer( (short) 40);
                p4.resetPlayer( (short) 40);


                isToggled1 = false;
                isToggled2 = false;
                isToggled3 = false;
                isToggled4 = false;

                tv1.setText("40");
                tv2.setText("40");
                tv3.setText("40");
                tv4.setText("40");

                tvCdmg2to1.setText("0");
                tvCdmg2to3.setText("0");
                tvCdmg2to4.setText("0");

                tvCdmg1to2.setText("0");
                tvCdmg3to2.setText("0");
                tvCdmg4to2.setText("0");

                tvCdmg1to3.setText("0");
                tvCdmg2to3.setText("0");
                tvCdmg4to1.setText("0");

                tvCdmg1to4.setText("0");
                tvCdmg2to4.setText("0");
                tvCdmg3to4.setText("0");

                posionBt1.setVisibility(v.INVISIBLE);
                posionBt2.setVisibility(v.INVISIBLE);
                posionBt3.setVisibility(v.INVISIBLE);
                posionBt4.setVisibility(v.INVISIBLE);
            }
        });
    }

}


