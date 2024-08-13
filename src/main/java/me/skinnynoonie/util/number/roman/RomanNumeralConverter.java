package me.skinnynoonie.util.number.roman;

import me.skinnynoonie.util.Arguments;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Map;

public final class RomanNumeralConverter {

    private static final String[] NUMERALS    = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] NUMERAL_VALUES = { 1000,900,  500, 400,  100, 90,   50,  40,   10,  9,    5,   4,    1 };
    private static final Map<Character, Integer> SIG_NUMERALS_MAP = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1
    );

    public static @NotNull String toNumerals(@Range(from = 1, to = 3999) int number) {
        Arguments.inRange(number, 1, 3999, "number");

        StringBuilder numeralBuilder = new StringBuilder();
        for (int i = 0; i < NUMERALS.length; i++) {
            while (number - NUMERAL_VALUES[i] >= 0) {
                number = number - NUMERAL_VALUES[i];
                numeralBuilder.append(NUMERALS[i]);
            }
        }

        return numeralBuilder.toString();
    }

    public static int parseValue(@NotNull String numerals) {
        Arguments.notNull(numerals, "numerals");

        int value = 0;
        for (int i = 0; i < numerals.length(); i++) {
            int currentNumeralValue = findNumeralValueOrThrow(numerals.charAt(i), i, numerals);
            if (i + 1 < numerals.length()) {
                int nextNumeralValue = findNumeralValueOrThrow(numerals.charAt(i + 1), i + 1, numerals);
                if (currentNumeralValue < nextNumeralValue) {
                    value += nextNumeralValue - currentNumeralValue;
                    i++;
                } else {
                    value += currentNumeralValue;
                }
            } else {
                value += currentNumeralValue;
            }
        }

        return value;
    }

    @SuppressWarnings("ConstantConditions")
    private static int findNumeralValueOrThrow(char numeral, int index, String input) {
        Integer numeralValue = SIG_NUMERALS_MAP.get(numeral);
        Arguments.legal(numeralValue != null, "illegal numeral '%s' found at index %s from input '%s'",
                                                                numeral,           index,         input);
        return numeralValue;
    }

    private RomanNumeralConverter() {
        throw new UnsupportedOperationException("can not instantiate util class");
    }

}
