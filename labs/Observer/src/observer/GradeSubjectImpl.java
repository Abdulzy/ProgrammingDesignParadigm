package observer;

import java.util.ArrayList;

/** Represents the subject of an observer pattern. */
public class GradeSubjectImpl implements GradeSubject {
  private final ArrayList<GradeObserver> observers;

  public GradeSubjectImpl() {
    observers = new ArrayList<>();
  }

  @Override
  public void attach(GradeObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException("no null allowed");
    }
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void detach(GradeObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException("no null allowed");
    }
    int index = observers.indexOf(observer);
    if (index >= 0) {
      observers.remove(index);
    }
  }

  @Override
  public void notify(GradeRecord record) {
    if (record == null) {
      throw new IllegalArgumentException("no null allowed");
    }
    for (GradeObserver observer : observers) {
      observer.update(record);
    }
  }

  @Override
  public String toString() {
    return observers.toString();
  }
}
