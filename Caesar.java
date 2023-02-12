import java.util.*;
/**
 * CYB507 Lab 1 Main class
 * 
 * Contains template to lab #1.
 * 
 * @author Michelle Lam
 * @version July 11, 2021
 */

public class Caesar {
	
	/**
	  * Main method of the program.
	  * @param args Unused.
	  */
	public static void main(String[] args) {
		String str = "Hello, world!";
		String hex = stringToHex(str);
		byte[] bytes = stringToBytes(str);
		System.out.println(str);
		System.out.println(hex);
		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i] + " ");
		}
		System.out.println();
		System.out.println(bytesToString(bytes));
		bytes = hexToBytes(hex);
		for (int i = 0; i < bytes.length; i++) {
			System.out.print(bytes[i] + " ");
		}
		System.out.println();
		System.out.println(bytesToHex(bytes));
		
		String ciphertext = "lzjwwjafykxgjlzwwdnwfcafykmfvwjlzwkcqkwnwfxgjlzwv"
				+ "osjxdgjvkafzsddkgxklgfwfafwxgjegjlsdewfvggewvlgvawgfwxgjlzw"
				+ "vsjcdgjvgfzakvsjclzjgfwaflzwdsfvgxegjvgjozwjwlzwkzsvgokdawg"
				+ "fwjafylgjmdwlzwesddgfwjafylgxafvlzwegfwjafylgtjafylzwesddsf"
				+ "vaflzwvsjcfwkktafvlzweaflzwdsfvgxegjvgjozwjwlzwkzsvgokdaw";
		System.out.println("Caesar's Shift broken!\nMessage: " +
				breakCaesarShift(ciphertext, findCaesarShift(ciphertext)));
	}
	
	/**
	 * Converts ASCII string to hexadecimal string.
	 * 	Example: "Hello, world!" should return "48656c6c6f2c20776f726c6421"
	 * @param s given ASCII string.
	 * @return equivalent hexadecimal string.
	 */
	public static String stringToHex(String s) {
		StringBuilder sb = new StringBuilder();
		char[] ch= s.toCharArray();
		for(char c: ch){
			String toHex = Integer.toHexString(c);
			sb.append(toHex);
		}
		return sb.toString();
	}
	
	/**
	 * Converts hexadecimal string to ASCII string.
	 * 	Example: "48656c6c6f2c20776f726c6421" should return  "Hello, world!"
	 * @param hex given hexadecimal string.
	 * @return equivalent ASCII string.
	 */
	public static String hexToString(String hex) {
		char[] ch = hex.toCharArray();
		String toString = "";
		for(int i=0; i<ch.length; i++){
			String s = ""+ch[i] + ""+ch[i+1];
			char c = (char)Integer.parseInt(s,16);
			toString += c;
		}
		return toString;
	}
	
	/**
	 * Converts hexadecimal string to array of bytes.
	 * 	Example: "48656c6c6f2c20776f726c6421" should return {72, 101, 108, 108,
	 * 		111, 44, 32, 119, 111, 114, 108, 100, 33}
	 * @param hex given hexadecimal string.
	 * @return equivalent array of bytes.
	 */
	public static byte[] hexToBytes(String hex) {
	   byte[] b= new byte[hex.length()/2];
	   for(int i =0;i<hex.length();i+=2){
		   b[i/2]=Integer.valueOf(hex.substring(i, i+2),16).byteValue();
	   }
	   return b;
	}
	
	/**
	 * Converts byte array to hexadecimal string.
	 * 	Example: {72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33}
	 * 		should return "48656c6c6f2c20776f726c6421"
	 * @param bytes given byte array.
	 * @return equivalent hexadecimal string.
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for(int i =0; i<bytes.length; i++){
			String hex = String.format("%02x", bytes[i]);
			sb.append(hex);
		}
		return sb.toString();
	}
	

	/**
	 * Converts ASCII string to byte array.
	 *	Example: "Hello, world!" should return {72, 101, 108, 108, 111, 44, 32,
	 *		119, 111, 114, 108, 100, 33}
	 * @param s given ASCII string.
	 * @return equivalent array of bytes.
	 */
	public static byte[] stringToBytes(String s) {
		byte[] b = s.getBytes();
		return b;
	}
		
	/**
	 * Converts byte array to ASCII string.
	 * 	Example: {72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33}
	 * 		should return "Hello, world!"
	 * @param bytes given byte array.
	 * @return equivalent ASCII string.
	 */
	public static String bytesToString(byte[] bytes) {
		String str = new String(bytes);
		return str;
	}
	
	/**
	* Breaks Caesar's Shift Cipher, given any shift parameter.
	* @param ciphertext message encrypted using the cipher.
	* @param shift shift of plain alphabet (0-25) to create cipher alphabet.
	* @return plaintext English message if used with proper shift parameter;
	*	empty string otherwise.
	*/
	public static String breakCaesarShift(String ciphertext, int shift) {
		char[] cipher = ciphertext.toCharArray();
		String plaintext = "";
		for (int i=0; i<cipher.length; i++){
			char c = cipher[i];
			if(c >='a' && c <= 'z'){
				c -= shift;
				if(c < 'a'){
					c = (char)(c-'a'+'z'+1);
				}
				plaintext += c;
			}
			else if(c >='A' && c <= 'Z'){
				c -= shift;
				if(c < 'A'){
					c = (char)(c-'A'+'Z'+1);
				}
				plaintext += c;
			}
			else{
				plaintext += c;
			}
		}
		return plaintext;
	}
	
	/**
	* Counts the number of occurrences of character 'e' in a string.
	* @param str string to be counted on.
	* @return the number of times 'e' occurs in the string.
	*/
	public static int countEs(String str) {
		int totalEs = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == 'e'){
				totalEs++;
			}
		}
		return totalEs;
	}
	
	/** 
	* Iterates over all 26 shift possibilities of Caesar's Shift Cipher to find
	*	a shift that yields between 12% and 14% of 'e' occurrences in the
	*	resulting plaintext decryption of ciphertext.
	* @param ciphertext encrypted message to find proper shift on.
	* @return the proper shift needed to break the cipher.
	*/
	public static int findCaesarShift(String ciphertext) {
		String alphabet = " abcdefghijklmnopqrstuvwxyz";
		int key =0;
		char[] ch=ciphertext.toCharArray();
		for(int i=1; i<26; i++){
			String plaintext = "";
			for(int j=0; j<ch.length; j++){
				int index = alphabet.indexOf(ch[j]);
				index = (index - i) % (26);
				if(index < 0){
					index = 26 + index;
				}
				plaintext += alphabet.charAt(index);
			}
			double proportion = (double) countEs(plaintext)/plaintext.length();
			if((proportion>= 0.12) && proportion <= 0.14){
				key=i;
				break;
			}
		}
		return key;
	}
	
}