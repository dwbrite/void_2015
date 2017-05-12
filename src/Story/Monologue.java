package Story;

import Handlers.TextHandler;

public class Monologue implements Event {
  String text;

  public Monologue(String text) {
    this.text = text;
  }

  @Override
  public void run() {
    TextHandler.display(this.text);
  }
}
