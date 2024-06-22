package me.skinnynoonie.util.config.loader;

import me.skinnynoonie.util.config.serialize.JsonConfigSerializer;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public final class ConfigLoaders {

    public static @NotNull ConfigLoader concurrentLocalJson(@NotNull Path configFolder) {
        return new ConcurrentLocalFileConfigLoader(configFolder, JsonConfigSerializer.createDefault());
    }

    private ConfigLoaders() {
        throw new UnsupportedOperationException("can not initialize util class");
    }

}
