package movierental;

public class Movie {
    private final String title;
    private final MovieType type;


    public Movie(String title, MovieType type) {
      this.title = title;
      this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public MovieType type() {
      return type;
    }
}
