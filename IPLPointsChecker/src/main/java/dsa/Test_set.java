package dsa;

import java.util.HashSet;
import java.util.Set;

public class Test_set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		retrunDup("My name is Pranav Vashistha" , "abcdef");

	}
	public static void retrunDup(String str1 , String str2) {
		
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		
		Set<Character> set = new HashSet <> ();
		
		for (char c : str1.toCharArray()) {
			set.add(c) ;
		}
		
		for (char c : str2.toCharArray()) {
			if(set.contains(c)) {
				System.out.println(c);
			}
		}
		
	}

}
