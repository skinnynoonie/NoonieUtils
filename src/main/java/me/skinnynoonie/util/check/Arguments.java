package me.skinnynoonie.util.check;

public final class Arguments {

    public static void notNull(Object arg, String argName) {
        if (arg == null) {
            throw new IllegalArgumentException("Argument " + argName + " is null");
        }
    }

    public static void inRange(double number, double min, double max, String argName) {
        if (number < min || number > max) {
            throw new IllegalArgumentException
                    ("Argument " + argName + " is not in range " + min + " to " + max + " (inclusive)");
        }
    }

    public static void legal(boolean condition, String exceptionMessage, Object... arguments) {
        if (!condition) {
            throw new IllegalArgumentException(exceptionMessage.formatted(arguments));
        }
    }

    private Arguments() {
        throw new UnsupportedOperationException("can not initialize util class");
    }

}
