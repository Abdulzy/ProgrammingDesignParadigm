package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;

/** Counts the number of words that are in a document. */
public class WordCountVisitor implements TextElementVisitor<Integer> {
  private int stringCount;

  /** The constructor of the class. */
  public WordCountVisitor() {
    stringCount = -1;
  }

  @Override
  public void visitBasicText(BasicText e) {
    stringCount = wordCount(e.getText());
  }

  @Override
  public void visitBoldText(BoldText e) {
    stringCount = wordCount(e.getText());
  }

  @Override
  public void visitHeading(Heading e) {
    stringCount = wordCount(e.getText());
  }

  @Override
  public void visitHyperText(HyperText e) {
    stringCount = wordCount(e.getText());
  }

  @Override
  public void visitItalicText(ItalicText e) {
    stringCount = wordCount(e.getText());
  }

  @Override
  public void visitParagraph(Paragraph e) {
    stringCount = wordCount(e.getText());
  }

  /**
   * Counts the number of words in the string.
   *
   * @param sentence the string that would be counted
   * @return the amount of words in the string
   */
  private int wordCount(String sentence) {
    String[] arrayOfString = sentence.split(" ");
    return arrayOfString.length;
  }

  /**
   * Returns the number of words in the document.
   *
   * @return the amount of words in the document
   */
  public int getWordCount() {
    if (stringCount < 0) {
      throw new IllegalStateException("This visitor has not been used yet.");
    }
    return stringCount;
  }
}
