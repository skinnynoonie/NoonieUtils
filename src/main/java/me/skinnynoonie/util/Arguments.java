package me.skinnynoonie.util;

/**
 * A utility class to check given arguments.
 */
public final class Arguments {

    /**
     * Assures the argument is not null.
     * Throws {@link IllegalArgumentException} with a pre-written exception message if this condition is not true.
     *
     * @param arg The argument that should not be null.
     * @param argName The name of the argument to use in the pre-written exception message.
     */
    public static void notNull(Object arg, String argName) {
        if (arg == null) {
            throwIllegalArgumentException("Argument %s is null", argName);
        }
    }

    /**
     * Assures the argument is in the specified range inclusively.
     * Throws {@link IllegalArgumentException} with a pre-written exception message if this condition is not true.
     *
     * @param number The argument that should be within the range inclusively.
     * @param argName The name of the argument to use in the pre-written exception message.
     */
    public static void inRange(double number, double min, double max, String argName) {
        if (number < min || number > max) {
            throwIllegalArgumentException("Argument %s is not in range %s to %s (inclusive)", argName, min, max);
        }
    }

    /**
     * Assures the {@code condition} provided is true, otherwise throwing {@link IllegalArgumentException}
     * with the provided exception message.
     *
     * @param condition The condition which must be true.
     * @param exceptionMessage The exception message that will be used in the thrown exception (if thrown).
     * @param arguments Any arguments for the exception message.
     */
    public static void legal(boolean condition, String exceptionMessage, Object... arguments) {
        if (!condition) {
            throwIllegalArgumentException(exceptionMessage, arguments);
        }
    }

    private static void throwIllegalArgumentException(String exceptionMessage, Object... arguments) {
        throw new IllegalArgumentException(String.format(exceptionMessage, arguments));
    }

    private Arguments() {
        throw new UnsupportedOperationException("can not initialize util class");
    }

}
