package me.skinnynoonie.util.config.loader;

import me.skinnynoonie.util.config.Config;
import org.jetbrains.annotations.NotNull;

public interface ConfigLoader {

    void init();

    @NotNull <C extends Config> C load(@NotNull String configId, @NotNull Class<C> configClass);

    void save(@NotNull String configId, @NotNull Config config);

    boolean isSaved(@NotNull String configId);

}
