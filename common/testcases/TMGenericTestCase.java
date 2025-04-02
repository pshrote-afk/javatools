import com.thinking.machines.util.Keyboard;
import com.thinking.machines.util.*;
public class TMGenericTestCase
{
public static void main(String gg[])
{
TMArrayList<Integer> obj1=new TMArrayList<Integer>();
obj1.add(10);
obj1.add(20);
obj1.add(30);
obj1.add(40);
obj1.forEach((m)->{
System.out.println(m);
});

TMLinkedList<String> list2 = new TMLinkedList<String>();
list2.add("Ujjain");
list2.add("Goa");
list2.add("Ahmedabad");
list2.add("Thiruvananthapuram");
list2.forEach((j)->{
System.out.println("City: " + j);
});
}
}