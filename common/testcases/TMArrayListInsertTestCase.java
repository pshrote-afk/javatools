import com.thinking.machines.util.*;
class TMArrayListInsertTestCase
{
public static void main(String gg[])
{
TMArrayList list1 = new TMArrayList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.add(50);

for(int k=0;k<list1.size();k++)
{
System.out.println(list1.get(k));
}
System.out.println("&&&&&&&&&");
list1.update(0,60);
list1.update(1,70);
list1.update(3,80);
for(int k=0;k<list1.size();k++)
{
System.out.println(list1.get(k));
}
}
}