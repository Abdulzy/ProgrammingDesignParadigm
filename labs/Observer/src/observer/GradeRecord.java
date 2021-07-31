package observer;

import java.util.Objects;

/**
 * Represents a record of grade. It comprises of course name, grade and hours.
 */
public class GradeRecord {
  private final String course;
  private final Grade grade;
  private final int credits;

  /**
   * Instantiates a course record.
   *
   * @param course  course name.
   * @param grade   grade achieved.
   * @param credits hours of the course.
   * @throws IllegalArgumentException if args are invalid.
   */
  public GradeRecord(String course, Grade grade, int credits) throws IllegalArgumentException {
    if (course == null || course.equals("") || credits == 0 || grade == null) {
      throw new IllegalArgumentException("Invalid args for grade record.");
    }
    this.course = course;
    this.grade = grade;
    this.credits = credits;
  }

  /**
   * Gets the course name.
   *
   * @return course name.
   */
  public String getCourse() {
    return course;
  }

  /**
   * Gets the grade achieved for the course.
   *
   * @return the grade.
   */
  public Grade getGrade() {
    return grade;
  }

  /**
   * Get the number of credits earned.
   * 
   * @return the number of credits
   */
  public int getCredits() {
    return credits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GradeRecord that = (GradeRecord) o;
    return getCredits() == that.getCredits() && getCourse() == that.getCourse()
        && getGrade() == that.getGrade();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCourse(), getGrade(), getCredits());
  }

  @Override
  public String toString() {
    return "GradeRecord[" + "course=" + course + ", grade=" + grade + ", credits=" + credits + ']';
  }
}
