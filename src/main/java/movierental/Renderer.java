package movierental;

import java.util.Collection;

public interface Renderer {

  public String render(Collection<Rental> rentals, String customerName);
}
