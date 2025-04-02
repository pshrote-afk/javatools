import com.thinking.machines.util.*;
class KeyboardTestCase
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String a;
System.out.print("Enter String:");
a=k.getString();
String b=k.getString("Enter another string:");
char c=k.getCharacter("Enter [M/F]: ");
long d=k.getLong("Enter long value:");
int e=k.getInt("Enter int value:");
short f=k.getShort("Enter short value:");
byte g=k.getByte("Enter byte value:");
double h=k.getDouble("Enter double value:");
float i=k.getFloat("Enter float value:");
boolean j=k.getBoolean("Enter boolean type value:");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
System.out.println(h);
System.out.println(i);
System.out.println(j);

}
}