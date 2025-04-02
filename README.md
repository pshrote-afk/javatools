# javatools
Tools made in JAVA: 

## 1. SetterGetterGenerator 
### (for generating setters and getters for properties of a class)
path: common/src/com/thinking/machines/util/SetterGetterGenerator.java

# Following classes may be used as an alternative to standard built-in java packages:
## 2. Keyboard class (replica of java.util.Scanner)
### (for accepting input from keyboard)
path: common/src/com/thinking/machines/util/Keyboard.java  <br><br>
_import com.thinking.machines.util.Keyboard;_ <br><br>
see KeyboardTestCase.java in common/testcases

## 3. TMList (replica of interface List in java.util.List)
path: common/src/com/thinking/machines/util <br><br>
_import com.thinking.machines.util.TMList;_ <br><br>
following functions are available (see common/src/com/thinking/machines/util/TMList.java):
```
public void add(T data);
public void add(int index,T data);
public void insert(int index,T data);

public void removeAll();
public void clear();

public int size();
public T get(int index);

public void update(int index,T data);
public T removeAt(int index);

public void copyTo(TMList<T> other);
public void copyFrom(TMList<T> other);

public void appendTo(TMList<T> other);
public void appendFrom(TMList<T> other);

public TMIterator<T> iterator();

public void forEach(TMListItemAcceptor<T> a);
```

## 4. TMLinkedList (replica of LinkedList in java.util.LinkedList)
### implements TMList
path: common/src/com/thinking/machines/util <br><br>
_import com.thinking.machines.util.TMList;_ <br><br>
see TMLinkedListInsertTestCase.java, TMLinkedListRemoveAtTestCase.java, TMLinkedListCopyAppendTestCase.java in common/testcases

## 5. TMArrayList (replica of ArrayList in java.util.ArrayList)
### implements TMList
path: common/src/com/thinking/machines/util <br><br>
_import com.thinking.machines.util.TMList;_ <br><br>
see TMArrayListInsertTestCase.java, TMArrayListCopyAppendTestCase.java in common/testcases

## 6. TMIterator (replica of java.util.Iterator)
### implements TMList
path: common/src/com/thinking/machines/util <br><br>
_import com.thinking.machines.util.TMList;_


