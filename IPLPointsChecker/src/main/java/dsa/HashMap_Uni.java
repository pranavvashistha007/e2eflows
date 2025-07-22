package dsa;

import java.util.HashMap;
import java.util.Map;

public class HashMap_Uni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//  e		p		r		t		y
		uni("My name is Pranav Vashistha");
		
	}
	public static void uni(String input) {
		input=input.toLowerCase();
		Map<Character,Integer> map = new HashMap <>();
		
		for(char c : input.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);				
			}
			else map.put(c, 1);
		}
		
		for(Map.Entry<Character,Integer> entery : map.entrySet()  ) {
			if(entery.getValue()==1) {
				System.out.println(entery.getKey());
			}
		}
		
	}

}
