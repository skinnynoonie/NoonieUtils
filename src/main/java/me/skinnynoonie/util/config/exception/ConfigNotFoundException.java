package me.skinnynoonie.util.config.exception;

public final class ConfigNotFoundException extends ConfigException {

    public ConfigNotFoundException() {
    }

    public ConfigNotFoundException(String message) {
        super(message);
    }

    public ConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigNotFoundException(Throwable cause) {
        super(cause);
    }

}
