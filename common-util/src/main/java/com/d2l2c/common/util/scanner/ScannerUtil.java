/**
 * 
 */
package com.d2l2c.common.util.scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dayanlazare
 *
 */
public class ScannerUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScannerUtil.class);

	public static String scanFileToText(String fileName) {
		File file = new File(fileName);
		return scanFileToText(file);
	}

	public static String scanFileToText(File file) {
		String content = null;
		try (InputStream stream = new FileInputStream(file)) {
			content = scanFileToText(stream);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return content;
	}

	public static String scanFileToText(InputStream inputStream) throws Exception {
		PDDocument doc = PDDocument.load(inputStream);
	    return new PDFTextStripper().getText(doc);
	}
	
	

}
