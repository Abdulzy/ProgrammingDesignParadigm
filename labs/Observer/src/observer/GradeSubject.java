package observer;

/**
 * Represents the Student grade subject. Offers methods to register, deregister
 * Student grade Observers and add student grades.
 */
public interface GradeSubject {
  /**
   * Registers Student grade observer/listener to receive updates on changes.
   *
   * @param observer {@link GradeObserver observer}.
   */
  void attach(GradeObserver observer);

  /**
   * Removes Student grade observer/listener to stop receiving updates on
   * changes.
   *
   * @param observer {@link GradeObserver observer}.
   */
  void detach(GradeObserver observer);

  /**
   * Adds a new record to Student Grade.
   *
   * @param record record to be updated.
   */
  void notify(GradeRecord record);
}
