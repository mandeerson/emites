package br.com.reips.emites.constants;

import org.apache.mina.core.session.AttributeKey;

public class Variables {

    public static final AttributeKey REMOTE_PORT = new AttributeKey(Variables.class, "REMOTE_PORT");
    public static final AttributeKey REMOTE_IP = new AttributeKey(Variables.class, "REMOTE_IP");
    public static final AttributeKey LOCAL_PORT = new AttributeKey(Variables.class, "LOCAL_PORT");
    public static final AttributeKey ENCODER = new AttributeKey(Variables.class, "ENCODER");
    public static final AttributeKey DECODER = new AttributeKey(Variables.class, "DECODER");
    public static final AttributeKey LOGGER = new AttributeKey(Variables.class, "LOGGER");

}
