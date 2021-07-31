package observer;

/**
 * Student Grade Observer which listens to updates from the subject.
 */
public interface GradeObserver {
  /**
   * This method is called when there is a change in the student grade subject.
   *
   * @param record the record changed.
   */
  void update(GradeRecord record);

  /**
   * Checks if the concrete class's criteria is satisfied.
   *
   * @return true if criteria is satisfied, false otherwise.
   */
  boolean isSatisfied();
}