package observer;

import java.util.ArrayList;
import java.util.List;

/** Represents an observer seeking coop eligibility. */
public class CoopEligible extends AbstractObserver implements GradeObserver {
  private final List<GradeRecord> records;

  /** The constructor of the class. */
  public CoopEligible() {
    records = new ArrayList<>();
  }

  @Override
  public void update(GradeRecord record) {
    updating(records, record);
  }

  @Override
  public boolean isSatisfied() {
    return (getGPA(records) >= 3.0 && getCredits(records) >= 16);
  }
}
