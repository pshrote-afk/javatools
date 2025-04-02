package com.thinking.machines.util;
import java.io.*;
public class Keyboard
{
private BufferedReader bufferedReader;
public Keyboard()
{
bufferedReader=new BufferedReader(new InputStreamReader(System.in));
}
//string
public String getString()
{
String str;
try
{
str=bufferedReader.readLine();
}catch(IOException ioException)
{
str="";
}
return str;
}
public String getString(String message)
{
System.out.print(message);
return getString();
}
//character
public char getCharacter()
{
return getString().charAt(0);
}
public char getCharacter(String message)
{
System.out.print(message);
return getCharacter();
}
//long
public long getLong()
{
long x;
try
{
x=Long.parseLong(getString());		//String converted to Long, and auto unboxed using longValue() into long primitive data type
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public long getLong(String message)
{
System.out.print(message);
return getLong();
}
//int
public int getInt()
{
int x;
try
{
x=Integer.parseInt(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public int getInt(String message)
{
System.out.print(message);
return getInt();
}
//short
public short getShort()
{
short x;
try
{
x=Short.parseShort(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public short getShort(String message)
{
System.out.print(message);
return getShort();
}
//byte
public byte getByte()
{
byte x;
try
{
x=Byte.parseByte(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public byte getByte(String message)
{
System.out.print(message);
return getByte();
}
//double
public double getDouble()
{
double x;
try
{
x=Double.parseDouble(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public double getDouble(String message)
{
System.out.print(message);
return getDouble();
}
//float
public float getFloat()
{
float x;
try
{
x=Float.parseFloat(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public float getFloat(String message)
{
System.out.print(message);
return getFloat();
}
//boolean
public boolean getBoolean()
{
boolean x;
try
{
x=Boolean.parseBoolean(getString());
}catch(NumberFormatException numberFormatException)
{
x=false;
}
return x;
}
public boolean getBoolean(String message)
{
System.out.print(message);
return getBoolean();
}
}