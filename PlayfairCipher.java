import java.awt.Point;  
import java.util.Scanner;  

public class PlayfairCipher  
{  

private int length = 0;  

private String [][] matrix;  
public static void main(String args[])  
{  
PlayfairCipher pf = new PlayfairCipher();  
}  

private PlayfairCipher()
{
System.out.print("Enter the key for Playfair Cipher:");
Scanner sc=new Scanner(System.in);
String key=parseString(sc);
while(key.equals(""))
key=parseString(sc);
matrix=this.cipherMatrix(key);
System.out.print("Enter the plaintext to be encipher: ");  

String input=parseString(sc);
while(input.equals(""))
input=parseString(sc);

String output = cipher(input); 
String decodedOutput = decode(output); 

this.keyMatrix(matrix); 
this.printResults(output,decodedOutput); 

}

