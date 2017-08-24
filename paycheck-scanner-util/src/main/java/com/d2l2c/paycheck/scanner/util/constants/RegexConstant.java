/**
 * 
 */
package com.d2l2c.paycheck.scanner.util.constants;

/**
 * @author dayanlazare
 *
 */
public interface RegexConstant {

	public static final String PAY_PERIOD = "\\bpay?\\s+(?:\\w+\\s+){0,2}period\\b";
	
	public static final String REGULAR_PAY = "\\bregular?\\s+(?:\\w+\\s+){0,2}pay\\b";
	
	public static final String NET_PAY = "\\bNet?\\s+(?:\\w+\\s+){0,2}Pay\\b";
	
	public static final String REIMBURSEMENT = "((\\bIExp\\b)|(\\bCBEx\\b))";

	public static final String DATE = "(0[1-9]|1[012])/([0-2][0-9]|3[0-1])/(20\\d{2}|19\\d{2}|0(?!0)\\d|[1-9]\\d)";

	public static final String NUMBER = "(\\d+\\.\\d+|\\d+)";
	
	public static final String GROSS_EARNINGS = "\\bgross?\\s+(?:\\w+\\s+){0,2}earnings\\b";
	
	public static final String WEIGHTWATCHE_REGULAR = "\\bWEIGHTWATCHE?\\s+(?:\\w+\\s+){0,2}REGULAR\\b";

}
