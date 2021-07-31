package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;

import java.util.List;

/** Generates an HTML version of the document. */
public class HtmlStringVisitor implements TextElementVisitor<String> {

  private StringBuilder stringCount;

  /** The constructor of the class. */
  public HtmlStringVisitor() {
    stringCount = new StringBuilder();
    stringCount.append("");
  }

  @Override
  public void visitBasicText(BasicText e) {
    stringCount.append(e.getText()).append("\n");
  }

  @Override
  public void visitBoldText(BoldText e) {
    stringCount.append("<b>").append(e.getText()).append("</b>").append("\n");
  }

  @Override
  public void visitHeading(Heading e) {
    stringCount
        .append("<h")
        .append(e.getLevel())
        .append(">")
        .append(e.getText())
        .append("</h")
        .append(e.getLevel())
        .append(">")
        .append("\n");
  }

  @Override
  public void visitHyperText(HyperText e) {
    stringCount
        .append("<a href=\"")
        .append(e.getUrl())
        .append("\">")
        .append(e.getText())
        .append("</a>")
        .append("\n");
  }

  @Override
  public void visitItalicText(ItalicText e) {
    stringCount.append("<i>").append(e.getText()).append("</i>").append("\n");
  }

  @Override
  public void visitParagraph(Paragraph e) {
    TextElementVisitor<String> paragraph = new HtmlStringVisitor();
    List<BasicText> content = e.getContent();
    for (BasicText text : content) {
      text.accept(paragraph);
    }
    stringCount.append("<p>").append(paragraph.toString()).append("</p>").append("\n");
  }

  @Override
  public String toString() {
    return stringCount.toString();
  }
}
