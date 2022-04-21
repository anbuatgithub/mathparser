package com.qualcomm.parser.constant;


public enum ParserExpressionChar {
    PLUS(Constants.PLUS),
    MINUS(Constants.MINUS),
    STAR(Constants.STAR),
    SLASH(Constants.SLASH),
    LEFT_PARENTHESIS(Constants.LEFT_PARENTHESIS),
    RIGHT_PARENTHESIS(Constants.RIGHT_PARENTHESIS),
    NUMBER_ZERO(Constants.NUMBER_ZERO),
    NUMBER_NINE(Constants.NUMBER_NINE);

    ParserExpressionChar(char value) {
        this.value = value;
    }

    private final char value;

    public char value() {
        return value;
    }

    private static class Constants {
        public static final char PLUS = '+';
        public static final char MINUS = '-';
        public static final char STAR = '*';
        public static final char SLASH = '/';
        public static final char LEFT_PARENTHESIS = '(';
        public static final char RIGHT_PARENTHESIS = ')';
        public static final char NUMBER_ZERO = '0';
        public static final char NUMBER_NINE = '9';


    }
}