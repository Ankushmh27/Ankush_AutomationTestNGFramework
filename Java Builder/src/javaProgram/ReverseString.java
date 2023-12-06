package javaProgram;

public class ReverseString 
{
	public static void main(String[] args) {
		String str= "Ankush";
		String reverse =" ";
		char ch;
		System.out.println("Original word: "+str);
		for (int i=0; i<str.length(); i++)
		{
			ch= str.charAt(i); //extracts each character
			reverse= ch+reverse; //adds each character in front of the existing string
		}
		System.out.println("Reversed word: "+ reverse);
	}
}

