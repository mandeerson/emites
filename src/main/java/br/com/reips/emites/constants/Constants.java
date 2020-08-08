package br.com.reips.emites.constants;

import java.util.Map;

import org.apache.mina.core.session.AttributeKey;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public final class Constants {

    private Constants() {
    }

    private static final ThymeleafTemplateEngine THYMELEAF_TEMPLATE_ENGINE = new ThymeleafTemplateEngine();

    public static final AttributeKey REMOTE_PORT = new AttributeKey(Constants.class, "REMOTE_PORT");
    public static final AttributeKey REMOTE_IP = new AttributeKey(Constants.class, "REMOTE_IP");
    public static final AttributeKey LOCAL_PORT = new AttributeKey(Constants.class, "LOCAL_PORT");
    public static final AttributeKey ENCODER = new AttributeKey(Constants.class, "ENCODER");
    public static final AttributeKey DECODER = new AttributeKey(Constants.class, "DECODER");
    public static final AttributeKey LOGGER = new AttributeKey(Constants.class, "LOGGER");
    public static final AttributeKey SEARCHES = new AttributeKey(Constants.class, "SEARCHES");

    public static String render(Map<String, Object> model, String templatePath) {
        return THYMELEAF_TEMPLATE_ENGINE.render(new ModelAndView(model, templatePath));
    }

}
