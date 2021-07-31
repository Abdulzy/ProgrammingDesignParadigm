import observer.GradeObserver;
import observer.GradeRecord;

/** Mock of the GradeObserver class. */
public class MockObserver implements GradeObserver {

  private final StringBuilder log;
  private final String details;

  /**
   * constructor of the mockObserver.
   *
   * @param log logging the process
   * @param details an explanation
   */
  public MockObserver(StringBuilder log, String details) {
    this.log = log;
    this.details = details;
  }

  @Override
  public void update(GradeRecord record) {
    log.append(record.toString());
  }

  @Override
  public boolean isSatisfied() {
    return false;
  }

  @Override
  public String toString() {
    return details;
  }
}
