package me.skinnynoonie.util.config.repository;

import me.skinnynoonie.util.config.serialize.JsonConfigSerializer;
import me.skinnynoonie.util.config.serialize.YmlConfigSerializer;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public final class ConfigRepositories {

    public static @NotNull ConfigRepository concurrentLocalJson(@NotNull Path configFolder) {
        return new ConcurrentLocalFileConfigRepository(configFolder, JsonConfigSerializer.createDefault());
    }

    public static @NotNull ConfigRepository concurrentLocalYml(@NotNull Path configFolder) {
        return new ConcurrentLocalFileConfigRepository(configFolder, YmlConfigSerializer.createDefault());
    }

    private ConfigRepositories() {
        throw new UnsupportedOperationException("can not initialize util class");
    }

}
