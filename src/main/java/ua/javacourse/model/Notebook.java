package ua.javacourse.model;

import java.util.TreeSet;

/**
 * Created by Yuliia Tesliuk on 10/24/2018
 */
public class Notebook {
    private TreeSet<Record> notebook;

    public Notebook(){
        notebook = new TreeSet<>();
    }

    public TreeSet<Record> getNotebook() {
        return notebook;
    }

    public boolean addRecord(Record record) {
        return notebook.add(record);
    }
}
