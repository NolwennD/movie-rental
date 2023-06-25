package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public AmountAndRenterPoints amountAndRenterPoints() {
      return new AmountAndRenterPoints(amount(), renterPoints());
    }

    public int renterPoints() {
      if ((movie.type() == MovieType.NEW_RELEASE) && daysRented > 1) {
        return 2;
      }
      return 1;
    }

    public Amount amount() {
      return switch(movie.type()) {
        case CHILDRENS -> childrens();
        case NEW_RELEASE -> newRelease();
        case REGULAR -> regular();
      };
    }

    private Amount childrens() {
      return new Amount(1.5).add(possiblePenalty(3));
    }

    private Amount newRelease() {
      return new Amount(daysRented * 3d);
    }

    private Amount regular() {
      return new Amount(2).add(possiblePenalty(2));
    }

    private Amount possiblePenalty(int threshold) {
      if (daysRented > threshold) {
        return new Amount((daysRented - threshold) * 1.5);
      }
      return Amount.ZERO;
    }
}
