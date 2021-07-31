package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;

import java.util.List;

/** Generates an Markdown version of the document. */
public class MarkdownStringVisitor implements TextElementVisitor<String> {

  private final StringBuilder stringCount;

  /** The constructor of the class. */
  public MarkdownStringVisitor() {
    stringCount = new StringBuilder();
    stringCount.append("");
  }

  @Override
  public void visitBasicText(BasicText e) {
    stringCount.append(e.getText()).append("\n");
  }

  @Override
  public void visitBoldText(BoldText e) {
    stringCount.append("**").append(e.getText()).append("**").append("\n");
  }

  @Override
  public void visitHeading(Heading e) {
    stringCount.append("#".repeat(Math.max(0, e.getLevel())));
    stringCount.append(" ").append(e.getText()).append("\n");
  }

  @Override
  public void visitHyperText(HyperText e) {
    stringCount
        .append("[")
        .append(e.getText())
        .append("]")
        .append("(")
        .append(e.getUrl())
        .append(")")
        .append("\n");
  }

  @Override
  public void visitItalicText(ItalicText e) {
    stringCount.append("*").append(e.getText()).append("*").append("\n");
  }

  @Override
  public void visitParagraph(Paragraph e) {
    TextElementVisitor<String> paragraph = new MarkdownStringVisitor();
    List<BasicText> content = e.getContent();
    for (BasicText text : content) {
      text.accept(paragraph);
    }
    stringCount.append("\n").append(paragraph.toString()).append("\n");
  }

  @Override
  public String toString() {
    return stringCount.toString();
  }
}
