package hooks;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddCouponPage;

public class BaseClass {

	//public static WebDriver driver;

	public static String couponName = "11";

	public String generateAphaNumericCouponName(int length) {
		final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890".toCharArray();
		final Random random = new Random();
		for (int i = 0; i < length; i++) {
			couponName = couponName + chars[random.nextInt(chars.length)];
		}
		return couponName;
	}

	public String code = "";

	public String generateRandomCouponCode() {
		Random r = new Random();
		int RandomInt = r.nextInt(9999);
		String code = Integer.toString(RandomInt);
		System.out.println("code is " + (code));
		return code;
	}

	
	
}
