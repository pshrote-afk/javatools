package com.thinking.machines.util;
public class TMLinkedList implements TMList
{
//properties of TMLinkedList
private int size;
private Node start;
private class Node
{
private int data;
private Node next;
Node()
{
this.data=0;	//for generic, this.data=null;
this.next=null;
}
Node(int data)
{
this.data=data;
this.next=null;
}
public void setData(int data)
{
this.data=data;
}
public int getData()
{
return this.data;
}
public void setNext(Node next)
{
this.next=next;
}
public Node getNext()
{
return this.next;
}
}
//TMLinkedListIterator class
public class TMLinkedListIterator implements TMIterator
{
private Node ptr;
public TMLinkedListIterator(Node ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public int next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
int data=this.ptr.data;
this.ptr=ptr.next;
return data;
}
}//end of TMLinkedListIterator class
//constructor of TMLinkedList
public TMLinkedList()
{
this.size=0;
this.start=null;
}
//functions of TMLinkedList
public void add(int data)
{
Node tmp = this.start;
if(this.start==null)
{
this.start=new Node(data);
this.size++;
System.out.println("(Data added for first node).");
return;
}
while(tmp.next!=null)
{
tmp=tmp.next;
}
tmp.next=new Node();
tmp.next.setData(data);
this.size++;
System.out.println("(Data added).");
}
public void add(int index,int data)
{
if(index<0 || index>=(this.size + 1))
{
throw new IndexOutOfBoundsException("Invalid index: " + index);
}
if(index==0 && this.start==null) 
{
this.add(data);
return;
}
Node tmp=this.start;
Node j_tmp=this.start; //the follower node also starts from "start" pointer to consider case of 0th index insertion
if(index==0 && this.start!=null) //insert at 0th position while a linked list already exists
{
tmp=new Node(data);
tmp.next=this.start;
this.start=tmp;
this.size++;
return;
}
for(int k=0;k<index;k++)
{
j_tmp=tmp;
tmp=tmp.next;
}
j_tmp.next=new Node(data);
j_tmp.next.next=tmp;
this.size++;
System.out.println("Node added at index: "+index);
}
public void insert(int index,int data)
{
if(index<0 || index>=(this.size + 1))
{
throw new IndexOutOfBoundsException("Invalid index: " + index);
}
if(index==0 && this.start==null) 
{
this.add(data);
return;
}
Node tmp=this.start;
Node j_tmp=this.start; //the follower node also starts from "start" pointer to consider case of 0th index insertion
if(index==0 && this.start!=null) //insert at 0th position while a linked list already exists
{
tmp=new Node(data);
tmp.next=this.start;
this.start=tmp;
this.size++;
return;
}
for(int k=0;k<index;k++)
{
j_tmp=tmp;
tmp=tmp.next;
}
j_tmp.next=new Node(data);
j_tmp.next.next=tmp;
this.size++;
System.out.println("Node added at index: "+index);

}

public void removeAll()
{
this.start=null;
this.size=0;
System.out.println("List cleared.");
}
public void clear()
{
this.start=null;
this.size=0;
System.out.println("List cleared.");
}

public int size()
{
return this.size;
}
public int get(int index)
{
Node j_tmp=this.start;
if(index<0 || index>=this.size)
{
throw new IndexOutOfBoundsException("Invalid index: " + index);
}
while(j_tmp.next!=null)
{
for(int k=0;k<index;k++)
{
j_tmp=j_tmp.next;
}
return j_tmp.data;
}
System.out.println("Could not find node.");
return 0;
}

public void update(int index,int data)
{
if(index<0 || index>=this.size)
{
throw new IndexOutOfBoundsException("Invalid index: "+index);
}
Node j_tmp=this.start;
for(int k=0;k<index;k++)
{
j_tmp=j_tmp.next;
}
int old_data=j_tmp.data;
j_tmp.data=data;
System.out.println("Old data: (" + old_data + ")" + " updated with new data: (" + j_tmp.data + ").");
}
public int removeAt(int index)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
Node j=this.start;	//j will be on node to remove
Node t=j;	//t will be one node behind
if(index==0) //meaning first node to be deleted
{
int data=j.data;
this.start=this.start.next;
return data;
}
for(int k=0;k<index;k++)
{
t=j;
j=j.next;
}
int data=j.data;
t.next=j.next;
this.size--;
System.out.println("Data removed: (" + data + ").");
return data;
}

public void copyTo(TMList other)
{
other.clear();
for(int k=0;k<this.size();k++)
{
other.add(this.get(k));
}
System.out.println("List calling function copied to list passed as parameter.");
}
public void copyFrom(TMList other)
{
this.clear();
for(int k=0;k<other.size();k++)
{
this.add(other.get(k));
}
System.out.println("List calling function copied from list passed as parameter.");
}

public void appendTo(TMList other)
{
for(int k=0;k<this.size();k++)
{
other.add(this.get(k));
}
System.out.println("List calling function appended to list passed as parameter.");
}
public void appendFrom(TMList other)
{
for(int k=0;k<other.size();k++)
{
this.add(other.get(k));
}
System.out.println("List calling function appended from list passed as parameter.");
}
public TMIterator iterator()
{
return new TMLinkedListIterator(this.start);
}

/*//forEach() function which has lambda expression. Rough idea.
public void forEach(FunctionalInterfaceIterationPrinter lambda1)
{
/ *
 *for(int e=0;e<this.size;e++)
 *{
 *int data=this.get(e);
 *lambda1.lijiye(data);
 *}
 * / 

TMIterator iterator1=this.iterator();
while(iterator1.hasNext())
{
int data=iterator1.next();
lambda1.lijiye(data);
}
}
*/
public void forEach(TMListItemAcceptor a)
{
if(a==null) return;
Node t;
for(t=start;t!=null;t=t.next) a.accept(t.data);
}

}//end of TMLinkedList

