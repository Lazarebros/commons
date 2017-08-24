/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

/**
 * @author dayanlazare
 *
 */
public class PaycheckExtractorFactory {

	public static AbstractPaycheckExtractor getInstance(String content) {
		AbstractPaycheckExtractor extractor = null;
		if (content != null) {
			if (content.contains("Mountain State Software Solutions")) {
				extractor = new MS3PaycheckExtractor();
			} else if (content.contains("MITCHELL MARTIN INC")) {
				extractor = new MMIPaycheckExtractor();
			}
		}
		return extractor;
	}

}
