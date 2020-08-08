package br.com.reips.emites.server.codec;

import java.util.Arrays;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.constants.Variables;

public class StringEncoder implements ProtocolEncoder {
    public static final Logger LOGGER = LoggerFactory.getLogger(StringEncoder.class);

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        final String msg = (String) message;
        byte[] data = msg.getBytes();

        LOGGER.info("{}: >> TX: {}", session.getAttribute(Variables.LOGGER), Arrays.toString(data));

        final IoBuffer buf = IoBuffer.allocate(data.length);
        buf.setAutoExpand(false);
        buf.put(data);
        buf.flip();
        out.write(buf);
    }

    @Override
    public void dispose(IoSession session) throws Exception {
        session.removeAttribute(Variables.ENCODER);
    }

}
