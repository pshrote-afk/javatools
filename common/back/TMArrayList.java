package com.thinking.machines.util;
public class TMArrayList implements TMList
{
private Object collection[];
private int size;
public TMArrayList()
{
this.collection = new Object[10];
this.size=0;
}
//TMArrayListIterator class
public class TMArrayListIterator implements TMIterator
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return index!=size;
}
public int next()
{
if(index==size) throw new InvalidIteratorException("Iterator has no more elements");
int data=get(index);
index++;
return data;
}
}//end of TMArrayListIterator class
public void add(int data)
{
if(this.size==collection.length)
{
Object [] tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
this.collection[this.size]=data;
this.size++;
}
public void add(int index,int data)
{
if(index<0 || index>this.size)
{
throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
}
if(this.size==collection.length)
{
Object [] tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
for(int e=this.size;e>index;e--)
{
this.collection[e]=this.collection[e-1];
}
this.collection[index]=data;
this.size++;
}
public void insert(int index,int data)
{
if(index<0 || index>this.size)
{
throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
}
if(this.size==collection.length)
{
Object [] tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
for(int e=this.size;e>index;e--)
{
this.collection[e]=this.collection[e-1];
}
this.collection[index]=data;
this.size++;
}

public void removeAll()
{
this.size=0;
}
public void clear()
{
this.size=0;
}

public int size()
{
return this.size;
}
public int get(int index)
{
if(index<0 || index>=this.size)
{
throw new IndexOutOfBoundsException("Invalid index: "+index);
}
return (int)this.collection[index];
}

public void update(int index,int data)
{
if(index<0 || index>=this.size)
{
throw new ArrayIndexOutOfBoundsException("Invalid index: "+index);
}
this.collection[index]=data; //updated
}
public int removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: " + index);
int data=(int)this.collection[index];
int ep=this.size-2; 
for(int e=index;e<=index;e++)
{
this.collection[e]=this.collection[e+1];
} 
this.size--;
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
return new TMArrayListIterator();
}
public void forEach(TMListItemAcceptor a)
{
if(a==null) return;
for(int e=0;e<this.size;e++) a.accept((int)collection[e]);
}

}