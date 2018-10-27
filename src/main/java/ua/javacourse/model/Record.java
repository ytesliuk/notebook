package ua.javacourse.model;

import java.util.*;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
public class Record implements Comparable {
    private String name;
    private Address address;
    private Map<RecFields, String> record;
    private Date createDate;
    private Date changeDate;

    public Record(Map<RecFields, String> record) {
        this.name = record.get(RecFields.LAST_NAME) + " " + record.get(RecFields.FIRST_NAME) + " "  + record.get(RecFields.MIDDLE_NAME);
        this.address = new Address(record.get(RecFields.INDEX), record.get(RecFields.CITY), record.get(RecFields.STREET), record.get(RecFields.BUILDING), record.get(RecFields.APT));
        this.record = record;
        createDate = new Date();

    }

    public String getFieldValue(RecFields field) {
        return record.get(field);
    }

    public void setFieldValue(RecFields field, String value) {
        record.put(field, value);
        changeDate = new Date();
    }

    public Date getCreateDate() {
        return createDate;
    }
    public Date getChangeDate() {
        return changeDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof  Record) {
            Record otherRec = (Record) obj;
            return this.name.equals(otherRec.name);
        } else return false;
    }

    @Override
    public int compareTo(Object o) {
        Record rec = (Record) o;
        return (this.name).compareTo(rec.name);
    }

    @Override
    public String toString() {
        StringBuilder recordInfo = new StringBuilder();
        recordInfo.append(name).append(" ").append(record.get(RecFields.NICKNAME).isEmpty() ? "" : "(" + record.get(RecFields.NICKNAME) + ")")
                .append(" в группе ").append(record.get(RecFields.GROUP))
                .append("\n").append("номера телефонов: ").append(record.get(RecFields.HOME_PHONE_NUMBER) + ", ").append(record.get(RecFields.MOBILE_PHONE_NUMBER))
                .append("\n").append("email: ").append(record.get(RecFields.EMAIL)).append(" / skype: ").append(record.get(RecFields.SKYPE))
                .append("\n").append("адресс: ").append(address.toString()).append("\n").append("комментарий: ").append(record.get(RecFields.COMMENT));
        return recordInfo.toString();
    }
}
