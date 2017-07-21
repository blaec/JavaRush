package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry<String> root;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 16, actual is " + ((CustomTree) list).size());
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    public boolean add(String s) {

        // Add root if not exit and exit
        if (root == null) {
            root = new Entry<>("0");
        }

        // Root exist, then add it to queue for further check and initiate this check
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // Check next Entry (root, left or right)
            Entry<String> currentEntry = queue.remove();

            // Check from left
            // if left entry exist and it's not empty - add it to queue for further check
            if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild!=null) {
                queue.add(currentEntry.leftChild);

            // If left child not exist - add it and exit loop
            } else {
                if (currentEntry.availableToAddLeftChildren) {
                    Entry<String> newEntry = new Entry<String>(s);
                    newEntry.parent = currentEntry;
                    currentEntry.leftChild = newEntry;
                    currentEntry.checkChildren();
                    break;
                }
            }

            // Check from right
            // if right entry exist and it's not empty - add it to queue for further check
            if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild!=null) {
                queue.add(currentEntry.rightChild);

            // If right child not exist - add it and exit loop
            } else {
                if (currentEntry.availableToAddRightChildren) {
                    Entry<String> newEntry = new Entry<String>(s);
                    newEntry.parent = currentEntry;
                    currentEntry.rightChild = newEntry;
                    currentEntry.checkChildren();
                    break;
                }
            }
        }
        return false;
    }

    public void remove(String s) {

        // Tree is empty - exit
        if (root == null) {
            return;
        }

        // Add root to queue and begin the check
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();

            // If match not found (left then right) - add child to queue and proceed
            // otherwise - set child to null and exit loop
            if (!currentEntry.leftChild.elementName.equals(s)) {
                queue.add(currentEntry.leftChild);
            } else {
                currentEntry.leftChild = null;
                break;
            }
            if (!currentEntry.rightChild.elementName.equals(s)) {
                queue.add(currentEntry.rightChild);
            } else {
                currentEntry.rightChild = null;
                break;
            }
        }
    }

    @Override
    public int size() {

        // if no Entry exist - return 0
        if (root == null) {
            return 0;
        }

        // Add root (=1) and loop thouhg all elements by adding-removing elements from queue
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {

            // remove current Entry from queue and check for children
            Entry<String> currentEntry = queue.remove();

            // If left/right entry exist - add it to queue for further check
            if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild!=null) {
                count++;
                queue.add(currentEntry.rightChild);
            }
            if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild!=null) {
                count++;
                queue.add(currentEntry.leftChild);
            }
        }
        return count;
    }

    public String getParent(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        String parentName = null;
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (currentEntry.leftChild != null ) {
                if (!currentEntry.leftChild.elementName.equals(s)) {
                    queue.add(currentEntry.leftChild);
                } else {
                    parentName = currentEntry.elementName;
                    break;
                }
            }
            if (currentEntry.rightChild != null) {
                if (!currentEntry.rightChild.elementName.equals(s)) {
                    queue.add(currentEntry.rightChild);
                } else {
                    parentName = currentEntry.elementName;
                    break;
                }
            }
        }
        return parentName;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            availableToAddLeftChildren = leftChild != null ? false : true;
            availableToAddRightChildren = rightChild != null ? false : true;
        }

        boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        this.remove(s);
        return false;
    }

//    public boolean add(String s) {
//        Entry<String> newEntry = new Entry(s);
//
//        if (root == null) {
//            root = newEntry;
//            return true;
//        }
//        else {
//            Entry<String> focusEntry = root;
//            Entry<String> parent;
//
//            while (true){
//                parent = focusEntry;
//                parent.checkChildren();
//                if (parent.availableToAddLeftChildren) {
//                    parent.leftChild = newEntry;
//                    return true;
//                }
//                else if (parent.availableToAddRightChildren) {
//                    parent.rightChild = newEntry;
//                    return true;
//                }
//                else {
//                    if (focusEntry.leftChild.isAvailableToAddChildren()) {
//                        focusEntry = focusEntry.leftChild;
//                    }
//                    else if (focusEntry.rightChild.isAvailableToAddChildren()) {
//                        focusEntry = focusEntry.rightChild;
//                    }
////                    if (!focusEntry.leftChild.isAvailableToAddChildren() && !focusEntry.rightChild.isAvailableToAddChildren()) {
////                        focusEntry = focusEntry.leftChild;
////                    }
////                    else {
////                        focusEntry = focusEntry.rightChild;
////                    }
//                }
//            }
//        }
//    }
}
