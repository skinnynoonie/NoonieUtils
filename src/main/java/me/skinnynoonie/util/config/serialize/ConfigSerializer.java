package me.skinnynoonie.util.config.serialize;

import me.skinnynoonie.util.config.Config;
import org.jetbrains.annotations.NotNull;

public interface ConfigSerializer {

    @NotNull String serialize(@NotNull Config config);

    @NotNull Config deserialize(@NotNull String string);

}
