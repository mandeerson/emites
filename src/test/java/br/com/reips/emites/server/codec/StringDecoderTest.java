package br.com.reips.emites.server.codec;

import java.util.Queue;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.junit.Assert;
import org.junit.Test;

import br.com.reips.emites.model.Search;

public class StringDecoderTest {

    @Test
    public void decodeQueryAvengers() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("8:Avengers".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(1, decoderOutputQueue.size());

        Object poll = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll.getClass());
        Search search = (Search) poll;
        Assert.assertEquals("Avengers", search.getQuery());
    }

    @Test
    public void decodeQueryCube() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cube".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(1, decoderOutputQueue.size());

        Object poll = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll.getClass());
        Search search = (Search) poll;
        Assert.assertEquals("Cube", search.getQuery());
    }

    @Test
    public void decodeMultipleQuery() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cube8:Avengers4:Cube8:Avengers5:Cubes".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(5, decoderOutputQueue.size());

        Object poll1 = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll1.getClass());
        Search search1 = (Search) poll1;
        Assert.assertEquals("Cube", search1.getQuery());

        Object poll2 = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll2.getClass());
        Search search2 = (Search) poll2;
        Assert.assertEquals("Avengers", search2.getQuery());

        Object poll3 = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll3.getClass());
        Search search3 = (Search) poll3;
        Assert.assertEquals("Cube", search3.getQuery());

        Object poll4 = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll4.getClass());
        Search search4 = (Search) poll4;
        Assert.assertEquals("Avengers", search4.getQuery());

        Object poll5 = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll5.getClass());
        Search search5 = (Search) poll5;
        Assert.assertEquals("Cubes", search5.getQuery());
    }

    @Test
    public void decodeOneQueryAndOneBrokenQuery() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cube8:Aveng".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(1, decoderOutputQueue.size());

        Object poll1 = decoderOutputQueue.poll();
        Assert.assertEquals(Search.class, poll1.getClass());
        Search search1 = (Search) poll1;
        Assert.assertEquals("Cube", search1.getQuery());
    }

    @Test
    public void decodeBrokenQuery() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cub".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(0, decoderOutputQueue.size());
    }

}
