package Story;

import javafx.scene.paint.Color;

public class Actor {

  private String name;

  public Actor(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public Color getColor() {
    return Color.MAGENTA;
  }
}
