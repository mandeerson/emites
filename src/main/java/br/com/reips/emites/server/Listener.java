package br.com.reips.emites.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.server.codec.StringCodecFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class Listener {

    public static Listener create() {
        return new Listener();
    }

    public IoAcceptor start(Integer port) throws IOException {
        Logger minaLogger = (Logger) LoggerFactory.getLogger("org.apache.mina");
        if (minaLogger != null) {
            minaLogger.setLevel(Level.OFF);
        }

        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new StringCodecFactory()));
        acceptor.setHandler(new Handler());
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, (int) TimeUnit.MINUTES.toSeconds(10));
        acceptor.bind(new InetSocketAddress(port));
        return acceptor;
    }

}
