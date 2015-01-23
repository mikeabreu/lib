import java.util.Scanner;
import java.util.Random;

/**
 * Class CipherMain:
 * 
 * Program to test class CipherMain
 */
class CipherMain {
	/**
	 * main method for testing
	 */
	public static void main(String[] args) {
		// Declarations of variables
		char[] keyword = new char[7];

		// Declarations of objects
		Cipher matrix = new Cipher();
		Cipher newmatrix = new Cipher();

		// Create keyword students can research about Class Console
		// Console allows to type passwords and returns char[]
		keyword = "NEIUP2".toCharArray();
		Cipher.displayArrayChar(6, keyword);

		// Call encryption
		char[] ciphertext = matrix.encryption(keyword, newmatrix);
		System.out.println("\nAfter Encryption, ciphertext is: ");
		Cipher.displayArrayChar((6 * 6), ciphertext);

		// Call decryption
		char[] plaintext = matrix.decryption(keyword, ciphertext);
		System.out.println("\nAfter Decryption, plaintext is: ");
		Cipher.displayArrayChar(6 * 5, plaintext);

	}
}
