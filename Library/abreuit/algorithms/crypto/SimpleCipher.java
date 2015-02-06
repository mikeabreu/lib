package abreuit.algorithms.crypto;
import java.util.Scanner;
import java.util.Random;

/**
 * Class Cipher:
 * 
 * Template for Cipher
 */
class SimpleCipher {
	/**
	 * Attributes
	 */
	private char[][] Table = new char[5][6];
	// added an attribute to decrypt message
	private char[] shuffleKey = new char[6];

	/**
	 * Constructor (could be one of more)
	 */
	SimpleCipher() {

		int i, j;

		for (i = 0; i < 5; i = i + 1) {
			for (j = 0; j < 6; j = j + 1) {
				Table[i][j] = 'x';
			}
		}

	}

	/**
	 * Compute decryption
	 */
	public char[] decryption(char[] key, char[] ciphertext) {

		// Need extra variables and objects
		SimpleCipher cipherTable = new SimpleCipher();
		SimpleCipher ordercipherTable = new SimpleCipher();
		char[] plaintext = new char[5 * 6];
		Boolean temp = true;
		int[] keyIndex = new int[6];
		int i, j, k;

		// You need to obtain the shuffle keyword from the ciphertext
		// We assume the shuffle keyword is at the end of the ciphertext
		// grab shuffle keyword
		for (j = 0; j < 6; j = j + 1) {
			shuffleKey[j] = ciphertext[30 + j];
		}

		// Once you have shuffle keyword you need to create from the
		// ciphertext a table that will be use to decrypt message
		// transform ciphertext to a table form
		k = 0;
		for (i = 0; i < 5; i = i + 1) {
			for (j = 0; j < 6; j = j + 1) {
				cipherTable.setLetter(i, j, ciphertext[k]);
				k = k + 1;
			}
		}

		// find order to correctly decrypt message by creating
		// an index array that has order of columns
		for (i = 0; i < 6; i = i + 1) {
			temp = true;
			for (j = 0; (j < 6 && temp == true); j = j + 1) {
				if (key[j] == shuffleKey[i]) {
					keyIndex[i] = j;
					temp = false;
				}
			}
		}

		// reorder ciphertext according to keyIndex
		for (i = 0; i < 6; i = i + 1) {
			for (j = 0; j < 5; j = j + 1) {
				ordercipherTable.setLetter(j, keyIndex[i],
						cipherTable.getLetter(j, i));
			}
		}

		// copy plaintext from order ciphertext
		k = 0;
		for (i = 0; i < 5; i = i + 1) {
			for (j = 0; j < 6; j = j + 1) {
				plaintext[k] = ordercipherTable.getLetter(i, j);
				k = k + 1;
			}
		}

		return (plaintext);
	}

	/**
	 * Compute encryption
	 */
	public char[] encryption(char[] key, SimpleCipher newTable) {

		char[] emessage = new char[6 * 6];
		int[] newkeyIndex = new int[6];
		int i, j, k;

		// set message to table
		setAttribute();

		// shuffle keyword
		newkeyIndex = shuffle(key);

		// change columns according to shuffle keyword
		for (i = 0; i < 6; i = i + 1) {
			for (j = 0; j < 5; j = j + 1) {
				newTable.setLetter(j, i, Table[j][newkeyIndex[i]]);
			}
		}

		// check encryption process
		// displayTable();
		// System.out.println("new table ");
		// displayShuffleKeyword(6,key,newkeyIndex);
		// newTable.displayTable();

		// copy table to encrypted message
		k = 0;
		for (i = 0; i < 5; i = i + 1) {
			for (j = 0; j < 6; j = j + 1) {
				emessage[k] = newTable.getLetter(i, j);
				k = k + 1;
			}

		}

		// need to add shuffle key at the end of cipher text
		for (j = 0; j < 6; j = j + 1) {
			emessage[30 + j] = key[newkeyIndex[j]];
		}

		return (emessage);
	}

	/**
	 * Set attributes
	 */
	public int setAttribute() {
		int i, j, k;

		Scanner input = new Scanner(System.in);
		char[] message;

		System.out.println("type message");
		String inputMessage = input.next();
		message = inputMessage.toCharArray();

		k = 0;
		Boolean temp = (k != inputMessage.length());
		for (i = 0; (i < 5 && temp == true); i = i + 1) {
			for (j = 0; (j < 6 && temp == true); j = j + 1) {
				if (message[k] != '\0') {
					Table[i][j] = message[k];
					k = k + 1;
					temp = (k != inputMessage.length());
				}
			}
		}
		input.close();
		return (k);
	}

	/**
	 * Get a single value
	 */
	public char getLetter(int indexI, int indexJ) {
		return (Table[indexI][indexJ]);
	}

	/**
	 * Set a single value
	 */
	public void setLetter(int indexI, int indexJ, char letter) {
		Table[indexI][indexJ] = letter;
	}

	/**
	 * Display Shuffle keyword private
	 */
	@SuppressWarnings("unused")
	private void displayShuffleKeyword(int size, char[] key, int[] indexArray) {
		int i;
		for (i = 0; i < size; i = i + 1) {
			System.out.print(key[indexArray[i]]);
		}
		System.out.println();
	}

	/**
	 * Display array of char
	 */
	public static void displayArrayChar(int size, char[] message) {
		int i;
		for (i = 0; i < size; i = i + 1) {
			System.out.print(message[i]);
		}
		System.out.println();
	}

	/**
	 * Display array of int
	 */
	public static void displayArrayInt(int size, int[] message) {
		int i;
		for (i = 0; i < size; i = i + 1) {
			System.out.print(message[i]);
		}
		System.out.println();
	}

	/**
	 * Compute Shuffle Index of Keyword
	 */
	private int[] shuffle(char[] key) {
		int n = 6; // keyword length
		int[] shuffleIndex = new int[n];

		Random random = new Random();
		int shift = random.nextInt();

		for (int i = 0; i < n; i = i + 1) {
			shuffleIndex[i] = (Math.abs((n - shift + i)) % n);
		}

		return (shuffleIndex);
	}

	/**
	 * Method that prints out all attributes by row
	 */
	@SuppressWarnings("unused")
	private void displayTable() {
		int i, j;

		for (i = 0; i < 5; i = i + 1) {
			for (j = 0; j < 6; j = j + 1) {
				System.out.print(Table[i][j]);
			}
			System.out.println(" ");
		}

	}

	/**
	 * Method that prints out all attributes by row
	 */
	@SuppressWarnings("unused")
	private void displayTable2() {
		int i, j;

		for (i = 0; i < 6; i = i + 1) {
			for (j = 0; j < 5; j = j + 1) {
				System.out.print(Table[j][i]);
			}
			System.out.println(" ");
		}

	}

}
