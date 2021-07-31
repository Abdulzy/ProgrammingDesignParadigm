package document;


import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.Heading;

/**
 * This is an interface for the visitor on textElement This interface
 * offers a chance to visit every kind of concrete textElement in the hierarchy.
 * Some visitors may want this level of granularity, others may not.
 *
 * @param <R> the type of the return parameter for the visit
 */
public interface TextElementVisitor<R> {

  /**
   * Performs the appropriate visit for the basicText.
   *
   * @param e the basicText object
   */
  void visitBasicText(BasicText e);

  /**
   * Performs the appropriate visit for the BoldText.
   *
   * @param e the BoldText object
   */
  void visitBoldText(BoldText e);

  /**
   * Performs the appropriate visit for the Heading.
   *
   * @param e the Heading object
   */
  void visitHeading(Heading e);

  /**
   * Performs the appropriate visit for the HyperText.
   *
   * @param e the HyperText object
   */
  void visitHyperText(HyperText e);

  /**
   * Performs the appropriate visit for the ItalicText.
   *
   * @param e the ItalicText object
   */
  void visitItalicText(ItalicText e);

  /**
   * Performs the appropriate visit for the Paragraph.
   *
   * @param e the Paragraph object
   */
  void visitParagraph(Paragraph e);
}
