package com.company.p4_ListyIterator;

import java.util.List;

public class ListyIterator  {
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
}
