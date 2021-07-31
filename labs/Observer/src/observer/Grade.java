package observer;

/**
 * Denotes the grade and the numerical value associated with it.
 */
public enum Grade {

  /** The possible grades. */
  A(4.000), //
  A_MINUS(3.667), //
  B_PLUS(3.333), //
  B(3.000), //
  B_MINUS(2.667), //
  C_PLUS(2.333), //
  C(2.000), //
  C_MINUS(1.667), D_PLUS(1.333), //
  D(1.000), //
  D_MINUS(0.667), //
  F(0.000);

  /** The value associated with this Grade used for calculating GPA. */
  private double gradeValue;

  /**
   * Constructor for the Grade. The constructor is private since this is an enum
   * and we do not want other parties to be able to make additional instances of
   * the Grade enum.
   * 
   * @param gradeValue the value associated with this grade for calculating GPA
   */
  private Grade(double gradeValue) {
    this.gradeValue = gradeValue;
  }

  /**
   * Gets the grade value.
   *
   * @return grade value.
   */
  public double getGradeValue() {
    return gradeValue;
  }
}
