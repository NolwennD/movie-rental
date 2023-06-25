package movierental;

public record AmountAndRenterPoints(Amount amount, Integer renterPoints) {

  public static final AmountAndRenterPoints ZERO = new AmountAndRenterPoints(Amount.ZERO, 0);

  public AmountAndRenterPoints add(AmountAndRenterPoints other) {
    return new AmountAndRenterPoints(amount.add(other.amount()), renterPoints + other.renterPoints());
  }

}
