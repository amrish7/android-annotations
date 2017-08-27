package annotations;

/**
 * Created by aravidas on 8/27/17.
 */

public class PokerGame implements ICardGame
{
  public static boolean isInitialized = false;
  public static boolean hasTurnBegun = false;

  @Override
  public void startGame()
  {
    isInitialized = true;
  }


  @Override
  public void startTurn() throws GameNotInitializedException
  {
    hasTurnBegun = true;
  }


  @Override
  public void playTurn() throws GameNotInitializedException, TurnNotStartedException
  {

  }
}
