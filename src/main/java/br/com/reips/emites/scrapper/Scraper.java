package br.com.reips.emites.scrapper;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class Scraper {
    public static final Logger LOGGER = LoggerFactory.getLogger(Scraper.class);

    public static List<Movie> search(String query) {
        try {
            String search = "https://www.imdb.com/find?q=" + URLEncoder.encode(query, "UTF-8");
            HttpResponse<String> response = Unirest.get(search).asString();
            if (response.getStatus() == HttpStatus.SC_OK) {
                Pattern pattern = Pattern.compile("\"result_text\"> <a href=\"/title/tt([0-9]*)/(.*?)\" >(.*?)</a>");
                Matcher matcher = pattern.matcher(response.getBody());
                List<Movie> movies = new ArrayList<>();
                while (matcher.find()) {
                    movies.add(new Movie(matcher.group(3)));
                }
                if (CollectionUtils.isEmpty(movies)) {
                    return Arrays.asList(new Movie("Not found"));
                }
                return movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            LOGGER.error("Problem to serach movie", e);
        }
        return Arrays.asList(new Movie("Problem to search"));
    }
}