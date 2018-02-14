/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.extractor;

import com.d2l2c.paycheck.scanner.util.constants.Constants;

/**
 * @author dayanlazare
 *
 */
public class PaycheckExtractorFactory {

	public static AbstractPaycheckExtractor getInstance(String content) {
		AbstractPaycheckExtractor extractor = null;
		if (content != null) {
			if (content.contains(Constants.MS3_COMPANY_NAME)) {
				extractor = new MS3PaycheckExtractor();
			} else if (content.contains(Constants.MMI_COMPANY_NAME)) {
				extractor = new MMIPaycheckExtractor();
			}
		}
		return extractor;
	}

}
