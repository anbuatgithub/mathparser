package com.qualcomm.parser;

import com.qualcomm.parser.impl.MathParserTest;
import com.qualcomm.parser.util.ParserFileUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MathParserTest.class, ParserFileUtilTest.class})
public class ParserSuite {

}