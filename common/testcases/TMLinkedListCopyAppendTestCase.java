import com.thinking.machines.util.*;
public class TMLinkedListCopyAppendTestCase
{
public static void main(String gg[])
{
TMLinkedList list1 = new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.add(50);

TMLinkedList list2 = new TMLinkedList();
list2.add(95);
list2.add(96);
list2.add(97);
list2.add(98);
list2.add(99);

TMLinkedList list3 = new TMLinkedList();
list3.insert(0,65);
list3.insert(0,5);

list1.appendTo(list2);
list3.appendFrom(list2);

for(int k=0;k<list2.size();k++)
{
System.out.println(list2.get(k));
}
System.out.print("&&&&&&&&&&&\n");
for(int k=0;k<list3.size();k++)
{
System.out.println(list3.get(k));
}
System.out.print("\n\n\n");

TMLinkedList list8 = new TMLinkedList();
list8.add(10);
list8.add(20);
list8.add(30);
list8.add(40);
list8.add(50);

TMLinkedList list9 = new TMLinkedList();
list9.add(95);
list9.add(96);
list9.add(97);
list9.add(98);
list9.add(99);

list8.copyTo(list9);
for(int k=0;k<list9.size();k++)
{
System.out.println(list9.get(k));
}
System.out.println("&&&&&&&&&&");
list8.copyFrom(list3);
for(int k=0;k<list8.size();k++)
{
System.out.println(list8.get(k));
}
}
}