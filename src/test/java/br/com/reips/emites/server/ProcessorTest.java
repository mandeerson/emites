package br.com.reips.emites.server;

import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.junit.Assert;
import org.junit.Test;

public class ProcessorTest {

    @Test
    public void processAvengersQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        Processor processor = new Processor(session, "Avengers");
        processor.run();
        Assert.assertEquals(1, session.getWrittenMessages());
    }

    @Test
    public void processAvengersQueryResponse() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        Processor processor = new Processor(session, "Avengers");
        Assert.assertEquals("57:Os Vingadores da Costa Oeste\nThe Avengers: Os Vingadores\n", processor.searchMovies());
    }

    @Test
    public void processCubeQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        Processor processor = new Processor(session, "Cube");
        processor.run();
        Assert.assertEquals(1, session.getWrittenMessages());
    }

    @Test
    public void processCubeQueryResponse() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        Processor processor = new Processor(session, "Cube");
        Assert.assertEquals("10:Cube\nCubo\n", processor.searchMovies());
    }

    @Test
    public void processMultipleQuery() {
        ProtocolCodecSession session = new ProtocolCodecSession();
        Processor processor1 = new Processor(session, "Cube");
        processor1.run();
        Assert.assertEquals(1, session.getWrittenMessages());

        Processor processor2 = new Processor(session, "Avengers");
        processor2.run();
        Assert.assertEquals(2, session.getWrittenMessages());
    }

}
