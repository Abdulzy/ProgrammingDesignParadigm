package weather;

/**
 * WeatherReading shows readings of multiple weather Statistics.
 */
public class WeatherReading {
  private double temperature;
  private double dewPoint;
  private double relativeHumidity;
  private double windSpeed;
  private double totalRain;

  /**
   * Constructs a Weather reading in terms of its air Temperature, dewPoint Temperature,
   * wind Speed, and total Rain.   *
   * @param airTemperature which is temperature
   * @param dewPointTemperature which is dewPoint
   * @param wSpeed which is windSpeed
   * @param tRain which is totalRain
   * @throws IllegalArgumentException if airTemperature is lesser than dewPointTemperature
   * @throws IllegalArgumentException if windSpeed argument is negative
   * @throws IllegalArgumentException if totalRain argument is negative
   */
  public WeatherReading(double airTemperature, double dewPointTemperature,
                        double wSpeed,                        double tRain)
          throws IllegalArgumentException {
    if (airTemperature < dewPointTemperature) {
      throw new IllegalArgumentException("Dew point Temperature cannot be "
              + "greater than air temperature.");
    }
    if (0 > wSpeed) {
      throw new IllegalArgumentException("Wind speed must be a non negative, e.g greater than 0");
    }
    if (0 > tRain) {
      throw new IllegalArgumentException("Total rain must be a non negative, e.g greater than 0");
    }
    temperature = airTemperature;
    dewPoint = dewPointTemperature;
    windSpeed = wSpeed;
    totalRain = tRain;
    relativeHumidity = 100 - (5 * (temperature - dewPoint));
  }

  @Override
  public String toString() {
    return "Reading: T = " + (int)temperature + ", D = " + (int)dewPoint + ", v = "
            + (int)windSpeed + ", rain = " + (int)totalRain;
  }

  public int getTemperature() {
    return (int) temperature;
  }

  public int getDewPoint() {
    return (int) dewPoint;
  }

  public int getWindSpeed() {
    return (int) windSpeed;
  }

  public int getTotalRain() {
    return (int) totalRain;
  }

  public int getRelativeHumidity() {
    return (int) relativeHumidity;
  }

  /**
   * Calculates the heat index which is a measure of how hot it feels when factoring in
   * relative humidity and temperature.
   * @return Heat Index
   */
  public int getHeatIndex() {
    int tempT = (int)Math.pow(temperature, 2);
    int tempR = (int)Math.pow(relativeHumidity, 2);
    double heatIndex = (-8.78469475556) + (1.61139411 * temperature)
            + (2.33854883889 * relativeHumidity)
            + (-0.14611605 * temperature * relativeHumidity) + (-0.012308094 * tempT)
            + (-0.0164248277778 * tempR)
            + (0.002211732 * tempT * relativeHumidity)
            + (0.00072546 * temperature * tempR) + (-0.0000035828 * tempT * tempR);
    return (int)heatIndex;
  }

  /**
   * Calculates the wind chill which is used when the real-feel temperature is lower than
   * the actual temperature.
   * @return wind chill
   */
  public int getWindChill() {
    int fahrenheit = (int)((temperature * 9) / 5) + 32;
    double pow = Math.pow(windSpeed, 0.16);
    double windChill = (35.74 + (0.6215 * fahrenheit) - (35.75 * pow)
            + (0.4275 * fahrenheit * pow));
    return (int)windChill;
  }
}
