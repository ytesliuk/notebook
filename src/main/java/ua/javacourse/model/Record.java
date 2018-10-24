package ua.javacourse.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
public class Record implements Comparable {
    private String lastName;
    private String firstName;
    private String middleName;
    private String nickname;
    private String comment;
    private Group group;
    private List phoneNumbers;
    private String email;
    private String skype;
    private Address address;
    private Date createDate;
    private Date changeDate;

    public Record (Map<RecordFieldsEnum,String> record) {
        this.lastName = record.get(RecordFieldsEnum.LAST_NAME);
        this.firstName = record.get(RecordFieldsEnum.FIRST_NAME);
        this.middleName = record.get(RecordFieldsEnum.MIDDLE_NAME);
        this.group = Group.getGroup(record.get(RecordFieldsEnum.GROUP));
       // this.phoneNumbers = record.get(RecordFieldsEnum.);
        this.email = record.get(RecordFieldsEnum.EMAIL);
        this.skype = record.get(RecordFieldsEnum.SKYPE);
        this.address = new Address( record.get(RecordFieldsEnum.INDEX),
                                    record.get(RecordFieldsEnum.CITY),
                                    record.get(RecordFieldsEnum.STREET),
                                    record.get(RecordFieldsEnum.BUILDING),
                                    record.get(RecordFieldsEnum.APT));
        createDate = new Date();
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.changeDate = new Date();
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    public List getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(List phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSkype() {
        return skype;
    }
    public void setSkype(String skype) {
        this.skype = skype;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public Date getChangeDate() {
        return changeDate;
    }
    private void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof  Record) {
            Record otherRecord = (Record) obj;
            if (this.lastName.equals(((Record) obj).lastName)
            && this.firstName.equals(((Record) obj).firstName)
            && this.middleName.equals(((Record) obj).middleName)
            && this.nickname.equals(((Record) obj).nickname));
        }
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        Record rec = (Record) o;
        return (this.lastName + this.firstName + this.middleName).compareTo(rec.lastName + rec.firstName + rec.middleName);
    }
}
