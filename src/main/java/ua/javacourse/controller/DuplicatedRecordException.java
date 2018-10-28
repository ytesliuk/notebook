package ua.javacourse.controller;

import ua.javacourse.model.Record;

/**
 * Created by Yuliia Tesliuk on 10/28/2018
 */
public class DuplicatedRecordException extends Exception {
    private Record record;

    public DuplicatedRecordException(String message, Record record){
        super(message);
        this.record = record;
    }
    public DuplicatedRecordException(){
    }

    public Record getRecord() {
        return record;
    }
}
