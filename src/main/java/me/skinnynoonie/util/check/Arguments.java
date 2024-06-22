package me.skinnynoonie.util.check;

public final class Arguments {

    public static void notNull(Object arg, String argName) {
        if (arg == null) {
            throw new IllegalArgumentException("Argument " + argName + " is null");
        }
    }

    private Arguments() {
        throw new UnsupportedOperationException("can not initialize util class");
    }

}
