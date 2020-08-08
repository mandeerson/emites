package br.com.reips.emites;

import java.io.IOException;

import org.apache.mina.core.service.IoAcceptor;

import br.com.reips.emites.controller.MetricsController;
import br.com.reips.emites.server.Listener;
import spark.Spark;

public class Initializer {

    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = Listener.create().start(9090);

        Spark.staticFileLocation("/static");
        Spark.get("/", MetricsController.metrics(acceptor));
    }

}
