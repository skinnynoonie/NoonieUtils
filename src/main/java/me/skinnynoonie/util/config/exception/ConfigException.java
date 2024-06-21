package me.skinnynoonie.util.config.exception;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConfigException extends RuntimeException {

    private String friendlyMessage;

    public ConfigException() {
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }

    public @Nullable String getFriendlyMessage() {
        return this.friendlyMessage;
    }

    public @NotNull ConfigException setFriendlyMessage(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
        return this;
    }

}
