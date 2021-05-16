mport java.awt.Point;  
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


String input=parseString(sc);
while(input.equals(""))
input=parseString(sc);

this.keyMatrix(matrix); 

}

private String[][] cipherMatrix(String key)
{
String[][] playfairMatrix=new String[5][5];
String keyString=key+"ABCDEFGHIKLMNOPQRSTUVWXYZ"; 

for(int i=0;i<5;i++)
for(int j=0;j<5;j++)

for(int k = 0; k < keyString.length(); k++)  
{  
boolean repeat = false;  
boolean used = false;  
for(int i = 0; i < 5; i++)  
{  
for(int j = 0; j < 5; j++)  
{  
if(playfairMatrix[i][j].equals("" + keyString.charAt(k)))  
{  
repeat = true;  
}  
else if(playfairMatrix[i][j].equals("") && !repeat && !used)  
{  
playfairMatrix[i][j] = "" + keyString.charAt(k);  
used = true;  
}  
}  
}  
}  
return playfairMatrix;  
}  

private String cipher(String in)
{
length =(int) in.length()/2+in.length()%2;

for(int i=0;i<(length-1);i++)
{
if(in.charAt(2 * i) == in.charAt(2 * i + 1))  
{  
in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();  
length = (int) in.length() / 2 + in.length() % 2;  
}  
}  