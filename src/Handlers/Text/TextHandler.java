package Handlers.Text;

import java.util.ArrayList;

import Main.VoidMain;
import javafx.scene.paint.Color;

public class TextHandler {
  private static ArrayList<FormattedString> allText = new ArrayList<>();
  private static Line[] line = new Line[8];

  public static void init() {
    for (int i = 0; i < 8; i++) {
      line[i] = new Line();
    }
  }

  public static void addText(FormattedString fstr) {
    allText.add(fstr);
    processAllText();
  }

  private static void processAllText() {
    //Iterate through all FormattedStrings
    for (int i = 0; i < allText.size(); i++) {
      //Split lines in the current FormattedString
      FormattedString[] linesInTextItem = allText.get(i).split("\n");

      //Adds each new line to the Line[]
      if (linesInTextItem.length == 1) {
        if (line[0] != null) {
          line[0].addText(allText.get(0));
        } else {
          line[0].set(allText.get(0));
        }
      } else {
        for (int j = 0; j < linesInTextItem.length; j++) {
          for (int k = line.length - 1; k > 1; k--) {
            System.out.println(k);
            line[k] = line[k - 1];
          }
          line[0].set(linesInTextItem[j]);
        }
      }
    }

    //Delete from "all FormattedStrings" where they're past the eight line from the bottom.
    String allTextAsStr = "";
    for (int i = 0; i < allText.size(); i++) {
      allTextAsStr += allText.get(i).toString();
    }
    int numItems = allTextAsStr.split("\n").length;
    for (int i = 0; i < numItems - 8; i++) {
      allText.remove(0);
    }
  }
}