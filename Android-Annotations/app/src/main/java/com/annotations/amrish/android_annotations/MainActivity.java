package com.annotations.amrish.android_annotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import annotations.GameNotInitializedException;
import annotations.ICardGame;
import annotations.PokerGameBuilder;
import annotations.TurnNotStartedException;

public class MainActivity extends AppCompatActivity
{
  Button btnStartGame;
  Button btnStartTurn;
  Button btnDeal;
  ICardGame cardGame;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btnStartGame = (Button) findViewById(R.id.btnStep1);
    btnStartTurn = (Button) findViewById(R.id.btnStep2);
    btnDeal = (Button) findViewById(R.id.btnStep3);
    cardGame = PokerGameBuilder.getPokerGame();

    btnStartGame.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        cardGame.startGame();
      }
    });

    btnStartTurn.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        try
        {
          cardGame.startTurn();
        }
        catch (GameNotInitializedException e)
        {
          Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
      }
    });

    btnDeal.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        try
        {
          cardGame.playTurn();
        }
        catch (GameNotInitializedException e)
        {
          Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch (TurnNotStartedException e)
        {
          Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
      }
    });
  }
}
