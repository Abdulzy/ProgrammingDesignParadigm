package document.elements;

import document.TextElementVisitor;

/**
 * Representation of italic text.
 */
public class ItalicText extends BasicText {

  /**
   * Creates an instance of italic text.
   * @param text the text
   */
  public ItalicText(String text) {
    super(text);
  }

  @Override
  public <R> void accept(TextElementVisitor<R> visitor) {
    visitor.visitItalicText(this);
  }
}
