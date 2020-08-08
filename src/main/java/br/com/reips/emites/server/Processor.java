package br.com.reips.emites.server;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.constants.Variables;
import br.com.reips.emites.scrapper.Movie;
import br.com.reips.emites.scrapper.Scraper;

public class Processor implements Runnable {
    public static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    private IoSession session;
    private String query;

    public Processor(IoSession session, String query) {
        this.session = session;
        this.query = query;
    }

    @Override
    public void run() {
        session.write(searchMovies());
    }

    protected String searchMovies() {
        List<Movie> search = Scraper.search(query);
        LOGGER.info("{}: << Found {} movies for query: {}", session.getAttribute(Variables.LOGGER), search.size(), query);
        String movies = search.stream().map(Movie::getTitle).collect(Collectors.joining("\n", "", "\n"));
        return String.format("%s:%s", movies.length(), movies);
    }

}
