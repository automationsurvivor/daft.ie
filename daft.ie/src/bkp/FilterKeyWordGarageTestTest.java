package ie.com.distilled.daft.test;

import java.util.regex.Pattern;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

public class FilterKeyWordGarageTestTest {
	@Test
	public void testString() {
		String str ="";
		String inputString = "231 Properties for Sale in Dublin City\";";
		

		// Define the regex pattern to match numbers
		Pattern pattern = Pattern.compile("\\d+");

		// Create a Matcher object
		java.util.regex.Matcher matcher = pattern.matcher(inputString);

		// Find and print all the numbers in the input string
		while (matcher.find()) {
			System.out.println("Found: " + matcher.group());
			str = matcher.group();

		}
		System.out.println(str);

	}
}