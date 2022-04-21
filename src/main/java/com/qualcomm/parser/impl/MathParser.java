package com.qualcomm.parser.impl;

import com.qualcomm.parser.Parser;
import com.qualcomm.parser.exception.ParserContentException;
import com.qualcomm.parser.constant.ParserExpressionChar;

public class MathParser implements Parser {

    @Override
    public int evaluate(final String str) throws ParserContentException {
        return new Object() {
            int pos = -1;
            int ch;

            int parse() throws ParserContentException {
                nextChar();
                int val = parseExpression();
                if (pos < str.length()) throw new ParserContentException("Unexpected char : " + (char) ch);
                return val;
            }

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            int parseExpression() throws ParserContentException {
                int val = parseTerm();
                while(true) {
                    if (eat(ParserExpressionChar.PLUS.value())) val += parseTerm();
                    else if (eat(ParserExpressionChar.MINUS.value())) val -= parseTerm();
                    else return val;
                }
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }


            int parseTerm() throws ParserContentException {
                int val = parseParenthesis();
                while(true) {
                    if (eat(ParserExpressionChar.STAR.value())) {
                        val *= parseParenthesis();
                    }
                    else if (eat(ParserExpressionChar.SLASH.value())) {
                        try{
                            val /= parseParenthesis();
                        } catch(ArithmeticException e){
                            throw new ParserContentException("Expression should not contain divide by zero");
                        }
                    }
                    else return val;
                }
            }

            int parseParenthesis() throws ParserContentException {
                if (eat(ParserExpressionChar.PLUS.value())) return +parseParenthesis();
                if (eat(ParserExpressionChar.MINUS.value())) return -parseParenthesis();
                int val;
                int startPos = this.pos;
                if (eat(ParserExpressionChar.LEFT_PARENTHESIS.value())) {
                    val = parseExpression();
                    if (!eat(ParserExpressionChar.RIGHT_PARENTHESIS.value())) throw new ParserContentException("Missing ')'");
                } else if ((ch >= ParserExpressionChar.NUMBER_ZERO.value() && ch <= ParserExpressionChar.NUMBER_NINE.value())) { // numbers
                    while ((ch >= ParserExpressionChar.NUMBER_ZERO.value() && ch <= ParserExpressionChar.NUMBER_NINE.value())) nextChar();
                    val = Integer.parseInt(str.substring(startPos, this.pos));
                } else {
                    throw new ParserContentException("Unexpected char : " + (char) ch);
                }
                return val;
            }
        }.parse();
    }

}
