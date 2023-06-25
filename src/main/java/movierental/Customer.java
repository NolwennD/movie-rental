package movierental;

import java.util.List;
import java.util.stream.Stream;

public class Customer {

    private final String name;
    private final List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = List.of();
    }

    private Customer(String name, List<Rental> rentals) {
      this.name = name;
      this.rentals = rentals;
    }

    public Customer addRental(Rental arg) {
      return new Customer(name, Stream.concat(rentals.stream(), Stream.of(arg)).toList());
    }

    public String getName() {
        return name;
    }

    public String statement(Renderer renderer) {
      return renderer.render(rentals, getName());
    }
}
