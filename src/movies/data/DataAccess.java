package movies.data;

import movies.domain.Movie;
import movies.exceptions.DataAccessEx;

import java.util.List;

public interface DataAccess
{
    boolean exist(String fileName) throws DataAccessEx;

    List<Movie> list(String name) throws DataAccessEx;

    void write(Movie movie, String fileName, boolean attatch) throws DataAccessEx;

    String find(String fileName, String movieName) throws DataAccessEx;

    void create(String fileName) throws DataAccessEx;

    void delete(String fileName) throws DataAccessEx;
}
