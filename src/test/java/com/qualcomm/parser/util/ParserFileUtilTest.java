package com.qualcomm.parser.util;


import static org.junit.Assert.*;
import com.qualcomm.parser.exception.ParserFileException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class ParserFileUtilTest {


    public static final String TEST_INPUT_FILE = "files/test-in.txt" ;
    public static final String TEST_OUTPUT_FILE = "files/test-out.txt" ;

    @Test
    public void testLoadFile() {
        List<String> fileContent = ParserFileUtil.loadFile(TEST_INPUT_FILE);
        assertNotNull(fileContent);
        assertEquals(2,fileContent.size());
    }

    @Test
    public void testSaveContent() {
        ParserFileUtil.saveContent(TEST_OUTPUT_FILE, Arrays.asList("1+2"));
        List<String> fileContent = ParserFileUtil.loadFile(TEST_OUTPUT_FILE);
        assertEquals(1,fileContent.size());
    }

    @Test(expected = ParserFileException.class)
    public void testFileExist() {
        List<String> fileContent = ParserFileUtil.loadFile("FileDoesntExist.txt");
    }

}