package Story;

import Handlers.TextHandler;

public class Dialogue implements Event {

  Actor actor;
  String dialogue;

  public Dialogue(Actor actor, String dialogue) {
    this.actor = actor;
    this.dialogue = dialogue;
  }

  @Override
  public void run() {
    TextHandler.display(this.actor.getName(), this.actor.getColor());
    TextHandler.display(": " + this.dialogue);
  }
}
