package br.com.reips.emites.server.codec;

import java.util.Arrays;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.constants.Constants;
import br.com.reips.emites.model.Search;

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

            int sizeLength = 1;
            for (int i = 0; i < buffer.length; i++) {
                byte buff = buffer[i];
                if (buff == (byte) 58) {
                    sizeLength = i;
                    break;
                }
            }
            byte[] sizeBytes = Arrays.copyOfRange(buffer, 0, sizeLength);
            int size = Integer.parseInt(new String(sizeBytes));
            if (size > remaining - sizeBytes.length - 1) {
                // Need more data
                in.position(0);
                return false;
            }

            if (size <= remaining - 2) {
                // One or more queries
                int difference = buffer.length - size - sizeBytes.length - 1;
                int startQuery = buffer.length - difference - size;
                int endQuery = buffer.length - difference;

                byte[] data = Arrays.copyOfRange(buffer, startQuery, endQuery);

                LOGGER.info("{}: << {}", session.getAttribute(Constants.LOGGER), Arrays.toString(data));

                out.write(new Search(new String(data)));
                in.position(initPosition + endQuery);
                // If has remaining bytes, process again
                return in.position() != limit;
            }
        }
        // Need more data
        return false;
    }

}
