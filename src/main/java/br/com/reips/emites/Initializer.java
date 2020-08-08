package br.com.reips.emites;

import java.io.IOException;

import org.apache.mina.core.service.IoAcceptor;

import br.com.reips.emites.server.Listener;

public class Initializer {

    public static void main(String[] args) throws IOException {
        Listener listener = new Listener();

        IoAcceptor start = listener.start();
        while (start.isActive()) {
            // TESTE
        }

    }

}
