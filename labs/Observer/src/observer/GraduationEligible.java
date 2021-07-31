package observer;

import java.util.ArrayList;
import java.util.List;

/** Represents an observer seeking graduation eligibility. */
public class GraduationEligible extends AbstractObserver implements GradeObserver {

  private final List<GradeRecord> records;

  /** The constructor of the class. */
  public GraduationEligible() {
    records = new ArrayList<>();
  }

  @Override
  public void update(GradeRecord record) {
    updating(records, record);
  }

  /**
   * Checks if the name exist in the list of records.
   *
   * @param name the string being checked.
   * @return true or false
   */
  private boolean checkClass(String name) {
    for (GradeRecord currentRecord : records) {
      if (currentRecord.getCourse().replaceAll(" ", "").equals(name)) {
        return currentRecord.getGrade().getGradeValue() >= 3.0;
      }
    }
    return false;
  }

  /**
   * Checks if the observer has taken CS5010 or CS5004.
   *
   * @return true or false
   */
  private boolean checkOne() {
    boolean option1 = checkClass("CS5010");
    boolean option2 = checkClass("CS5004");
    return option1 | option2;
  }

  /**
   * Checks if the observer has taken CS5800.
   *
   * @return true or false
   */
  private boolean checkTwo() {
    return checkClass("CS5800");
  }

  /**
   * Checks if the observer has taken CS5500 or CS5600.
   *
   * @return true or false
   */
  private boolean checkThree() {
    boolean option1 = checkClass("CS5500");
    boolean option2 = checkClass("CS5600");
    return option1 | option2;
  }

  @Override
  public boolean isSatisfied() {
    return checkOne() && checkTwo() && checkThree();
  }
}
