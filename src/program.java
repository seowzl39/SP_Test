import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	
	static Map<Character,ArrayList<String>> keypad = new HashMap<Character,ArrayList<String>>();

	public static void main(String[] args) {
		
		//get user input
		System.out.print("Input: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (!checkForInteger(input))
		{
			char[] inputChar = input.toCharArray();
			
			//question 1
			int KeyPressedResult = TotalNumOfKeyPressed(inputChar);
			System.out.println("Output: " + KeyPressedResult);			
			
			//question 2
			String NumPressedResult = NumPressed(inputChar);
			System.out.println("Output: " + NumPressedResult);
			
		} else {		
			initializeKeypadInHashMap();
			char[] inputChar = input.toCharArray();
			
			//question 3
			if(inputChar.length == 2) {
				ArrayList<String> RecommendWordResult = RecommendWord(inputChar);
				System.out.println("Output: " + RecommendWordResult);
			}
				
		}

	}

	private static boolean checkForInteger(String inputStr)
	{
		try {
			
			Integer.parseInt(inputStr);
		
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;					
	}
	
	private static int TotalNumOfKeyPressed(char[] inputChar) {
		 
		ArrayList<Character> one = new ArrayList<Character>(Arrays.asList('a','d','g','j','m','p','t','w'));
		ArrayList<Character> two = new ArrayList<Character>(Arrays.asList('b','e','h','k','n','q','u','x'));
		ArrayList<Character> three = new ArrayList<Character>(Arrays.asList('c','f','i','l','o','r','v','y'));
		ArrayList<Character> four = new ArrayList<Character>(Arrays.asList('s','z'));
		int count = 0;
		
		for (char eachChar : inputChar)
		{
			if (one.indexOf(eachChar)!=-1)
				count +=1;
			else if (two.indexOf(eachChar)!=-1)	
				count +=2;
			else if (three.indexOf(eachChar)!=-1)	
				count +=3;
			else if (four.indexOf(eachChar)!=-1)	
				count +=4;
				
		}
	
		return count;
	}
	
	private static String NumPressed(char[] inputChar) {
		
		String result = "";
		
		for (char eachChar : inputChar)
			result += getNumPressed(eachChar);
		
		return result;
	}

	private static int getNumPressed(char eachChar) {
		
		switch(Character.toLowerCase(eachChar)){
			case 'a': case 'b': case 'c':
			return 2;
			case 'd': case 'e': case 'f':
			return 3;	
			case 'g': case 'h': case 'i':
			return 4;	
			case 'j': case 'k': case 'l':
			return 5;	
			case 'm': case 'n': case 'o':
			return 6;		
			case 'p': case 'q': case 'r': case 's':
			return 7;	
			case 't': case 'u': case 'v':
			return 8;		
			case 'w': case 'x': case 'y': case 'z':
			return 9;				
		}
		return -1;
		
	}
	
	private static ArrayList<String> RecommendWord(char[] inputChar) {
		
		ArrayList<String> result = new ArrayList<String>();
		for (int i=0; i<inputChar.length;i++)
		{
			ArrayList<String> a = keypad.get(inputChar[i]);
			for (int j=i+1; j<inputChar.length;j++) {
				ArrayList<String> b = keypad.get(inputChar[j]);
				for (String resultFirst : a) {
					for (String resultSecond : b) {
						result.add(resultFirst + resultSecond);
					}
				}
			}
				
		}
		return result;
	}

	private static void initializeKeypadInHashMap() {
		keypad.put('0', new ArrayList<String>(Arrays.asList("")));
		keypad.put('1', new ArrayList<String>(Arrays.asList("")));
		keypad.put('2', new ArrayList<String>(Arrays.asList("a","b","c")));
		keypad.put('3', new ArrayList<String>(Arrays.asList("d","e","f")));
		keypad.put('4', new ArrayList<String>(Arrays.asList("g","h","i")));
		keypad.put('5', new ArrayList<String>(Arrays.asList("j","k","l")));
		keypad.put('6', new ArrayList<String>(Arrays.asList("m","n","o")));
		keypad.put('7', new ArrayList<String>(Arrays.asList("p","q","r","s")));
		keypad.put('8', new ArrayList<String>(Arrays.asList("t","u","v")));
		keypad.put('9', new ArrayList<String>(Arrays.asList("w","x","y","z")));
	}

}
