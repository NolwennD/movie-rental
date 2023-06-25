package movierental;

public record Amount(double value) {

  public static final Amount ZERO = new Amount(0);

  public Amount add(Amount other) {
    return new Amount(value + other.value());
  }

}
