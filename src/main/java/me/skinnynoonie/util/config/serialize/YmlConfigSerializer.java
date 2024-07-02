package me.skinnynoonie.util.config.serialize;

import me.skinnynoonie.util.Arguments;
import me.skinnynoonie.util.config.Config;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

public final class YmlConfigSerializer implements ConfigSerializer {

    public static @NotNull YmlConfigSerializer createDefault() {
        return new YmlConfigSerializer(new Yaml());
    }

    private final Yaml yaml;

    public YmlConfigSerializer(@NotNull Yaml yaml) {
        Arguments.notNull(yaml, "yaml");

        this.yaml = yaml;
    }

    @Override
    public @NotNull String serialize(@NotNull Config config) {
        Arguments.notNull(config, "config");

        return this.yaml.dumpAs(config, Tag.MAP, DumperOptions.FlowStyle.BLOCK);
    }

    @Override
    public <C extends Config> @NotNull C deserialize(@NotNull String string, Class<C> configClass) {
        Arguments.notNull(string, "string");
        Arguments.notNull(configClass, "configClass");

        return this.yaml.loadAs(string, configClass);
    }

    @Override
    public @NotNull String getFormatAcronym() {
        return "YML";
    }

}
