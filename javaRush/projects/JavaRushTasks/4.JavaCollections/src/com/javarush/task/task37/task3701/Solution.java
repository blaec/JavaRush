package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        /*
        RoundIterator itList = new RoundIterator(list);
        for (Integer i : itList) {
        */
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T> {
        Iterator<T> iterator = Solution.super.iterator();
        int cursor = 0;

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;

            // reset iterator and set cursor to starting position
            if (cursor >= size()) {
                iterator = Solution.super.iterator();
                cursor = 0;
            }

            return true;
        }

        @Override
        public T next() {
            cursor++;
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            iterator.forEachRemaining(action);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }


    /*
    // Working but not acceptable
    public static class RoundIterator implements Iterable<Integer> {
        private int currentSize;
        private ArrayList<Integer> arrayList;

        public RoundIterator(ArrayList<Integer> newArray) {
            this.arrayList = newArray;
            this.currentSize = arrayList.size();
        }


        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> it = new Iterator<Integer>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    int result = arrayList.get(index);
                    index = (index + 1) % currentSize;
                    return result;
                }

                @Override
                public void remove() {
                    arrayList.remove(index);
                }
            };
            return it;
        }
    }
    */
}
