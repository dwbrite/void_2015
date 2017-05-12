package Story;

public class Story {

  Event[] events;
  // Scene scene1;

  public Story() {
    Actor you = new Actor("You");

    Event[] events = {
            new Monologue("..."),
            new Monologue("The universe is silent."),
            new Monologue("..."),
            new Monologue("What's that?"),
            new Monologue("A faint murmur masquerades amongst the silence."),
            new Monologue("It’s you."),
            new Monologue("..."),
            new Monologue("But wait--who *are* you...?"),
            new Monologue("You have no memories."),
            new Monologue("You just...exist."),
            new Monologue("You just...are."),
            new Monologue("You have no beginning nor ending."),
            new Monologue("No past nor future."),
            new Monologue("Just the present."),
            new Monologue("Just now."),
            new Monologue("..."),
            new Dialogue(you, "Wh...what do we do now?"),
            new Monologue("I'm afraid that’s not my decision."),
            new Monologue("It’s up to you."),
            new Decision
    };

    this.events = events;

  }

  public void play() {
    for (int i = 0; i < events.length; i++) {
      events[i].run();
    }
  }
}
