package _00_Intro_To_ArrayLists;

import java.util.ArrayList;
import java.util.Iterator;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
    	char[] eCheck;
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
ArrayList<String> list = new ArrayList<>();
        // 2. Add five Strings to your list
list.add("John");
list.add("Joe");
list.add("Lan");
list.add("Tanner");
list.add("Pic");
        // 3. Print all the Strings using a standard for-loop
for (int i = 0; i < list.size(); i++) {
	System.out.println(list.get(i)); 
}
        // 4. Print all the Strings using a for-each loop
for (String string : list) {
	System.out.println(string);
}
        // 5. Print only the even numbered elements in the list.
System.out.println("Even numbers");
for (int i = 0; i < list.size(); i+=2) {
	System.out.println(list.get(i));
}
        // 6. Print all the Strings in reverse order.
System.out.println("Reverse numbers");
for (int i = list.size() -1; -1 < i; i-=1) {
	System.out.println(list.get(i));
}
        // 7. Print only the Strings that have the letter 'e' in them.
System.out.println("Names with E");
for (int i = 0; i < list.size(); i++) {
	eCheck = list.get(i).toCharArray();
	
	for (int j = 0; j < eCheck.length; j++) {
		if (eCheck[j] == 'e') {
			System.out.println(list.get(i)); 
		}
	}
}
    }
    }

