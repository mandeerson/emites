package br.com.reips.emites.server;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.constants.Constants;
import br.com.reips.emites.model.Search;
import br.com.reips.emites.scrapper.Movie;
import br.com.reips.emites.scrapper.Scraper;

public class Processor implements Runnable {
    public static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    private IoSession session;
    private Search search;
    private List<Movie> response;

    @SuppressWarnings("unchecked")
    public Processor(IoSession session, Search search) {
        this.session = session;
        this.search = search;

        ((TreeSet<Search>) session.getAttribute(Constants.SEARCHES)).add(search);
    }

    @Override
    public void run() {
        response = Scraper.search(search.getQuery());
        LOGGER.info("{}: << Found {} movies for query: {}", session.getAttribute(Constants.LOGGER), response.size(), search.getQuery());
        session.write(processResponse());
    }

    protected String processResponse() {
        search.setMovies(response);
        String movies = response.stream().map(Movie::getTitle).collect(Collectors.joining("\n", "", "\n"));
        return String.format("%s:%s", movies.length(), movies);
    }

    public void setResponse(List<Movie> response) {
        this.response = response;
    }

    public List<Movie> getResponse() {
        return response;
    }

}
