package me.skinnynoonie.util.config.repository;

import me.skinnynoonie.util.Arguments;
import me.skinnynoonie.util.config.Config;
import org.jetbrains.annotations.NotNull;

/**
 * A repository for {@link Config configs}.
 */
public interface ConfigRepository {

    /**
     * Initiates the config repository.
     *
     * @throws me.skinnynoonie.util.config.exception.ConfigException If an exception occurs.
     */
    void init();

    /**
     * Loads a config from this repository.
     *
     * @param configId The config's ID.
     * @param configClass The class of the loaded config.
     * @return The loaded config.
     * @throws IllegalArgumentException If any arguments are null.
     * @throws me.skinnynoonie.util.config.exception.ConfigException If an exception occurs while loading the config.
     * @throws me.skinnynoonie.util.config.exception.ConfigSerializationException If an exception occurs while deserializing the config.
     * @throws me.skinnynoonie.util.config.exception.ConfigNotFoundException If the config does not exist.
     * @see ConfigRepository#isSaved(String)
     */
    @NotNull <C extends Config> C load(@NotNull String configId, @NotNull Class<C> configClass);

    /**
     * Loads a config, but provides a fallback config if the config is not saved.
     *
     * @param configId The config's ID.
     * @param fallback The fallback config.
     * @return The loaded config or the fallback config.
     * @throws IllegalArgumentException If any arguments are null.
     * @throws me.skinnynoonie.util.config.exception.ConfigException If an exception occurs while loading the config.
     * @throws me.skinnynoonie.util.config.exception.ConfigSerializationException If an exception occurs while deserializing the config.
     */
    @SuppressWarnings("unchecked")
    default <C extends Config> @NotNull C load(@NotNull String configId, @NotNull C fallback) {
        Arguments.notNull(fallback, "fallback");

        if (this.isSaved(configId)) {
            return (C) this.load(configId, fallback.getClass());
        } else {
            return fallback;
        }
    }

    /**
     * Saves a config to this repository.
     *
     * @param configId The ID of the config to save.
     * @param config The config to save.
     * @throws IllegalArgumentException If any arguments are null.
     * @throws me.skinnynoonie.util.config.exception.ConfigException If an exception occurs while saving the config.
     * @throws me.skinnynoonie.util.config.exception.ConfigSerializationException If an exception occurs while serializing the config.
     */
    void save(@NotNull String configId, @NotNull Config config);

    /**
     * Checks to see if the config is saved in this repository.
     * This does not mean the saved config is valid.
     *
     * @param configId The ID of the config to check.
     * @return {@code true} if the config is saved, otherwise {@code false}.
     * @throws IllegalArgumentException If any arguments are null.
     * @throws me.skinnynoonie.util.config.exception.ConfigException If an exception occurs while checking, however should be very unlikely.
     */
    boolean isSaved(@NotNull String configId);

}
