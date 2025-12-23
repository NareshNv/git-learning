package browserInitalize;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class staticLearn extends abstractClass implements interfaceEx {

	public static void main(String[] args) {

		/*
		 * StringBuffer stbf = new StringBuffer("Naresh"); StringBuffer reverse =
		 * stbf.reverse();
		 * 
		 * // System.out.println("Reverse a String:" + reverse);
		 * 
		 * StringBuilder d = new StringBuilder("hseraN"); //
		 * System.out.println(d.reverse());
		 * 
		 * 
		 * //reverse string of arrays String[] name = { "name", "aim", "stop" };
		 * 
		 * List<String> v = Arrays.asList(name); Collections.reverse(v);
		 * System.out.println(v);
		 * 
		 * for (String str : name) { String rev= new
		 * StringBuffer(str).reverse().toString(); System.out.println(rev); }
		 */
	 
		//Remove dup form integer arrays
		
		int[] arr = {2,3,4,5,4,3,2,6,7,8};
		LinkedHashSet <Integer> nodup = new LinkedHashSet<Integer>();
		
		for(int i=0; i<arr.length;i++) {
			nodup.add(arr[i]);
			System.out.println(nodup);
			
		}
		
		}

}
