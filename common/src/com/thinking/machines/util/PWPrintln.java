package com.thinking.machines.util;
import java.io.*;
public class PWPrintln
{
public static void main(String gg[])
{
String fileName = gg[0];
File file = new File(fileName);
if(file.exists()==false) 
{
System.out.println("File ("+fileName+") does not exist.");
return;
}
try
{
RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");

File tmpFile = new File("tmp.tmp");
if(tmpFile.exists()) tmpFile.delete();
RandomAccessFile tmpRandomAccessFile = new RandomAccessFile(tmpFile,"rw");

String line;
while(randomAccessFile.getFilePointer() < randomAccessFile.length())
{
line = randomAccessFile.readLine();
line = line.replaceAll("\"","\\\\\""); //assign it back to itself?
tmpRandomAccessFile.writeBytes("pw.println(\""+line+"\");" + "\r\n");
}
System.out.println(fileName+ " successfully wrapped in pw.println and saved in tmp.tmp");

}catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}