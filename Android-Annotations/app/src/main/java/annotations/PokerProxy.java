package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import annotations.GameInitialized;
import annotations.GameNotInitializedException;
import annotations.TurnBegan;
import annotations.TurnNotStartedException;

public class PokerProxy implements InvocationHandler {
  private Object obj;

  public PokerProxy(Object obj) {
    this.obj = obj;
  }

  static public Object newInstance(Object obj, Class[] interfaces) {
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                                  interfaces, new PokerProxy(obj));
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Annotation[] annotations = method.getAnnotations();
    for (Annotation ann : annotations) {
      if (ann.annotationType().equals(GameInitialized.class) && !PokerGame.isInitialized) {
        throw new GameNotInitializedException("Game not initialized");
      }

      if (ann.annotationType().equals(TurnBegan.class) && !PokerGame.hasTurnBegun) {
        throw new TurnNotStartedException("Turn not started");
      }
    }
    return method.invoke(obj, args);
  }
}
