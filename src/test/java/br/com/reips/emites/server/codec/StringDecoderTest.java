package br.com.reips.emites.server.codec;

import java.util.Queue;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.filter.codec.ProtocolCodecSession;
import org.junit.Assert;
import org.junit.Test;

public class StringDecoderTest {

    @Test
    public void decodeQueryAvengers() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("8:Avengers".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(1, decoderOutputQueue.size());

        Object poll = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll.getClass());
        Assert.assertEquals("Avengers", poll);
    }

    @Test
    public void decodeQueryCube() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cube".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(1, decoderOutputQueue.size());

        Object poll = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll.getClass());
        Assert.assertEquals("Cube", poll);
    }

    @Test
    public void decodeMultipleQuery() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cube8:Avengers4:Cube8:Avengers5:Cubes".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(5, decoderOutputQueue.size());

        Object poll1 = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll1.getClass());
        Assert.assertEquals("Cube", poll1);

        Object poll2 = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll2.getClass());
        Assert.assertEquals("Avengers", poll2);

        Object poll3 = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll3.getClass());
        Assert.assertEquals("Cube", poll3);

        Object poll4 = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll4.getClass());
        Assert.assertEquals("Avengers", poll4);

        Object poll5 = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll5.getClass());
        Assert.assertEquals("Cubes", poll5);
    }

    @Test
    public void decodeOneQueryAndOneBrokenQuery() throws Exception {
        StringDecoder decoder = new StringDecoder();
        ProtocolCodecSession session = new ProtocolCodecSession();

        decoder.decode(session, IoBuffer.wrap("4:Cube8:Aveng".getBytes()), session.getDecoderOutput());
        Queue<Object> decoderOutputQueue = session.getDecoderOutputQueue();

        Assert.assertEquals(1, decoderOutputQueue.size());

        Object poll1 = decoderOutputQueue.poll();
        Assert.assertEquals(String.class, poll1.getClass());
        Assert.assertEquals("Cube", poll1);
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
