import com.thinking.machines.util.*;
public class lambdaExpressionTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
/*
 *TMIterator iterator1=list1.iterator();
 *while(iterator1.hasNext()) System.out.println(iterator1.next());
 */

list1.forEach((m)->{System.out.println(m);});
}
}

