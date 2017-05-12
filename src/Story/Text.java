package Story;

/**
 * Created by juliencherry on 05/11/17.
 */
public class Text implements Event {

  String text;

  public Text(String text) {
    this.text = text;
  }

  @Override
  public void run() {
    // todo: call handler
  }
}
