package com.qualcomm.parser.factory;

import com.qualcomm.parser.Parser;
import com.qualcomm.parser.constant.ParserType;
import com.qualcomm.parser.impl.MathParser;

public class ParserFactory {

    public static Parser getParser(ParserType type) {
        switch (type) {
            case MATH:
                return new MathParser();
        }
        return null;
    }
}
