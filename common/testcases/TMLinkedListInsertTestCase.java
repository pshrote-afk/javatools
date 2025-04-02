import com.thinking.machines.util.*;
class TMLinkedListInsertTestCase
{
public static void main(String gg[])
{
TMLinkedList list1 = new TMLinkedList();
list1.add(60);
list1.add(70);
list1.add(80);
list1.add(90);
list1.insert(4,100);
list1.insert(5,110);
for(int k=0;k<list1.size();k++)
{
int tmpData = list1.get(k);
System.out.println(tmpData);
}
list1.insert(0,50);
list1.insert(5,95);
System.out.println("after adding two more");
for(int k=0;k<list1.size();k++)
{
int tmpData = list1.get(k);
System.out.println(tmpData);
}
System.out.println("after inserting 5 more");
list1.add(8,250); //add has same code as insert
list1.add(8,200);
list1.add(8,150);
list1.add(1,55);
list1.add(0,5);
for(int k=0;k<list1.size();k++)
{
int tmpData = list1.get(k);
System.out.println(tmpData);
}
list1.update(0,3);
list1.update(12,300);
list1.update(6,5050);
for(int k=0;k<list1.size();k++)
{
int tmpData = list1.get(k);
System.out.println(tmpData);
}
}
}