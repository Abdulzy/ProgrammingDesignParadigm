package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;

/** Generates a simple string representation of the document. */
public class BasicStringVisitor implements TextElementVisitor<String> {
  private String stringCount;

  /** The constructor of the class. */
  public BasicStringVisitor() {
    stringCount = "";
  }

  @Override
  public void visitBasicText(BasicText basicText) {
    stringCount = stringCount + basicText.getText().trim() + " ";
  }

  @Override
  public void visitBoldText(BoldText boldText) {
    stringCount = stringCount + boldText.getText().trim() + " ";
  }

  @Override
  public void visitHeading(Heading heading) {
    stringCount = stringCount + heading.getText().trim() + " ";
  }

  @Override
  public void visitHyperText(HyperText hyperText) {
    stringCount = stringCount + hyperText.getText().trim() + " ";
  }

  @Override
  public void visitItalicText(ItalicText italicText) {
    stringCount = stringCount + italicText.getText().trim() + " ";
  }

  @Override
  public void visitParagraph(Paragraph paragraph) {
    stringCount = stringCount + paragraph.getText().trim() + " ";
  }

  @Override
  public String toString() {
    return stringCount;
  }
}
