package ua.javacourse.model;

import java.util.regex.Pattern;

/**
 * Created by Yuliia Tesliuk on 10/24/2018
 */
public enum RecordFieldsEnum {
    LAST_NAME("Фамилия*",Pattern.compile("([A-Z][a-z]+)|([А-Я][а-я]+)"), true),
    FIRST_NAME("Имя*",Pattern.compile("([A-Z][a-z]+)|([А-Я][а-я]+)"), true),
    MIDDLE_NAME("Отчество",Pattern.compile("([A-Z][a-z]+)|([А-Я][а-я]+)"), false),
    NICKNAME("Никнейм",Pattern.compile("[A-Za-zА-Яа-я]+"), false),
    GROUP("Группа*",Pattern.compile("[А-Я][а-я]+"), true),
    HOME_PHONE_NUMBER("Домашний телефон",Pattern.compile("\\d{3}-\\d{3}-\\d{2}-\\d{2}"), false),
    MOBILE_PHONE_NUMBER("Мобильный телефон*",Pattern.compile("\\d{3}-\\d{3}-\\d{2}-\\d{2}"), true),
    EMAIL("Email*",Pattern.compile("[A-Za-z]+@[a-z]+[.a-z]+"), true),
    SKYPE("Skype",Pattern.compile("[a-zA-Z][a-zA-Z0-9\\Q.-,_\\E]{5,31}"), false),
    INDEX("Индекс",Pattern.compile("[0-9]+"), false),
    CITY("Город",Pattern.compile("([A-Z][a-z]+)|([А-Я][а-я]+)"), false),
    STREET("Улица",Pattern.compile("([A-Za-zА-Яа-я]+[- ]*){1,3}"), false),
    BUILDING("Дом",Pattern.compile("[0-9]+(/[0-9]+)*[а-я]*"), false),
    APT("Квартира",Pattern.compile("[0-9]+"), false),
    COMMENT("Комментарий",Pattern.compile(".*"), false);

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
