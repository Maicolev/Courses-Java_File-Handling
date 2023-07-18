package movies.service;

import movies.domain.Movie;

import java.util.List;

public interface MovieCatalog
{
    void addMovie(String movieName, String fileName);

    List<Movie> listMovies(String fileName);

    void findMovie(String fileName, String find);

    void startFile(String fileName);

    void deleteMovie(String fileName);
}
