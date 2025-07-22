package dsa;

import java.util.HashMap;
import java.util.Map;

public class uniqueChar {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		uniChar("My name is Pranav Vashistha");

	}
	
	public static void uniChar(String input) {
		
		input = input.toUpperCase();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(char c : input.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		
		for(Map.Entry<Character,Integer> c : map.entrySet()) {
			if(c.getValue()==1) {
				System.out.println(c.getKey());
			}
			System.out.println(c);
		}
		
		//return "";
	}

}
