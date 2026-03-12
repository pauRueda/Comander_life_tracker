package com.example.comander_lifecounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.comander_lifecounter.model.Player;
import com.example.comander_lifecounter.model.Pop;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    Button poisonBt1;
    Button poisonBt2;
    Button poisonBt3;
    Button poisonBt4;

    Button plusP1;
    Button plusP2;
    Button plusP3;
    Button plusP4;

    Button minusP1;
    Button minusP2;
    Button minusP3;
    Button minusP4;

    ImageButton rollDice;

    TextView setting1;
    TextView setting2;
    TextView setting3;
    TextView setting4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_players);
        Bundle extras = getIntent().getExtras();

        p1 = new Player("Player 1", (short) 40);
        p2 = new Player("Player 2", (short) 40);
        p3 = new Player("Player 3", (short) 40);
        p4 = new Player("Player 4", (short) 40);

        poisonBt1 = (Button) findViewById(R.id.poison1);
        poisonBt2 = (Button) findViewById(R.id.poison2);
        poisonBt3 = (Button) findViewById(R.id.poison3);
        poisonBt4 = (Button) findViewById(R.id.poison4);

        plusP1 = (Button) findViewById(R.id.plus_player1);
        plusP2 = (Button) findViewById(R.id.plus_player2);
        plusP3 = (Button) findViewById(R.id.plus_player3);
        plusP4 = (Button) findViewById(R.id.plus_player4);

        minusP1 = (Button) findViewById(R.id.minus_player1);
        minusP2 = (Button) findViewById(R.id.minus_player2);
        minusP3 = (Button) findViewById(R.id.minus_player3);
        minusP4 = (Button) findViewById(R.id.minus_player4);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);

        rollDice = (ImageButton) findViewById(R.id.rollDice);
        setting1 = (TextView) findViewById(R.id.settingsPlayer1);
        setting2 = (TextView) findViewById(R.id.settingsPlayer2);
        setting3 = (TextView) findViewById(R.id.settingsPlayer3);
        setting4 = (TextView) findViewById(R.id.settingsPlayer4);

        tvCdmg2to1 = (TextView) findViewById(R.id.damageRecievebyplayer2to1);
        tvCdmg3to1 = (TextView) findViewById(R.id.damageRecievebyplayer3to1);
        tvCdmg4to1 = (TextView) findViewById(R.id.damageRecievebyplayer4to1);

        tvCdmg1to2 = (TextView) findViewById(R.id.damageRecievebyplayer1to2);
        tvCdmg3to2 = (TextView) findViewById(R.id.damageRecievebyplayer3to2);
        tvCdmg4to2 = (TextView) findViewById(R.id.damageRecievebyplayer4to2);

        tvCdmg1to3 = (TextView) findViewById(R.id.damageRecievebyplayer1to3);
        tvCdmg2to3 = (TextView) findViewById(R.id.damageRecievebyplayer2to3);
        tvCdmg4to3 = (TextView) findViewById(R.id.damageRecievebyplayer4to3);

        tvCdmg1to4 = (TextView) findViewById(R.id.damageRecievebyplayer1to4);
        tvCdmg2to4 = (TextView) findViewById(R.id.damageRecievebyplayer2to4);
        tvCdmg3to4 = (TextView) findViewById(R.id.damageRecievebyplayer3to4);

        isToggled();
        rollDice();
       // changeSettings();
        activatePoison();
        newGame();

        plusP1.setOnClickListener(this);
        plusP2.setOnClickListener(this);
        plusP3.setOnClickListener(this);
        plusP4.setOnClickListener(this);

        minusP1.setOnClickListener(this);
        minusP2.setOnClickListener(this);
        minusP3.setOnClickListener(this);
        minusP4.setOnClickListener(this);

        poisonBt1.setOnClickListener(this);
        poisonBt2.setOnClickListener(this);
        poisonBt3.setOnClickListener(this);
        poisonBt4.setOnClickListener(this);

    }

    //Multiples botones
    //No se hace con switch porque da problemas con las nuevas versiones de android studio
    @Override
    public void onClick(View v) {
        Log.d("funciona", String.valueOf(isToggled1));
        Log.d("funciona", String.valueOf(isToggled2));
        Log.d("funciona", String.valueOf(isToggled3));
        Log.d("funciona", String.valueOf(isToggled4));
        if (v.getId() == R.id.plus_player1) {
            gainLife(p1,tv1,tvCdmg2to1,tvCdmg2to1,tvCdmg3to1,tvCdmg4to1);
            Log.d("funciona", String.valueOf(p1.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.plus_player2) {
            gainLife(p2,tv2, tvCdmg1to2,tvCdmg2to1, tvCdmg3to2,tvCdmg4to2);
            Log.d("funciona", String.valueOf(p2.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.plus_player3) {
            gainLife(p3,tv3, tvCdmg1to3,tvCdmg2to3,tvCdmg2to1,tvCdmg4to3);
            Log.d("funciona", String.valueOf(p3.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.plus_player4) {
            gainLife(p4,tv4, tvCdmg1to4,tvCdmg2to4,tvCdmg3to4,tvCdmg2to1);
            Log.d("funciona", String.valueOf(p4.getLifeTotal() + " -> total normal"));
        }else if (v.getId() == R.id.minus_player1) {
            loseLife(p1,tv1, tvCdmg2to1,tvCdmg2to1,tvCdmg3to1,tvCdmg4to1);
        }else if (v.getId() == R.id.minus_player2) {
            loseLife(p2,tv2, tvCdmg1to2,tvCdmg2to1, tvCdmg3to2,tvCdmg4to2);
        }else if (v.getId() == R.id.minus_player3) {
            loseLife(p3,tv3, tvCdmg1to3,tvCdmg2to3,tvCdmg2to1,tvCdmg4to3);
        }else if (v.getId() == R.id.minus_player4) {
            loseLife(p4,tv4, tvCdmg1to4,tvCdmg2to4,tvCdmg3to4,tvCdmg2to1);
        }else if (v.getId() == R.id.poison1) {
            int value = Integer.parseInt(String.valueOf(poisonBt1.getText()));
            poisonBt1.setText(String.valueOf(value + 1));
        }else if (v.getId() == R.id.poison2) {
            int value = Integer.parseInt(String.valueOf(poisonBt2.getText()));
            poisonBt2.setText(String.valueOf(value + 1));
        }else if (v.getId() == R.id.poison3) {
            int value = Integer.parseInt(String.valueOf(poisonBt3.getText()));
            poisonBt3.setText(String.valueOf(value + 1));
        }else if (v.getId() == R.id.poison4) {
            int value = Integer.parseInt(String.valueOf(poisonBt4.getText()));
            poisonBt4.setText(String.valueOf(value + 1));
        }
    }

    private void gainLife (Player player ,TextView tv,TextView tvCdmg ,TextView tvCdmg2, TextView tvCdmg3, TextView tvCdmg4) {
        if (isToggled4) {
                player.setCmDmgFrom4((short) (player.getCmDmgFrom4() - (short) 1));
                tvCdmg4.setText(String.valueOf(player.getCmDmgFrom4()));
        }else if (isToggled3) {
                player.setCmDmgFrom3((short) (player.getCmDmgFrom3() - (short) 1));
                tvCdmg3.setText(String.valueOf(player.getCmDmgFrom3()));
        }else if (isToggled2){
                player.setCmDmgFrom2((short) (player.getCmDmgFrom2() - (short) 1));
                tvCdmg2.setText(String.valueOf(player.getCmDmgFrom2()));
        }else if (isToggled1){
            if (!player.getName().equalsIgnoreCase("Player 1")) {
                player.setCmDmgFrom1((short) (player.getCmDmgFrom1() - (short) 1));
                tvCdmg.setText(String.valueOf(player.getCmDmgFrom1()));
            }
        }else {
            Log.d("funciona", String.valueOf("Sustituir esto por una excepcion personalizada"));
        }
        player.setLifeTotal((short) (player.getLifeTotal()+1));
        tv.setText(String.valueOf(player.getLifeTotal()));
    }

    private void loseLife(Player player ,TextView tv,TextView tvCdmg ,TextView tvCdmg2, TextView tvCdmg3, TextView tvCdmg4) {
        if (isToggled4) {
                player.setCmDmgFrom4((short) (player.getCmDmgFrom4() + (short) 1));
                tvCdmg4.setText(String.valueOf(player.getCmDmgFrom4()));
        }else if (isToggled3) {
                player.setCmDmgFrom3((short) (player.getCmDmgFrom3() + (short) 1));
                tvCdmg3.setText(String.valueOf(player.getCmDmgFrom3()));
        }else if (isToggled2){
                player.setCmDmgFrom2((short) (player.getCmDmgFrom2() + (short) 1));
                tvCdmg2.setText(String.valueOf(player.getCmDmgFrom2()));
        }
        else if (isToggled1){
            if (!player.getName().equalsIgnoreCase("Player 1")) {
                player.setCmDmgFrom1((short) (player.getCmDmgFrom1() + (short) 1));
                tvCdmg.setText(String.valueOf(player.getCmDmgFrom1()));
            }
        }else {
            Log.d("funciona", "Sustituir esto por una excepcion personalizada");
        }
        player.setLifeTotal((short) (player.getLifeTotal() - 1));
        tv.setText(String.valueOf(player.getLifeTotal()));
    }

    public boolean markComanderDamage (boolean isToggled1, ImageButton button, ImageButton button2, ImageButton button3, ImageButton button4) {
        if (isToggled1) {
            button.setBackgroundColor(Color.parseColor("#469ACF"));
            button2.setBackgroundColor(Color.parseColor("#469ACF"));
            button3.setBackgroundColor(Color.parseColor("#469ACF"));
            button4.setBackgroundColor(Color.parseColor("#469ACF"));
            return false;
        }else {
            button.setBackgroundColor(Color.parseColor("#97a0FF"));
            button2.setBackgroundColor(Color.parseColor("#469ACF"));
            button3.setBackgroundColor(Color.parseColor("#469ACF"));
            button4.setBackgroundColor(Color.parseColor("#469ACF"));
            return true;
        }
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
                if (markComanderDamage(isToggled1,button,button2,button3,button4)) {
                    isToggled2 = isToggled3 = isToggled4 = false;
                    isToggled1 = true;
                }else {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (markComanderDamage(isToggled2,button2,button,button3,button4)) {
                    isToggled1 = isToggled3 = isToggled4 = false;
                    isToggled2 = true;
                }else {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (markComanderDamage(isToggled3,button3,button2,button,button4)) {
                    isToggled2 = isToggled1 = isToggled4 = false;
                    isToggled3 = true;
                }else {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (markComanderDamage(isToggled4,button4,button2,button3,button)) {
                    isToggled2 = isToggled3 = isToggled1 = false;
                    isToggled4 = true;
                }else {
                    isToggled1 = isToggled2 = isToggled3 = isToggled4 = false;
                }
            }
        });
    }

    public void activatePoison() {
        ImageButton button = (ImageButton) findViewById(R.id.Poison);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                poisonBt1.setVisibility(v.VISIBLE);
                poisonBt2.setVisibility(v.VISIBLE);
                poisonBt3.setVisibility(v.VISIBLE);
                poisonBt4.setVisibility(v.VISIBLE);

                int color = ContextCompat.getColor(MainActivity.this, R.color.poisonGreen);

                poisonBt1.setBackgroundColor(color);
                poisonBt2.setBackgroundColor(color);
                poisonBt3.setBackgroundColor(color);
                poisonBt4.setBackgroundColor(color);
            }
        });
    }

    public void newGame() {
        ImageButton button = (ImageButton) findViewById(R.id.newGame);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                p1.resetPlayer((short) 40);
                p2.resetPlayer((short) 40);
                p3.resetPlayer((short) 40);
                p4.resetPlayer((short) 40);


                isToggled1 = false;
                isToggled2 = false;
                isToggled3 = false;
                isToggled4 = false;

                poisonBt1.setActivated(false);
                poisonBt2.setActivated(false);
                poisonBt3.setActivated(false);
                poisonBt4.setActivated(false);

                tv1.setText("40");
                tv2.setText("40");
                tv3.setText("40");
                tv4.setText("40");

                tvCdmg2to1.setText("0");
                tvCdmg3to1.setText("0");
                tvCdmg4to1.setText("0");

                tvCdmg1to2.setText("0");
                tvCdmg3to2.setText("0");
                tvCdmg4to2.setText("0");

                tvCdmg1to3.setText("0");
                tvCdmg2to3.setText("0");
                tvCdmg4to3.setText("0");

                tvCdmg1to4.setText("0");
                tvCdmg2to4.setText("0");
                tvCdmg3to4.setText("0");

                poisonBt1.setVisibility(v.INVISIBLE);
                poisonBt2.setVisibility(v.INVISIBLE);
                poisonBt3.setVisibility(v.INVISIBLE);
                poisonBt4.setVisibility(v.INVISIBLE);

                poisonBt1.setText("0");
                poisonBt2.setText("0");
                poisonBt3.setText("0");
                poisonBt4.setText("0");
            }
        });
    }

    public void rollDice () {
        rollDice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pop.class));
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}