package com.distilled.daft.utillities;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

public class Helper {

	WebDriver driver;

	public String removeStringsfromText(String stringAndNumbers) {

		String numbers = "";

		int i = 0;
		StringBuilder resultBuilder = new StringBuilder();

		// Define the regex pattern to match numbers
		Pattern pattern = Pattern.compile("\\d+");

		// Create a Matcher object
		java.util.regex.Matcher matcher = pattern.matcher(stringAndNumbers);

		// Find and print all the numbers in the input string
		while (matcher.find()) {
			System.out.println("Found: " + matcher.group());
			numbers = matcher.group().concat(stringAndNumbers);

		}
		return numbers;

	}

	public void changeWindown() {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			// Add logic to identify the desired window based on title, URL, etc.
			if (driver.getTitle().equals("")) {
				break;
			}
		}

	}

}
