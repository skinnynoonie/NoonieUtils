package me.skinnynoonie.util.config.serialize;

import me.skinnynoonie.util.Arguments;
import me.skinnynoonie.util.config.Config;
import me.skinnynoonie.util.config.exception.ConfigSerializationException;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
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

        try {
            return this.yaml.dumpAs(config, Tag.MAP, DumperOptions.FlowStyle.BLOCK);
        } catch (YAMLException e) {
            throw new ConfigSerializationException(e);
        }
    }

    @Override
    public <C extends Config> @NotNull C deserialize(@NotNull String string, @NotNull Class<C> configClass) {
        Arguments.notNull(string, "string");
        Arguments.notNull(configClass, "configClass");

        try {
            return this.yaml.loadAs(string, configClass);
        } catch (YAMLException e) {
            throw new ConfigSerializationException(e);
        }
    }

    @Override
    public @NotNull String getFormatAcronym() {
        return "YML";
    }

    public @NotNull Yaml getYaml() {
        return this.yaml;
    }

}
