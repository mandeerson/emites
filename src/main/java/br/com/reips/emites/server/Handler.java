package br.com.reips.emites.server;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.reips.emites.constants.Variables;

public class Handler extends IoHandlerAdapter {
    public static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        executorService.submit(new Processor(session, (String) message));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        LOGGER.error("{}: Exception caught", session.getAttribute(Variables.LOGGER), cause);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        LOGGER.info("{}: Session {} CLOSED", session.getAttribute(Variables.LOGGER), session.getId());

        session.removeAttribute(Variables.REMOTE_IP);
        session.removeAttribute(Variables.REMOTE_PORT);
        session.removeAttribute(Variables.LOCAL_PORT);
        session.removeAttribute(Variables.LOGGER);
    }

    @Override
    public void sessionOpened(final IoSession session) throws Exception {
        applySessionConfig(session);
        LOGGER.info("{}: Session {} OPENED", session.getAttribute(Variables.LOGGER), session.getId());
    }

    private void applySessionConfig(final IoSession session) {
        session.setAttribute(Variables.REMOTE_IP, ((InetSocketAddress) session.getRemoteAddress()).getHostString());
        session.setAttribute(Variables.REMOTE_PORT, ((InetSocketAddress) session.getRemoteAddress()).getPort());
        session.setAttribute(Variables.LOCAL_PORT, ((InetSocketAddress) session.getLocalAddress()).getPort());

        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(session.getId());
        builder.append(" ");
        builder.append(session.getAttribute(Variables.REMOTE_IP));
        builder.append(":");
        builder.append(session.getAttribute(Variables.REMOTE_PORT));
        builder.append("(");
        builder.append(session.getAttribute(Variables.LOCAL_PORT));
        builder.append(")]");

        session.setAttribute(Variables.LOGGER, builder.toString());
    }
}
