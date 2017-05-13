package Story;

import Handlers.Text.FormattedString;
import Handlers.Text.TextHandler;

public class Monologue implements Event {
  String text;

  public Monologue(String text) {
    this.text = text;
  }

  @Override
  public void run() {
    TextHandler.addText(new FormattedString("\n" + this.text));
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
