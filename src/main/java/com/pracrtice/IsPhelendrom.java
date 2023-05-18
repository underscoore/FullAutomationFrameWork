package com.pracrtice;

public class IsPhelendrom {
	public static void main(String[] args) {
		String str = "LeVeL";

		str = str.toLowerCase();
		boolean result = isPhelendrom(str);
		System.out.println(result);
	}

	private static boolean isPhelendrom(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		if (str.equals(rev)) {

			return true;
		}
		return false;
	}
}
