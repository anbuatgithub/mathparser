package com.qualcomm.parser.impl;

import com.qualcomm.parser.Parser;
import com.qualcomm.parser.constant.ParserType;
import com.qualcomm.parser.exception.ParserContentException;
import com.qualcomm.parser.factory.ParserFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MathParserTest {

    Parser parser ;

    @Before
    public void init()  {
        parser = ParserFactory.getParser(ParserType.MATH);
    }

    @Test
    public void testEvaluate() {
        assertEquals(10,parser.evaluate("6+4"));
        assertEquals(2,parser.evaluate("((7+3)*10)/(500/10)"));
        assertEquals(-15,parser.evaluate("-2-3-7-3"));
        assertEquals(0,parser.evaluate("1*7*8*9*22*(4*0)"));

    }

    @Test(expected = ParserContentException.class)
    public void testParenthesisMissing() {
        assertEquals(Integer.MAX_VALUE,parser.evaluate("(1+3-3(7*9"));
    }

    @Test(expected = ParserContentException.class)
    public void testUnexpectedCharacter() {
        assertEquals(Integer.MAX_VALUE,parser.evaluate("1?3/4"));
    }

    @Test(expected = ParserContentException.class)
    public void testDivideByZero() {
        assertEquals(Integer.MAX_VALUE,parser.evaluate("7*9/0"));
    }


}