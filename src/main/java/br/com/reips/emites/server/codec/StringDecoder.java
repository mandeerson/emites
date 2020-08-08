package br.com.reips.emites.server.codec;

import java.util.Arrays;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.constants.Variables;

public class StringDecoder extends CumulativeProtocolDecoder {
    public static final Logger LOGGER = LoggerFactory.getLogger(StringDecoder.class);

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        final int limit = in.limit();
        if (limit > 0) {
            int initPosition = in.position();
            int remaining = limit - initPosition;
            final byte[] buffer = new byte[remaining];
            in.get(buffer, 0, remaining);

            int size = Character.getNumericValue(buffer[0]);
            if (size > remaining - 2) {
                // Need more data
                in.position(0);
                return false;
            }

            if (size <= remaining - 2) {
                // One or more queries
                int difference = buffer.length - size - 2;
                int startQuery = buffer.length - difference - size;
                int endQuery = buffer.length - difference;

                byte[] data = Arrays.copyOfRange(buffer, startQuery, endQuery);

                LOGGER.info("{}: << {}", session.getAttribute(Variables.LOGGER), Arrays.toString(data));

                out.write(new String(data));
                in.position(initPosition + endQuery);
                return in.position() != limit;
            }
        }
        // Need more data
        return false;
    }

}
