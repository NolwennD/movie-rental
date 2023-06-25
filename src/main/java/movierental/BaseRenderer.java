package movierental;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class BaseRenderer {

  private BaseRenderer() {
  }

  public static AmountRenterPointsAndLines extractFromRentals(Collection<Rental> rentals, Function<Rental, String> mapper) {
    return rentals.stream()
        .collect(Collectors.teeing(
            Collectors.reducing(AmountAndRenterPoints.ZERO, Rental::amountAndRenterPoints, AmountAndRenterPoints::add),
            Collectors.reducing("", mapper, String::concat),
            AmountRenterPointsAndLines::new));
  }

}