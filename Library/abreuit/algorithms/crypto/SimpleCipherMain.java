package abreuit.algorithms.crypto;

/**
 * Class CipherMain:
 * 
 * Program to test class CipherMain
 */
class SimpleCipherMain {
	/**
	 * main method for testing
	 */
	public static void main(String[] args) {
		// Declarations of variables
		char[] keyword = new char[7];

		// Declarations of objects
		SimpleCipher matrix = new SimpleCipher();
		SimpleCipher newmatrix = new SimpleCipher();

		// Create keyword students can research about Class Console
		// Console allows to type passwords and returns char[]
		keyword = "NEIUP2".toCharArray();
		SimpleCipher.displayArrayChar(6, keyword);

		// Call encryption
		char[] ciphertext = matrix.encryption(keyword, newmatrix);
		System.out.println("\nAfter Encryption, ciphertext is: ");
		SimpleCipher.displayArrayChar((6 * 6), ciphertext);

		// Call decryption
		char[] plaintext = matrix.decryption(keyword, ciphertext);
		System.out.println("\nAfter Decryption, plaintext is: ");
		SimpleCipher.displayArrayChar(6 * 5, plaintext);

	}
}
