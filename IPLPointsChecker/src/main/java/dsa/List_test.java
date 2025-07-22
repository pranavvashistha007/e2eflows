package dsa;

import java.util.ArrayList;

public class List_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		//  y		e		p		r		t
		uni("My name is Pranav Vashistha");

	}
	
	public static void uni(String input) {
		input=input.toLowerCase();
		
		//ArrayList<Character> list = new ArrayList <>() ;
		
		for (int i =0 ; i <input.length() ; i ++ ) {
			char c = input.charAt(i) ;
			boolean check = true ;
			
			for(int j=0 ;j<input.length() ;j ++ ) {
				
				if (i==j) continue ;
				
				if (c==input.charAt(j)) {
					check = false ;
					break ;
				}
				
			}
			if (check) {
				System.out.println(c);
			}
			
		}
	}

}
