package document;

import document.elements.TextElement;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a document. It contains a list of the elements of the document in the
 * order that they appear in the document. This class is provided as a starting point for the
 * Visitor lab in CS 5010.
 */
public class Document {

  private List<TextElement> content;

  /** Default constructor initializes the fields of the class. */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Add an element to the document. Elements are added in order.
   *
   * @param e the element to add
   */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * Returns the number of words in the document.
   *
   * @return the number of words in the document.
   */
  public int countWords() {
    WordCountVisitor countVisitor = new WordCountVisitor();
    int amountOfWords = 0;
    for (TextElement currentElement : content) {
      currentElement.accept(countVisitor);
      amountOfWords = amountOfWords + countVisitor.getWordCount();
    }
    return amountOfWords;
  }

  /**
   * Takes in one of the "string visitors" as a parameter and returns a string for the respective
   * visitor.
   *
   * @param visitor the string visitor
   * @return the toString() of the respective visitor.
   */
  public String toText(TextElementVisitor<String> visitor) {
    for (TextElement currentElement : content) {
      currentElement.accept(visitor);
    }
    return visitor.toString().trim();
  }
}
