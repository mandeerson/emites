package br.com.reips.emites.scrapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ScraperTest {

    @Test
    public void searchAvengersMovies() {
        List<Movie> result = Scraper.search("Avengers");
        assertEquals(200, result.size());
        Movie first = result.get(0);
        assertEquals("A Daughter's Revenge", first.getTitle());

        Movie second = result.get(1);
        assertEquals("A Soldier's Revenge", second.getTitle());
    }

    @Test
    public void searchCubeMovies() {
        List<Movie> result = Scraper.search("Cube");
        assertEquals(200, result.size());
        Movie first = result.get(0);
        assertEquals("A Cube & a Button", first.getTitle());

        Movie second = result.get(1);
        assertEquals("A Cube of Sugar", second.getTitle());
    }

    @Test
    public void notFoundMovies() {
        List<Movie> result = Scraper.search("trunballlt");
        assertEquals(1, result.size());

        Movie movie = result.get(0);
        assertEquals("Not found", movie.getTitle());
    }

}
