import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		//get user input
		System.out.print("Input: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (!checkForInteger(input))
		{
			char[] inputChar = input.toCharArray();
			
			//question 1
			String KeyPressedResult = TotalNumOfKeyPressed(inputChar);
			System.out.println("Output: " + KeyPressedResult);			
			
			//question 2
			String NumPressedResult = TotalNumPressed(inputChar);
			System.out.println("Output: " + NumPressedResult);
			
		} else {		
		
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
	
	private static String TotalNumOfKeyPressed(char[] inputChar) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static String TotalNumPressed(char[] inputChar) {
		
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

}
