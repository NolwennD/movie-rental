package movierental;

import java.util.Collection;
import java.util.function.Function;

public class HTMLRenderer implements Renderer {

  @Override
  public String render(Collection<Rental> rentals, String customerName) {
    AmountRenterPointsAndLines rentalsData = BaseRenderer.extractFromRentals(rentals, mapper());

    return header(customerName) + lines(rentalsData.lines()) + footer(rentalsData.aAndR().amount(), rentalsData.aAndR().renterPoints());
  }

  private Function<Rental, String> mapper() {
    return rental -> line(rental.amount().value(), rental.getMovie().getTitle());
  }

  private String footer(Amount amount, Integer renterPoints) {
    return "<p>Amount owed is <em>" + amount.value() + "</em></p>"
        + "<p>You earned <em>" + renterPoints + "</em> frequent renter points</p>";
  }

  private String lines(String lines) {
    return "<table>" + lines + "</table>";
  }

  private String header(String customerName) {
    return "<h1>Rental Record for <em>" + customerName+ "</em></h1>";
  }

  private String line(double value, String title) {
    return
        "<tr><td>" + title + "</td><td>"+ value+ "</td></tr>"
        ;
  }

}
