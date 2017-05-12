package Story;

import java.util.ArrayList;

/**
 * Created by juliencherry on 05/11/17.
 */
public class Story {

  Event[] events;
  Scene scene1;

  public Story() {
  }

  public void play() {
    scene1.play();
  }
}
