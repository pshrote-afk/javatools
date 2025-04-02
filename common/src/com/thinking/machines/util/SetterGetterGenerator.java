package com.thinking.machines.util;
import java.lang.reflect.*;
import java.io.*;
public class SetterGetterGenerator
{
public static void main(String gg[])
{
if(gg.length==0)
{
System.out.println("usage: java -classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name");
return;
}
String className=gg[0];
try
{
Class c=Class.forName(className);
Field fields[]=c.getDeclaredFields();
Field field;
TMList<String> list=new TMArrayList<String>();
String setterName;
String getterName;
String tmp;
String fieldName;
String line;
Class fieldType;
for(int e=0;e<fields.length;e++)
{
field=fields[e];
fieldName=field.getName();
fieldType=field.getType();

if(fieldName.charAt(0)>=97 && fieldName.charAt(0)<=122)
{
tmp=fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
}
else
{
tmp=fieldName;
}
setterName="set"+tmp;
getterName="get"+tmp;
//for setter
line="public void " + setterName + "(" + fieldType.getName() + " " + fieldName + ")";
list.add(line);
list.add("{");
line="this." + fieldName + "=" + fieldName + ";";
list.add(line);
list.add("}");
//for getter
line="public " + fieldType.getName() + " " + getterName + "()";
list.add(line);
list.add("{");
line="return this." + fieldName + ";";
list.add(line);
list.add("}");
}
/*
File file = new File("tmp.tmp");
if(file.exists()) file.delete();

RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
TMIterator<String> iterator = list.iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line + "\r\n");
}
randomAccessFile.close();
System.out.println("setters/getters for: " + c.getName() + " generated in file named as 'tmp.tmp'");
*/
//now to write default constructor
if(gg.length==1 || !(gg.length==2 && gg[1].equalsIgnoreCase("constructor=false") ))
{
String stringFieldType;
line = "public " + c.getSimpleName() + "()";
list.add(line);
list.add("{");

for(int e=0;e<fields.length;e++) 
{
field=fields[e];
stringFieldType=field.getType().toString();
if(stringFieldType.equalsIgnoreCase("int"))
{
line = "this." + field.getName() + "=0;";
} else
if(stringFieldType.equalsIgnoreCase("long"))
{
line = "this." + field.getName() + "=0;";
} else
if(stringFieldType.equalsIgnoreCase("short"))
{
line = "this." + field.getName() + "=0;";
} else
if(stringFieldType.equalsIgnoreCase("byte"))
{
line = "this." + field.getName() + "=0;";
} else
if(stringFieldType.equalsIgnoreCase("double"))
{
line = "this." + field.getName() + "=0;";
} else
if(stringFieldType.equalsIgnoreCase("float"))
{
line = "this." + field.getName() + "=0;";
} else
if(stringFieldType.equalsIgnoreCase("char"))
{
line = "this." + field.getName() + "=' '" + ";";
} else
if(stringFieldType.equalsIgnoreCase("boolean"))
{
line = "this." + field.getName() + "=false;";
}
else	//complex data type, therefore =null
{
line = "this." + field.getName() + "=null;";
}
list.add(line);
}
list.add("}");
//now add to file

File file = new File("tmp.tmp");
if(file.exists()) file.delete();
RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
TMIterator<String> iterator = list.iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line + "\r\n");
}
randomAccessFile.close();
System.out.println("Setter/Getter, Default Constructor for: '" + c.getName() + "' generated in file named tmp.tmp");
}
else	//opted out of default constructor creation. therefore only write setter/getter into file "tmp.tmp"
{
File file = new File("tmp.tmp");
if(file.exists()) file.delete();
RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
TMIterator<String> iterator = list.iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line + "\r\n");
}
randomAccessFile.close();
System.out.println("Setter/Getter for: '" + c.getName() + "' generated in file named tmp.tmp. Default constructor not generated as per request.");
}


}catch(ClassNotFoundException classNotFoundException)
{
System.out.println("unable to load class, classpath missing");
}
catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}//end of main
}//end of class