package movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class CustomerTest {

    @Test
     void shloudRenderForCLI() {
        Customer customer = customer();

        String expected =
          """
            Rental Record for Bob
            \tJaws\t2.0
            \tGolden Eye\t3.5
            \tShort New\t3.0
            \tLong New\t6.0
            \tBambi\t1.5
            \tToy Story\t3.0
            Amount owed is 19.0
            You earned 7 frequent renter points\
            """;

        Assertions.assertEquals(expected, customer.statement(new CLIRenderer()));
    }

    @Test
    void shloudRenderForHTML() {
      Customer customer = customer();

      String expected =
        """
        <h1>Rental Record for <em>Bob</em></h1>\
        <table>\
        <tr><td>Jaws</td><td>2.0</td></tr>\
        <tr><td>Golden Eye</td><td>3.5</td></tr>\
        <tr><td>Short New</td><td>3.0</td></tr>\
        <tr><td>Long New</td><td>6.0</td></tr>\
        <tr><td>Bambi</td><td>1.5</td></tr>\
        <tr><td>Toy Story</td><td>3.0</td></tr>\
        </table>\
        <p>Amount owed is <em>19.0</em></p>\
        <p>You earned <em>7</em> frequent renter points</p>\
        """;

      Assertions.assertEquals(expected, customer.statement(new HTMLRenderer()));
    }

    private Customer customer() {
      return new Customer("Bob")
      .addRental(new Rental(new Movie("Jaws", MovieType.REGULAR), 2))
      .addRental(new Rental(new Movie("Golden Eye", MovieType.REGULAR), 3))
      .addRental(new Rental(new Movie("Short New", MovieType.NEW_RELEASE), 1))
      .addRental(new Rental(new Movie("Long New", MovieType.NEW_RELEASE), 2))
      .addRental(new Rental(new Movie("Bambi", MovieType.CHILDRENS), 3))
      .addRental(new Rental(new Movie("Toy Story", MovieType.CHILDRENS), 4));
    }
}