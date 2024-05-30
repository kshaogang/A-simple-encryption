import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Encryption {
	
	private ArrayList<Character> List;
	private ArrayList<Character> Shuffledlist;
	private char character;
	private Scanner scanner;
	private char[] Letter;
	
	Encryption(){
		scanner = new Scanner(System.in);
		List = new ArrayList();
		Shuffledlist = new ArrayList();
		
		NewKey();
		Communicate();
	}
	
	private void Communicate() {
		while(true) {
		System.out.println("---------------------------------");
		System.out.println("Hello,please enter your choose:");
		System.out.println("(N)ewKey,(G)etkey,(E)ncrypt,(D)ecrypt,(Q)uit");
		char response = Character.toUpperCase(scanner.nextLine().charAt(0));
		
		switch(response) {
		case 'N':
			NewKey();
			break;
		case 'G':
			GetKey();
			break;
		case 'E':
			Encrypt();
			break;
		case 'D':
			Decrypt();
			break;
		case 'Q':
			Quit();
			break;
		default:
			System.out.println("Not a value answer :(");
			}
		}
	}
	
	private void NewKey() {
		character = ' ';
		List.clear();
		Shuffledlist.clear();
		
		for(int i = 32;i < 127;i++)
		{
			List.add(Character.valueOf(character));
			character++;
		}
		
		Shuffledlist = new ArrayList(List);
		Collections.shuffle(Shuffledlist);
		
		System.out.println("A new key has been generated.");
	}
	private void GetKey() {
		System.out.println("Key: ");
		for (char x:List) {
			System.out.print(x);
		}
		System.out.println();
		for (char x:Shuffledlist) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void Encrypt() {
		System.out.println("please enter the message you want to encrypt:");
		String message = scanner.nextLine();
		Letter = message.toCharArray();
		
		
		
		for(int i = 0;i < Letter.length;i++) {
			for(int j = 0;j < List.size();j ++) {
				if(Letter[i] == List.get(j)) {
					Letter[i] = Shuffledlist.get(j);
					break;
				}
			}
		}
		
		for(char x:Letter) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void Decrypt() {
		System.out.println("please enter the message you want to decrypt:");
		String message = scanner.nextLine();
		Letter = message.toCharArray();
		
		for(int i = 0;i < Letter.length;i++) {
			for(int j = 0;j < Shuffledlist.size();j ++) {
				if(Letter[i] == Shuffledlist.get(j)) {
					Letter[i] = List.get(j);
					break;
				}
			}
		}
		
		for(char x:Letter) {
			System.out.print(x);
		}
		System.out.println();
	}
	private void Quit() {
		System.out.println("Have a nice day.");
		System.exit(0);
	}
	
}
