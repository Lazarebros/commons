/**
 * 
 */
package com.d2l2c.common.util.scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dayanlazare
 *
 */
public class ScannerUtil {

	private static final Logger logger = LoggerFactory.getLogger(ScannerUtil.class);

	public static String scanFileToText(String fileName) {
		File file = new File(fileName);
		return scanFileToText(file);
	}

	public static String scanFileToText(File file) {
		String content = null;
		try (InputStream stream = new FileInputStream(file)) {
			content = scanFileToText(stream);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return content;
	}

	public static String scanFileToText(InputStream inputStream) throws Exception {
		AutoDetectParser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();

		parser.parse(inputStream, handler, metadata);
		return handler.toString();
	}

}
