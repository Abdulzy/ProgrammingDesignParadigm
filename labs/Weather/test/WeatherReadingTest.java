import org.junit.Before;
import org.junit.Test;

import weather.WeatherReading;

import static org.junit.Assert.assertEquals;

/**
 * Weather reading test that test values of a implementation.
 */
public class WeatherReadingTest {
  private WeatherReading val;

  @Before
  public void setUp() throws Exception {
    val = new WeatherReading(10.232, 2.3223, 58.23 ,5.1221);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidDewPoint() {
    val = new WeatherReading(10.232, 23.223, 58.23 ,5.1221);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidWindSpeed() {
    val = new WeatherReading(10.232, 2.3223, -58.23,5.1221);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidTotalRain() {
    val = new WeatherReading(10.232, 2.3223, 58.23 ,-5.1221);
  }

  @Test
  public void getTemperature() {
    assertEquals("temperature passed", 10, val.getTemperature());
  }

  @Test
  public void getDewPoint() {
    assertEquals("dewPoint passed", 2, val.getDewPoint());
  }

  @Test
  public void getWindSpeed() {    assertEquals("windSpeed passed", 58, val.getWindSpeed());  }

  @Test
  public void getTotalRain() {
    assertEquals("totalRain passed", 5, val.getTotalRain());
  }

  @Test
  public void getRelativeHumidity() {
    assertEquals("humidity passed", 60, val.getRelativeHumidity());
  }

  @Test
  public void getHeatIndex() {

    assertEquals("heatIndex passed", 37, val.getHeatIndex());
  }

  @Test
  public void getWindChill() {

    assertEquals("windChill passed", 39, val.getWindChill());
  }

  @Test
  public void testString() {
    assertEquals("toString passed", "Reading: T = 10, D = 2, v = 58, rain = 5", val.toString());
  }
}