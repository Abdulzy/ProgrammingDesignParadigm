import observer.GradeObserver;
import observer.GradeRecord;
import observer.GradeSubject;
import observer.GradeSubjectImpl;
import observer.Grade;
import observer.GraduationEligible;
import observer.CoopEligible;
import observer.GoodStanding;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the GradeObserver Class.
 */
public class GradeObserverTest {

  GradeSubject professor;
  GradeObserver student;
  GradeRecord coreOne;
  GradeRecord coreTwo;
  GradeRecord coreThree;
  GradeRecord coreFour;
  GradeRecord coreOneAlign;
  GradeRecord extraClass;
  GradeRecord failCoreOne;
  GradeRecord failCoreTwo;
  GradeRecord failCoreThree;
  GradeRecord failCoreFour;
  GradeRecord failCoreOneAlign;
  GradeRecord failExtraClass;

  @Before
  public void setUp() {
    professor = new GradeSubjectImpl();
    coreOne = new GradeRecord("CS5010", Grade.A, 4);
    coreTwo = new GradeRecord("CS5800", Grade.A, 4);
    coreThree = new GradeRecord("CS5500", Grade.A, 4);
    coreFour = new GradeRecord("CS5600", Grade.A, 4);
    coreOneAlign = new GradeRecord("CS5004 ", Grade.A, 4);
    extraClass = new GradeRecord("CS5050", Grade.A, 4);
    failCoreOne = new GradeRecord("CS5010", Grade.C, 4);
    failCoreTwo = new GradeRecord("CS5800", Grade.C, 4);
    failCoreThree = new GradeRecord("CS5500", Grade.C, 4);
    failCoreFour = new GradeRecord("CS5600", Grade.C, 4);
    failCoreOneAlign = new GradeRecord("CS5004 ", Grade.C, 4);
    failExtraClass = new GradeRecord("CS5050", Grade.C, 4);
  }

  // Testing true isSatisfied for GoodStanding.
  @Test
  public void goodStandingTest() {
    student = new GoodStanding();
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing false isSatisfied for GoodStanding.
  @Test
  public void goodStandingTestFail() {
    student = new GoodStanding();
    student.update(coreOne);
    student.update(failCoreTwo);
    student.update(failCoreThree);
    assertEquals(false, student.isSatisfied());
  }

  // Testing duplicate.
  @Test
  public void duplicateClassGoodStanding() {
    student = new GoodStanding();
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing same class but better grade.
  @Test
  public void sameClassBetterGradeGoodStanding() {
    student = new GoodStanding();
    student.update(failCoreOne);
    assertEquals(false, student.isSatisfied());
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing same class but worse grade.
  @Test
  public void sameClassWorseGradeGoodStanding() {
    student = new GoodStanding();
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
    student.update(failCoreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing true isSatisfied for coopEligible.
  @Test
  public void CoopEligibleTest() {
    student = new CoopEligible();
    student.update(coreOne);
    student.update(extraClass);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
  }

  // Testing coopEligible but bad GPA.
  @Test
  public void CoopEligibleTestBadGPA() {
    student = new CoopEligible();
    student.update(coreOne);
    student.update(failCoreTwo);
    student.update(failCoreThree);
    student.update(failCoreFour);
    student.update(coreOneAlign);
    assertEquals(false, student.isSatisfied());
  }

  // Testing coopEligible but not enough credits.
  @Test
  public void CoopEligibleTestBadCredits() {
    coreOne = new GradeRecord("CS5010", Grade.A, 3);
    coreTwo = new GradeRecord("CS5800", Grade.A, 3);
    coreThree = new GradeRecord("CS5500", Grade.A, 3);
    coreFour = new GradeRecord("CS5600", Grade.A, 3);
    student = new CoopEligible();
    student.update(coreOne);
    student.update(coreTwo);
    student.update(coreThree);
    student.update(coreFour);
    assertEquals(false, student.isSatisfied());
  }

  // Testing duplicate.
  @Test
  public void duplicateClassCoopEligible() {
    student = new CoopEligible();
    student.update(coreOne);
    student.update(extraClass);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing same class but better grade.
  @Test
  public void sameClassBetterGradeCoopEligible() {
    student = new CoopEligible();
    student.update(failCoreOne);
    student.update(extraClass);
    student.update(failCoreThree);
    student.update(coreFour);
    student.update(failCoreTwo);
    assertEquals(false, student.isSatisfied());
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing same class but worse grade.
  @Test
  public void sameClassWorseGradeCoopEligible() {
    student = new CoopEligible();
    student.update(coreOne);
    student.update(extraClass);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
    student.update(failCoreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing true isSatisfied for GraduationEligible.
  @Test
  public void GraduationEligibleTest() {
    student = new GraduationEligible();
    student.update(coreOne);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
  }

  // failed the first core class.
  @Test
  public void GraduationEligibleTestFailOne() {
    student = new GraduationEligible();
    student.update(failCoreOne);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(false, student.isSatisfied());
  }

  // failed the third core class but passed the substitute.
  @Test
  public void GraduationEligibleTestFailTwo() {
    student = new GraduationEligible();
    student.update(coreOne);
    student.update(coreTwo);
    student.update(failCoreThree);
    student.update(coreFour);
    assertEquals(true, student.isSatisfied());
  }

  // failed the third options.
  @Test
  public void GraduationEligibleTestFailOptions() {
    student = new GraduationEligible();
    student.update(coreOne);
    student.update(coreTwo);
    student.update(failCoreThree);
    student.update(failCoreFour);
    assertEquals(false, student.isSatisfied());
  }

  // Testing duplicate.
  @Test
  public void duplicateClassGraduationEligible() {
    student = new GraduationEligible();
    student.update(coreOne);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
    student.update(coreOne);
    assertEquals(true, student.isSatisfied());
  }

  // Testing same class but better grade.
  @Test
  public void sameClassBetterGradeGraduationEligible() {
    student = new GraduationEligible();
    student.update(coreOne);
    student.update(failCoreTwo);
    student.update(coreThree);
    assertEquals(false, student.isSatisfied());
    student.update(coreTwo);
    assertEquals(true, student.isSatisfied());
  }

  // Testing same class but worse grade.
  @Test
  public void sameClassWorseGradeGraduationEligible() {
    student = new GraduationEligible();
    student.update(coreOne);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
    student.update(failCoreTwo);
    assertEquals(true, student.isSatisfied());
  }

  // Testing AlignGraduationEligible.
  @Test
  public void AlignGraduationEligibleTest() {
    student = new GraduationEligible();
    student.update(coreOneAlign);
    student.update(coreTwo);
    student.update(coreThree);
    assertEquals(true, student.isSatisfied());
  }

  // Testing AlignGraduationEligible.
  @Test
  public void AlignGraduationEligibleTrue() {
    student = new GraduationEligible();
    student.update(coreOneAlign);
    student.update(coreTwo);
    student.update(coreThree);
    student.update(failCoreFour);
    assertEquals(true, student.isSatisfied());
  }
}
