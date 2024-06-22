package me.skinnynoonie.util.config.serialize;

import me.skinnynoonie.util.config.Config;
import org.jetbrains.annotations.NotNull;

public interface ConfigSerializer {

    /**
     * Serializes a {@link Config} to a {@link String} form.
     *
     * @param config The config to serialize.
     * @return The serialized form of the config.
     * @throws me.skinnynoonie.util.config.exception.ConfigSerializationException If an exception occurs while serializing.
     */
    @NotNull String serialize(@NotNull Config config);

    /**
     * Deserializes a serialized config.
     *
     * @param string The deserialized config.
     * @param configClass The config class that the deserialized config represents.
     * @return A {@link Config} with the type of the {@code configClass} provided.
     */
    <C extends Config> @NotNull C deserialize(@NotNull String string, Class<C> configClass);

    /**
     * Returns the format this config serializer is associated with.
     * Some sample results are: YAML, YML, JSON.
     *
     * @return The acronym this serialize is associated with, casing may vary.
     */
    @NotNull String getFormatAcronym();

}
