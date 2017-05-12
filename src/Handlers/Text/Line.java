package Handlers.Text;

import java.util.ArrayList;

// represents a line of text
public class Line {
  ArrayList<FormattedString> fStringsInLine;

  public Line(FormattedString... formattedStrings) {
    fStringsInLine = new ArrayList<FormattedString>();
    addText(formattedStrings);
  }

  public void addText(FormattedString... formattedStrings) {
    for (int i = 0; i < formattedStrings.length; i++) {
      fStringsInLine.add(formattedStrings[i]);
    }
  }


  public void set(FormattedString formattedString) {
    fStringsInLine.clear();
    fStringsInLine.add(formattedString);
  }
}
