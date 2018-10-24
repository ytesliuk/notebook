package ua.javacourse.model;

import java.util.regex.Pattern;

/**
 * Created by Yuliia Tesliuk on 10/24/2018
 */
public enum RecordFieldsEnum {
    LAST_NAME("Фамилия*",Pattern.compile("[A-Za-z|А-Яа-я]+"), true),
    FIRST_NAME("Имя*",Pattern.compile("[A-Za-z|А-Яа-я]+"), true),
    MIDDLE_NAME("Отчество",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    NICKNAME("Никнейм",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    GROUP("Группа*",Pattern.compile("[A-Za-zА-Яа-я]+"), true),
    HOME_PHONE_NUMBER("Домашний телефон",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    MOBILE_PHONE_NUMBER("Мобильный телефон*",Pattern.compile("[A-Za-zА-Яа-я]+"), true),
    EMAIL("Email*",Pattern.compile("[A-Za-zА-Яа-я]+"), true),
    SKYPE("Skype",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    INDEX("Индекс",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    CITY("Город",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    STREET("Улица",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    BUILDING("Дом",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    APT("Квартира",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    COMMENT("Комментарий",Pattern.compile("[A-Za-zА-Яа-я]+"), false);

    private String name;
    private Pattern pattern;
    private boolean isRequired;

    RecordFieldsEnum(String name, Pattern pattern, boolean isRequired){
        this.name = name;
        this.pattern = pattern;
        this.isRequired = isRequired;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Pattern getPattern() {
        return pattern;
    }
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public boolean isRequired() {
        return isRequired;
    }
    public void setRequired(boolean required) {
        isRequired = required;
    }
}
