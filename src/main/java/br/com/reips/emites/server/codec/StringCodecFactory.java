package br.com.reips.emites.server.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

import br.com.reips.emites.constants.Constants;

public class StringCodecFactory implements ProtocolCodecFactory {

    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return (ProtocolEncoder) session.getAttribute(Constants.ENCODER, new StringEncoder());
    }

    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return (ProtocolDecoder) session.getAttribute(Constants.DECODER, new StringDecoder());
    }

}
