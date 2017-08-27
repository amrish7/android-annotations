package annotations;

/**
 * Created by aravidas on 8/27/17.
 */

public class PokerGameBuilder
{
  public static ICardGame getPokerGame() {
    return (ICardGame)PokerProxy.newInstance(new PokerGame(), new Class[] { ICardGame.class });
  }
}
