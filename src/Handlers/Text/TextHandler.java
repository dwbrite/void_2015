package Handlers.Text;

import java.util.ArrayList;

import Main.VoidMain;
import javafx.scene.paint.Color;

public class TextHandler {
  private static ArrayList<FormattedString> allText;
  private static Line[] line = new Line[8];

  public static void addText(FormattedString fstr) {

  }

  private static void processAllText() {
    for (int i = 0; i < allText.size(); i++) {
      FormattedString[] linesInTextItem = allText.get(i).split("\n");
      if (linesInTextItem.length == 1) {
        if (line[0] != null) {
          line[0].addText(allText.get(0));
        } else {
          line[0].set(allText.get(0));
        }
      } else {
        for (int j = 0; j < linesInTextItem.length; j++) {
          for (int k = line.length - 1; k > 1; k++) {
            line[k] = line[k - 1];
          }
          line[0].set(linesInTextItem[j]);
        }
      }
    }
  }
}