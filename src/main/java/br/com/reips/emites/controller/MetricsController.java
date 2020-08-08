package br.com.reips.emites.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.service.IoAcceptor;

import br.com.reips.emites.constants.Constants;
import br.com.reips.emites.model.Metrics;
import spark.Route;

public abstract class MetricsController {

    public static Route metrics(IoAcceptor acceptor) {
        return (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("statistics", acceptor.getStatistics());
            model.put("acceptor", acceptor);
            model.put("sessions", acceptor.getManagedSessions().values());
            model.put("metrics", new Metrics(acceptor.getManagedSessions().values()));
            return Constants.render(model, "metrics");
        };
    }

}
