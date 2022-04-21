package com.qualcomm.parser;

import com.qualcomm.parser.exception.ParserContentException;

public interface Parser {

    public  int evaluate(String str) throws ParserContentException;
}
