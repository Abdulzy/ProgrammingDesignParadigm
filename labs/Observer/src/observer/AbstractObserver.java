package observer;

import java.util.List;

/** Abstract class to help with code duplication. */
public abstract class AbstractObserver {

  /**
   * To update the observer records.
   *
   * @param records the records to be updated.
   * @param record the record that is being added.
   * @throws IllegalArgumentException if the GradeRecord is null.
   */
  protected void updating(List<GradeRecord> records, GradeRecord record) {
    if (record == null) {
      throw new IllegalArgumentException("no null allowed");
    }
    if (!checkDupe(records, record)) {
      if (checkRetake(records, record) >= 0) {
        solveRetake(records, record, checkRetake(records, record));
      } else if (checkRetake(records, record) == -2) {
        records.add(record);
      }
    }
  }

  /**
   * Gets the cumulative GPA from the records.
   *
   * @param records the records that hold the GPA.
   * @return the cumulative GPA.
   */
  protected double getGPA(List<GradeRecord> records) {
    double gpa = 0;
    for (GradeRecord currentRecord : records) {
      gpa = gpa + (currentRecord.getGrade().getGradeValue() * currentRecord.getCredits());
    }
    return gpa / getCredits(records);
  }

  /**
   * Gets the cumulative credits from the records.
   *
   * @param records the records that hold the credits.
   * @return the total credits.
   */
  protected double getCredits(List<GradeRecord> records) {
    double credits = 0;
    for (GradeRecord currentRecord : records) {
      credits = credits + currentRecord.getCredits();
    }
    return credits;
  }

  /**
   * Check if an object already exist in the records.
   *
   * @param records all the record.
   * @param record the record being checked.
   * @return if its true or false.
   */
  protected boolean checkDupe(List<GradeRecord> records, GradeRecord record) {
    for (GradeRecord currentRecord : records) {
      if (record == currentRecord) {
        return true;
      }
    }
    return false;
  }

  /**
   * Check if an object already exist in the records.
   *
   * @param records all the record.
   * @param record the record being checked.
   * @return an int depending on the scenario.
   */
  protected int checkRetake(List<GradeRecord> records, GradeRecord record) {
    int index = 0;
    for (GradeRecord currentRecord : records) {
      if (record
          .getCourse()
          .replaceAll(" ", "")
          .equalsIgnoreCase(currentRecord.getCourse().replaceAll(" ", ""))) {
        if (currentRecord.getGrade().getGradeValue() < record.getGrade().getGradeValue()) {
          return index;
        } else {
          return -1;
        }
      }
      index++;
    }
    return -2;
  }

  /**
   * Check if an object already exist in the records.
   *
   * @param records all the record.
   * @param record the record being checked.
   * @param index the index location of the record being removed
   */
  protected void solveRetake(List<GradeRecord> records, GradeRecord record, int index) {
    records.remove(index);
    records.add(record);
  }
}
