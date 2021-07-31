import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * Testing for code.
 */
public class QuestionTest {

  Question first;
  Question second;
  Question third;
  Question fourth;

  @Before
  public void setUp() {
    first = new TrueFalse("Are you in america?", "true");
    second = new Likert("How well do you think america has handle Covid?");
    third = new MultipleChoice("How many continents are "
            + "there?", "1", "1", "2", "6", "5");
    fourth = new MultipleSelect("How many continents are "
            + "there?", "1 3", "3", "2", "7", "1");
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void constructorTrue() {
    Question one = new TrueFalse("Are you in america?", "true");
    Assert.assertEquals("Are you in america?", one.getText());
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void constructorLikert() {
    Question two = new Likert("How well do you think america has handle Covid?");
    Assert.assertEquals("How well do you think america has handle Covid?", two.getText());
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void constructorMultipleChoice() {
    Question three = new MultipleChoice("How many continents are "
            + "there?", "1", "4", "2", "3", "1");
    Assert.assertEquals("How many continents are there?", three.getText());
  }

  /**
   * Tested getTex and constructor.
   */
  @Test
  public void constructorMultipleSelect() {
    Question four = new MultipleSelect("How many countries are "
            + "there?", "1 2", "4", "2", "3", "1");
    Assert.assertEquals("How many countries are there?", four.getText());
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyQuestionTrue() {
    Question one = new TrueFalse("", "true");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyQuestionLikert() {
    Question one = new Likert("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyQuestionMultipleChoice() {
    Question one = new MultipleChoice("", "1", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyQuestionMultipleSelect() {
    Question one = new MultipleSelect("", "1", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnswerTrue() {
    Question one = new TrueFalse("What is this?", "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnswerMultipleChoice() {
    Question one = new MultipleChoice("What is your name?", "", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnswerMultipleSelect() {
    Question one = new MultipleSelect("What are your names?", "", "2", "1", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void notTrueOrFalse() {
    Question one = new TrueFalse("Is 1 greater than 2?", "yes");
  }

  @Test(expected = IllegalArgumentException.class)
  public void notEnoughMultipleChoice() {
    Question one = new MultipleChoice("What is your name?", "1", "2", "1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void notEnoughMultipleSelect() {
    Question one = new MultipleSelect("What are your names?", "1", "2", "1");
  }

  @Test(expected = IllegalArgumentException.class)
  public void manyMultipleChoice() {
    Question one = new MultipleChoice("What is your name"
            + "?", "1", "1", "2", "3", "4", "5", "6", "7", "8", "29", "10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void manyMultipleSelect() {
    Question one = new MultipleSelect("What is your name"
            + "?", "1", "1", "2", "3", "4", "5", "6", "7", "8", "29", "10");
  }

  @Test(expected = IllegalArgumentException.class)
  public void noAnswerMultipleChoice() {
    Question one = new MultipleChoice("What is your name"
            + "?", "5", "1", "2", "3", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void noAnswerMultipleSelect() {
    Question one = new MultipleSelect("What is your name"
            + "?", "5", "1", "2", "3", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyOptionMultipleChoice() {
    Question one = new MultipleChoice("What is your name"
            + "?", "1", "1", "2", " ", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyOptionMultipleSelect() {
    Question one = new MultipleSelect("What is your name"
            + "?", "1", "1", "2", " ", "4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnsweredTrue() {
    Question one = new TrueFalse("Are you in america?", "true");
    one.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnsweredLikert() {
    Question two = new Likert("How do you rate your experience with college?");
    two.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnsweredMultipleChoice() {
    Question three = new MultipleChoice("How many continents are "
            + "there?", "1", "4", "2", "3", "1");
    three.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyAnsweredMultipleSelect() {
    Question three = new MultipleSelect("How many continents are "
            + "there?", "1 3", "4", "2", "3", "1");
    three.answer("");
  }

  @Test
  public void rightAnswerTrue() {
    Question one = new TrueFalse("Are you in america?", "true");
    Assert.assertEquals("Correct", one.answer("true"));
  }

  @Test
  public void rightAnswerLikert() {
    Question two = new Likert("How do you rate your experience with college?");
    Assert.assertEquals("Correct", two.answer("2"));
  }

  @Test
  public void rightAnswerMultipleChoice() {
    Question three = new MultipleChoice("How many continents are "
            + "there?", "1", "7", "1", "3", "2");
    Assert.assertEquals("Correct", three.answer("1"));
  }

  @Test
  public void rightAnswer2MultipleSelect() {
    Question four = new MultipleSelect("How many continents are "
            + "there?", "1 3", "4", "2", "3", "1");
    Assert.assertEquals("Correct", four.answer("1 3"));
  }

  @Test
  public void wrongAnswerTrue() {
    Question one = new TrueFalse("Are you in america?", "true");
    Assert.assertEquals("Incorrect", one.answer("false"));
  }

  @Test
  public void wrongAnswerLikert() {
    Question two = new Likert("How do you rate your experience with college?");
    Assert.assertEquals("Incorrect", two.answer("6"));
  }

  @Test
  public void wrongAnswerMultipleChoice() {
    Question three = new MultipleChoice("How many continents are "
            + "there?", "1", "7", "5", "3", "1");
    Assert.assertEquals("Incorrect", three.answer("2"));
  }

  @Test
  public void wrongAnswerMultipleSelect() {
    Question four = new MultipleSelect("How many continents are "
            + "there?", "1 3", "4", "2", "3", "1");
    Assert.assertEquals("Incorrect", four.answer("2"));
  }

  @Test
  public void toStringTrue() {
    Assert.assertEquals("Are you in america? true or false.", first.toString());
  }

  @Test
  public void toStringLikert() {
    Assert.assertEquals("How well do you think america has handle Covid? \n"
            + "1 for Strongly Agree,2 for Agree, 3 for Neither "
            + "Agree nor Disagree, 4 for Disagree, 5 for Strongly Disagree.", second.toString());
  }

  @Test
  public void toStringMultipleChoice() {
    Assert.assertEquals("How many continents are there? "
            + "with options [1, 2, 6, 5].", third.toString());
  }

  @Test
  public void toStringMultipleSelect() {
    Assert.assertEquals("How many continents are there?"
            + " with options [3, 2, 7, 1].", fourth.toString());
  }

  @Test
  public void comparingIt() {
    Question fifth = new TrueFalse("B is after A?", "true");
    Assert.assertEquals(-1,first.compareTo(fifth));
  }

  /**
   * Compares every possible scenario.
   */
  @Test
  public void comparing() {
    Question one = new TrueFalse("Are you on earth?", "true");
    Question two = new Likert("How well do you think northeastern has handle Covid?");
    Question three = new MultipleChoice("What number is "
            + "even?", "1", "2", "3", "5", "1");
    Question four = new MultipleSelect("What numbers are "
            + "even?", "1 3", "2", "3", "4", "1");
    List<Question> questionnaire = new ArrayList<>();
    questionnaire.add(second);
    questionnaire.add(third);
    questionnaire.add(first);
    questionnaire.add(fourth);
    questionnaire.add(one);
    questionnaire.add(two);
    questionnaire.add(three);
    questionnaire.add(four);
    Collections.sort(questionnaire);
    System.out.println("comparing");
    System.out.println(questionnaire);
    Assert.assertEquals(8,questionnaire.size());
  }

}