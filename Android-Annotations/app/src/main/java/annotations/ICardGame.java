package annotations;

import annotations.GameInitialized;
import annotations.GameNotInitializedException;
import annotations.TurnBegan;
import annotations.TurnNotStartedException;

/**
 * Created by aravidas on 8/27/17.
 */

public interface ICardGame
{
  void startGame();

  @GameInitialized
  void startTurn()  throws GameNotInitializedException;

  @GameInitialized
  @TurnBegan
  void playTurn() throws GameNotInitializedException, TurnNotStartedException;
}
