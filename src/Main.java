import movies.domain.Movie;
import movies.service.MovieCatalog;
import movies.service.MovieCatalogImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //DataAccess dataAccess = new DataAccessImpl();
        //dataAccess.create("test.txt");
        //System.out.println(dataAccess.exist("test.txt"));
        //dataAccess.write(new Movie("batman"),"test.txt",true);
        //System.out.println(dataAccess.list("test.txt").get(0));
        //dataAccess.delete("test.txt");
        MovieCatalog movieCatalog = new MovieCatalogImpl();
//
//        movieCatalog.startFile("Movies2023.txt");
//        movieCatalog.addMovie("Avengers","Movies2023.txt");
//        movieCatalog.addMovie("Avengers2","Movies2023.txt");
//        movieCatalog.addMovie("Avengers3","Movies2023.txt");
//        movieCatalog.listMovies("Movies2023.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select option:");
        System.out.println("Type number 1 for - start movie catalog");
        System.out.println("Type number 2 for - add movie");
        System.out.println("Type number 3 for - list movies");
        System.out.println("Type number 4 for - find movie");
        System.out.println("Type number 5 for - delete movie");
        System.out.println("Type number 0 for - exit");


        var number = scanner.nextInt();

        switch (number)
        {
            case 0:
                break;

            case 1:
                System.out.println("Please type file name");
                movieCatalog.startFile(scanner.next() + ".txt");
                break;
            case 2:
                System.out.println("Please type file name");
                var fileName = scanner.next() + ".txt";

                System.out.println("Please type movie name");
                var movieName = scanner.next();

                movieCatalog.addMovie(movieName, fileName);
                break;
            case 3:
                System.out.println("Please type file name");
                List<Movie> movies = new ArrayList<>(movieCatalog.listMovies(scanner.next() + ".txt"));

                for (Movie moviesList:movies)
                {
                    System.out.println(moviesList.getName());
                }
                break;
            case 4:
                System.out.println("Please type file name");
                var fileName4 = scanner.next() + ".txt";

                System.out.println("Please type movie name");
                var movieName4 = scanner.next();
                movieCatalog.findMovie(fileName4,movieName4);

                break;
            case 5:
                System.out.println("Please type file name");
                movieCatalog.deleteMovie(scanner.next() + ".txt");
                break;
        }

        //upload git hub

    }
}
