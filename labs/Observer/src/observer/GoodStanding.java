package observer;

import java.util.ArrayList;
import java.util.List;

/** Represents an observer seeking a good standing. */
public class GoodStanding extends AbstractObserver implements GradeObserver {

  private final List<GradeRecord> records;

  /** The constructor of the class. */
  public GoodStanding() {
    records = new ArrayList<>();
  }

  @Override
  public void update(GradeRecord record) {
    updating(records, record);
  }

  @Override
  public boolean isSatisfied() {
    return getGPA(records) > 3.0;
  }
}
