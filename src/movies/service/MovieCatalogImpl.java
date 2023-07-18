package movies.service;

import movies.data.DataAccess;
import movies.data.DataAccessImpl;
import movies.domain.Movie;
import movies.exceptions.DataAccessEx;

import java.util.List;

public class MovieCatalogImpl implements MovieCatalog
{
    DataAccess dataAccess = new DataAccessImpl();
    @Override
    public void addMovie(String movieName, String fileName)
    {
        try
        {
            if (dataAccess.exist(fileName))
            {
                try
                {
                    dataAccess.write(new Movie(movieName), fileName, true);
                } catch (DataAccessEx e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else
                dataAccess.write(new Movie(movieName), fileName, false);
        } catch (DataAccessEx e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Movie> listMovies(String fileName)
    {
        try
        {
            return dataAccess.list(fileName);
        } catch (DataAccessEx e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findMovie(String fileName, String find)
    {

    }

    @Override
    public void startFile(String fileName)
    {
        try
        {
            dataAccess.create(fileName);
        } catch (DataAccessEx e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteMovie(String fileName)
    {
        try
        {
            dataAccess.delete(fileName);
        } catch (DataAccessEx e)
        {
            System.out.println(e.getMessage());
        }
    }
}
