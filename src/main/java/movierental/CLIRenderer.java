package movierental;

import java.util.Collection;
import java.util.function.Function;

public class CLIRenderer implements Renderer {

  @Override
  public String render(Collection<Rental> rentals, String customerName) {
    AmountRenterPointsAndLines rentalsData = BaseRenderer.extractFromRentals(rentals, mapper());

      return header(customerName) + rentalsData.lines() + footer(rentalsData.aAndR().amount().value(), rentalsData.aAndR().renterPoints());
  }

  private Function<Rental, String> mapper() {
    return r -> line(r.amount().value(), r.getMovie().getTitle());
  }

  private String footer(double totalAmount, int frequentRenterPoints) {
    return footerAmount(totalAmount) + footerRenterPoints(frequentRenterPoints);
  }

  private String footerRenterPoints(int frequentRenterPoints) {
    return "You earned " + frequentRenterPoints + " frequent renter points";
  }

  private String footerAmount(double amount) {
    return "Amount owed is " + amount + "\n";
  }

  private String line(double amount, String movieTitle) {
    return "\t" + movieTitle + "\t" + amount + "\n";
  }

  private String header(String customerName) {
    return "Rental Record for " + customerName + "\n";
  }

}
