package movies.data;

import movies.domain.Movie;
import movies.exceptions.DataAccessEx;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DataAccessImpl implements DataAccess
{
    public static String pathFile = "./data/";
    @Override
    public boolean exist(String fileName) throws DataAccessEx
    {
        try
        {
            File file = new File(pathFile + fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.read();
            bufferedReader.close();
            return true;
        } catch (IOException e)
        {
            throw new DataAccessEx(e+"file not found");
        }
    }

    @Override
    public List<Movie> list(String fileName) throws DataAccessEx
    {
        List <Movie>movieList = new ArrayList<>();
        if (exist(fileName))
        {
            try
            {
                File file = new File(pathFile + fileName);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String movieName;
                while((movieName =bufferedReader.readLine()) != null)
                {
                    movieList.add(new Movie(movieName));
                }

            } catch (IOException e)
            {
                throw new DataAccessEx(e+"read file error");
            }
        }
        else
        {
            throw new DataAccessEx("file not found");
        }
        return movieList;
    }

    @Override
    public void write(Movie movie, String fileName, boolean attatch) throws DataAccessEx
    {
        if (exist(fileName))
        {
            File file = new File(pathFile + fileName);
            try
            {
                PrintWriter printWriter = new PrintWriter(new FileWriter(file, attatch));
                printWriter.println(movie.getName());
                printWriter.close();
            } catch (IOException e)
            {
                throw new DataAccessEx(e+"write file error");
            }
        }
        else
        {
            throw new DataAccessEx("file not found");
        }
    }

    @Override
    public String find(String fileName, String movieName) throws DataAccessEx
    {
        try
        {
            for (Movie movie:list(fileName))
            {
                if (movie.equals(movieName))
                {
                    return movie.getName();
                }
            }
        } catch (DataAccessEx e)
        {
            throw new DataAccessEx("file not found");
        }
        return null;
    }

    @Override
    public void create(String fileName) throws DataAccessEx
    {

        // Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = Arrays.asList();

        File newFile = new File(pathFile + fileName);
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(newFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            Writer writer = new BufferedWriter(outputStreamWriter);
        } catch (FileNotFoundException e)
        {
            throw new DataAccessEx(e+"create file error");
        }
    }

    @Override
    public void delete(String fileName) throws DataAccessEx {
        if (exist(fileName))
        {
            File file = new File(pathFile+ fileName);
            file.delete();
        }
    }
}
