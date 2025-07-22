package dsa;

import java.util.*;

public class SortStringBy {

	public static void main(String args[]) {
		String str = "my name is Pranav Vashistha and i a chill guy , just a guy";

		String[] strArray = str.split(" ");

		Arrays.sort(strArray);

		for (int i = 1; i < 10; i++) {
			for (String temp : strArray) {
				if (i == temp.length()) {
					System.out.println(temp);
				}
			}

		}

	}

}
