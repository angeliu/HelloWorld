package Filter;

import java.util.regex.*;

public class Test {
	public static void main(String[] args)
	{
		System.out.println("abc".matches("..."));
		System.out.println("a8729a".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("fgh");
		System.out.println(m.matches());
		System.out.println("fgha".matches("[a-z]{3}"));
		
		System.out.println("F".matches("[A-Z&&[RFG]]"));
		
		
	}

}
