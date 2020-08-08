package br.com.reips.emites.server;

import java.util.Set;
import java.util.TreeSet;

import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.junit.Assert;
import org.junit.Test;

import br.com.reips.emites.constants.Constants;
import br.com.reips.emites.model.Search;

public class ProcessorTest {

    @Test
    public void processAvengersQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Avengers"));
        processor.run();
        Assert.assertEquals(1, session.getWrittenMessages());
    }

    @Test
    public void processAvengersQueryResponse() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Avengers"));
        Assert.assertEquals("41:Avengers: United They Stand\nThe Avengers\n", processor.searchMovies());
    }

    @Test
    public void processCubeQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Cube"));
        processor.run();
        Assert.assertEquals(1, session.getWrittenMessages());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void processCubeQueryResponse() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor = new Processor(session, new Search("Cube"));
        Assert.assertEquals("10:Cube\nCube\n", processor.searchMovies());

        Set<Search> searches = (TreeSet<Search>) session.getAttribute(Constants.SEARCHES);
        Assert.assertEquals(1, searches.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void processMultipleQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        session.setAttribute(Constants.SEARCHES, new TreeSet<>());
        Processor processor1 = new Processor(session, new Search("Cube"));
        processor1.run();
        Assert.assertEquals(1, session.getWrittenMessages());

        Processor processor2 = new Processor(session, new Search("Avengers"));
        processor2.run();
        Assert.assertEquals(2, session.getWrittenMessages());

        Set<Search> searches = (TreeSet<Search>) session.getAttribute(Constants.SEARCHES);
        Assert.assertEquals(2, searches.size());
    }

}
