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

System.out.print("Enter the key for playfair cipher: ");  
Scanner sc = new Scanner(System.in);  
String key = parseString(sc);  
while(key.equals(""))  
key = parseString(sc);  
matrix = this.cipherMatrix(key);  

System.out.print("Enter the plaintext to be encipher: ");  
  
String input = parseString(sc);  
while(input.equals(""))  
input = parseString(sc);  

String output = cipher(input);  
String decodedOutput = decode(output);  

this.keyMatrix(matrix);  
this.printResults(output,decodedOutput);  
}  

private String parseString(Scanner sc)  
{  
String parse = sc.nextLine();  
 
parse = parse.toUpperCase();  

parse = parse.replaceAll("[^A-Z]", "");  

parse = parse.replace("J", "I");  
return parse;  
}  

private String[][] cipherMatrix(String key)  
{  
 
String[][] playfairMatrix = new String[5][5];  
String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";  

for(int i = 0; i < 5; i++)  
for(int j = 0; j < 5; j++)  
playfairMatrix[i][j] = "";  
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
length = (int) in.length() / 2 + in.length() % 2;  

for(int i = 0; i < (length - 1); i++)  
{  
if(in.charAt(2 * i) == in.charAt(2 * i + 1))  
{  
in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();  
length = (int) in.length() / 2 + in.length() % 2;  
}  
}  

String[] digraph = new String[length];  

for(int j = 0; j < length ; j++)  
{  

if(j == (length - 1) && in.length() / 2 == (length - 1))  

in = in + "X";  
digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);  
}  

String out = "";  
String[] encDigraphs = new String[length];  
encDigraphs = encodeDigraph(digraph);  
for(int k = 0; k < length; k++)  
out = out + encDigraphs[k];  
return out;  
}  

private String[] encodeDigraph(String di[])  
{  
String[] encipher = new String[length];  
for(int i = 0; i < length; i++)  
{  
char a = di[i].charAt(0);  
char b = di[i].charAt(1);  
int row1 = (int) getPoint(a).getX();  
int row2 = (int) getPoint(b).getX();  
int column1 = (int) getPoint(a).getY();  
int column2 = (int) getPoint(b).getY();  

if(row1 == row2)  
{  
column1 = (column1 + 1) % 5;  
column2 = (column2 + 1) % 5;  
}  

else if(column1 == column2)  
{  
row1 = (row1 + 1) % 5;  
row2 = (row2 + 1) % 5;  
}  

else  
{  
int temp = column1;  
column1 = column2;  
column2 = temp;  
}  

encipher[i] = matrix[row1][column1] + "" + matrix[row2][column2];  
}  
return encipher;  
}  

private String decode(String out)  
{  
String decoded = "";  
for(int i = 0; i < out.length() / 2; i++)  
{  
char a = out.charAt(2*i);  
char b = out.charAt(2*i+1);  
int row1 = (int) getPoint(a).getX();  
int row2 = (int) getPoint(b).getX();  
int column1 = (int) getPoint(a).getY();  
int column2 = (int) getPoint(b).getY();  
if(row1 == row2)  
{  
column1 = (column1 -1 +5) % 5;  
column2 = (column2 -1 +5) % 5;  
}  
else if(column1 == column2)  
{  
row1 = (row1 -1 +5) % 5;  
row2 = (row2 -1 +5) % 5;  
}  
else  
{  

int temp = column1;  
column1 = column2;  
column2 = temp;  
}  
decoded = decoded + matrix[row1][column1] + matrix[row2][column2];  
}  

return decoded;  
}  

private Point getPoint(char c)  
{  
Point pt = new Point(0,0);  
for(int i = 0; i < 5; i++)  
for(int j = 0; j < 5; j++)  
if(c == matrix[i][j].charAt(0))  
pt = new Point(i,j);  
return pt;  
}  

private void keyMatrix(String[][] printMatrix)  
{  
System.out.println("Playfair Cipher Key Matrix: ");  
System.out.println();  

for(int i = 0; i < 5; i++)  
{  
  
for(int j = 0; j < 5; j++)  
{  

System.out.print(printMatrix[i][j]+" ");  
}  
System.out.println();  
}  
System.out.println();  
}    

private void printResults(String encipher, String dec)  
{  
System.out.print("Encrypted Message: ");  

System.out.println(encipher);  
System.out.println();  
System.out.print("Decrypted Message: ");  

System.out.println(dec);  
}  
}  
