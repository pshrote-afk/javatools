import com.thinking.machines.util.*;
public class TMLinkedListRemoveAtTestCase
{
public static void main(String mm[])
{
TMLinkedList list1 = new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
TMArrayList list2=new TMArrayList();
list2.add(10);
list2.add(20);
list2.add(30);
list2.add(40);

list1.removeAt(0);
list2.removeAt(0);
list1.removeAt(1);
list2.removeAt(1);
list1.removeAt(1);
list2.removeAt(1);


System.out.println("Removed elements");
System.out.println("Iterating Linked List");


TMIterator iterator1=list1.iterator();
int x;
while(iterator1.hasNext())
{
x=iterator1.next();
System.out.println(x);
}
System.out.println("Iterating Array List");
TMIterator iterator2=list2.iterator();
while(iterator2.hasNext())
{
x=iterator2.next();
System.out.println(x);
}

}
}