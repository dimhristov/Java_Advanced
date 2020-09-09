package com.company.p5_Collection;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.list = List.of(elements);
        this.currentIndex =0;
    }

    public boolean hasNext() {
        return currentIndex < this.list.size()-1 ;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.list.size() == 0) {
            System.out.println("Invalid Operation!");
        } else{
            System.out.println(this.list.get(this.currentIndex));
        }
    }

    public List<String> getList() {
        return this.list;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void printAll() {
        for (String element : list) {
            System.out.printf("%s ",element);
        }
        System.out.println();

    }

    @Override
    public Iterator iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return ListyIterator.this.hasNext();
            }

            @Override
            public String next() {
                return list.get(currentIndex);
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
