import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.TextElementVisitor;
import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Test for the document class. */
public class DocumentTest {

  BasicText basic;
  BoldText bold;
  ItalicText italic;
  Heading heading;
  Heading heading2;
  Heading heading3;
  HyperText url;
  Paragraph paragraph;
  Document document;

  /** Sets up objects to be used in test functions. */
  @Before
  public void setUp() {
    basic = new BasicText("This is basic");
    bold = new BoldText("This is bold");
    italic = new ItalicText("This is italic");
    heading = new Heading("i am fine ",1);
    heading2 = new Heading("i am good ",2);
    heading3 = new Heading("i am okay ",3);
    url = new HyperText("Google", "www.google.com");
    paragraph = new Paragraph();
    paragraph.add(basic);
    paragraph.add(bold);
    paragraph.add(italic);
    paragraph.add(heading);
    paragraph.add(heading2);
    paragraph.add(heading3);
    paragraph.add(url);
    document = new Document();

  }

  @Test
  public void countWords() {
    document.add(basic);
    document.add(bold);
    assertEquals(6, document.countWords());
    document.add(paragraph);
    assertEquals(28, document.countWords());
    Document document2 = new Document();
    document2.add(basic);
    document2.add(bold);
    document2.add(italic);
    document2.add(heading);
    document2.add(heading2);
    document2.add(heading3);
    document2.add(url);
    assertEquals(19, document2.countWords());
    TextElementVisitor<String> stringVisitor = new BasicStringVisitor();
    assertEquals("This is basic This is bold This is italic i am fine "
        + "i am good i am okay Google", document2.toText(stringVisitor));
  }

  @Test
  public void toText() {
    TextElementVisitor<String> stringVisitor = new BasicStringVisitor();
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();
    document.add(paragraph);
    assertEquals("This is basic This is bold This is italic i am fine  "
        + "i am good  i am okay  Google", document.toText(stringVisitor));
    assertEquals("<p>This is basic\n"
        + "<b>This is bold</b>\n"
        + "<i>This is italic</i>\n"
        + "<h1>i am fine </h1>\n"
        + "<h2>i am good </h2>\n"
        + "<h3>i am okay </h3>\n"
        + "<a href=\"www.google.com\">Google</a>\n"
        + "</p>", document.toText(htmlVisitor));
    assertEquals("This is basic\n"
        + "**This is bold**\n"
        + "*This is italic*\n"
        + "# i am fine \n"
        + "## i am good \n"
        + "### i am okay \n"
        + "[Google](www.google.com)", document.toText(markdownVisitor));
  }

  @Test
  public void emptyText() {
    TextElementVisitor<String> stringVisitor = new BasicStringVisitor();
    TextElementVisitor<String> htmlVisitor = new HtmlStringVisitor();
    TextElementVisitor<String> markdownVisitor = new MarkdownStringVisitor();
    assertEquals("", document.toText(stringVisitor));
    assertEquals("", document.toText(htmlVisitor));
    assertEquals("", document.toText(markdownVisitor));
  }
}