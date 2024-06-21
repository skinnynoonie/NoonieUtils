package me.skinnynoonie.util.config.exception;

import org.jetbrains.annotations.NotNull;

public class ConfigSerializationException extends ConfigException {

    public ConfigSerializationException() {
    }

    public ConfigSerializationException(String message) {
        super(message);
    }

    public ConfigSerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigSerializationException(Throwable cause) {
        super(cause);
    }

    @Override
    public @NotNull ConfigSerializationException setFriendlyMessage(String friendlyMessage) {
        return (ConfigSerializationException) super.setFriendlyMessage(friendlyMessage);
    }

}
