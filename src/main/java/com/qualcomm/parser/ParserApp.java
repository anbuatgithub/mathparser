package com.qualcomm.parser;

import com.qualcomm.parser.constant.ParserType;
import com.qualcomm.parser.exception.ParserContentException;
import com.qualcomm.parser.factory.ParserFactory;
import com.qualcomm.parser.util.ParserFileUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ParserApp {

	public static final String INPUT_FILE = "files/in.txt" ;
	public static final String OUTPUT_FILE = "files/out.txt" ;

	public static void main(String[] args) throws IOException {

		Parser parser= ParserFactory.getParser(ParserType.MATH);
		System.out.println(Integer.MAX_VALUE);

		List<String> parsedContent = ParserFileUtil.loadFile(INPUT_FILE).stream().map(line -> {
			StringBuilder convertedLine = new StringBuilder(line);
			try {
				convertedLine.append(" = ").append(parser.evaluate(line));
			} catch (ParserContentException e) {
				System.err.format("\nthe expression %s has error %s " , line ,e.getMessage());
				//convertedLine.append(e.getMessage());
			}
			return convertedLine.toString();
		}).collect(Collectors.toList());

		ParserFileUtil.saveContent(OUTPUT_FILE,parsedContent);
		System.out.format("\n *** Please refer  [%s] for the output *** ", OUTPUT_FILE);

	}

}
