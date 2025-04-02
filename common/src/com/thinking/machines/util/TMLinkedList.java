package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
//properties of TMLinkedList
private int size;
private TMNode start;
private class TMNode<T>
{
private T data;
private TMNode next;
TMNode()
{
this.data=null;	//for generic, this.data=null;
this.next=null;
}
TMNode(T data)
{
this.data=data;
this.next=null;
}
public TMNode<T> getNext()
{
return this.next;
}
}
//TMLinkedListIterator class
public class TMLinkedListIterator<T> implements TMIterator<T>
{
private TMNode<T> ptr;
public TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
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
public void add(T data)
{
TMNode<T> tmp = this.start;
if(this.start==null)
{
this.start=new TMNode<T>(data);
this.size++;
System.out.println("(Data added for first node).");
return;
}
while(tmp.next!=null)
{
tmp=tmp.next;
}
tmp.next=new TMNode<T>(data);
this.size++;
System.out.println("(Data added).");
}
public void add(int index,T data)
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
TMNode<T> tmp=this.start;
TMNode<T> j_tmp=this.start; //the follower node also starts from "start" pointer to consider case of 0th index insertion
if(index==0 && this.start!=null) //insert at 0th position while a linked list already exists
{
tmp=new TMNode<T>(data);
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
j_tmp.next=new TMNode<T>(data);
j_tmp.next.next=tmp;
this.size++;
System.out.println("TMNode added at index: "+index);
}
public void insert(int index,T data)
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
TMNode<T> tmp=this.start;
TMNode<T> j_tmp=this.start; //the follower node also starts from "start" pointer to consider case of 0th index insertion
if(index==0 && this.start!=null) //insert at 0th position while a linked list already exists
{
tmp=new TMNode<T>(data);
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
j_tmp.next=new TMNode<T>(data);
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
public T get(int index)
{
TMNode<T> j_tmp=this.start;
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
return null;
}

public void update(int index,T data)
{
if(index<0 || index>=this.size)
{
throw new IndexOutOfBoundsException("Invalid index: "+index);
}
TMNode<T> j_tmp=this.start;
for(int k=0;k<index;k++)
{
j_tmp=j_tmp.next;
}
T old_data=j_tmp.data;
j_tmp.data=data;
System.out.println("Old data: (" + old_data + ")" + " updated with new data: (" + j_tmp.data + ").");
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
TMNode<T> j=this.start;	//j will be on node to remove
TMNode<T> t=j;	//t will be one node behind
if(index==0) //meaning first node to be deleted
{
T data=j.data;
this.start=this.start.next;
return data;
}
for(int k=0;k<index;k++)
{
t=j;
j=j.next;
}
T data=j.data;
t.next=j.next;
this.size--;
System.out.println("Data removed: (" + data + ").");
return data;
}

public void copyTo(TMList<T> other)
{
other.clear();
for(int k=0;k<this.size();k++)
{
other.add(this.get(k));
}
System.out.println("List calling function copied to list passed as parameter.");
}
public void copyFrom(TMList<T> other)
{
this.clear();
for(int k=0;k<other.size();k++)
{
this.add(other.get(k));
}
System.out.println("List calling function copied from list passed as parameter.");
}

public void appendTo(TMList<T> other)
{
for(int k=0;k<this.size();k++)
{
other.add(this.get(k));
}
System.out.println("List calling function appended to list passed as parameter.");
}
public void appendFrom(TMList<T> other)
{
for(int k=0;k<other.size();k++)
{
this.add(other.get(k));
}
System.out.println("List calling function appended from list passed as parameter.");
}
public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
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
TMNode<T> t;
for(t=start;t!=null;t=t.next) a.accept(t.data);
}

}//end of TMLinkedList

