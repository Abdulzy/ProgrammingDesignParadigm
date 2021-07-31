import observer.GradeObserver;
import observer.GradeRecord;
import observer.GradeSubject;
import observer.GradeSubjectImpl;
import observer.Grade;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the GradeSubject class.
 */
public class GradeSubjectImplTest {

  GradeSubject mockSubject;
  GradeObserver mockObserve;
  GradeObserver mockObserveTwo;
  StringBuilder log;

  @Before
  public void setUp() {
    mockSubject = new GradeSubjectImpl();
    log = new StringBuilder();
    mockObserve = new MockObserver(log, "passed");
    mockObserveTwo = new MockObserver(log, "fail");
  }

  @Test
  public void attach() {
    mockSubject.attach(mockObserve);
    mockSubject.attach(mockObserveTwo);
    assertEquals("[passed, fail]", mockSubject.toString());
  }

  @Test
  public void detach() {
    mockSubject.attach(mockObserve);
    mockSubject.attach(mockObserveTwo);
    assertEquals("[passed, fail]", mockSubject.toString());
    mockSubject.detach(mockObserveTwo);
    assertEquals("[passed]", mockSubject.toString());
  }

  @Test
  public void testNotify() {
    GradeRecord score = new GradeRecord("CS5000", Grade.A, 4);
    mockSubject.attach(mockObserve);
    mockSubject.notify(score);
    assertEquals("[passed]", mockSubject.toString());
    assertEquals("GradeRecord[course=CS5000, grade=A, credits=4]", log.toString());
  }
}
