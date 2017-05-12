package Story;

import Handlers.TextHandler;

public class Monologue implements Event {
  String text;

  public Monologue(String text) {
    this.text = text;
  }

  @Override
  public void run() {
    TextHandler.addText(this.text);
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
