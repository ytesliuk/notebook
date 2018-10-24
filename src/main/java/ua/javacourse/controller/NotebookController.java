package ua.javacourse.controller;

import ua.javacourse.NotebookView;
import ua.javacourse.model.Group;
import ua.javacourse.model.Notebook;
import ua.javacourse.model.Record;
import ua.javacourse.model.RecordFieldsEnum;

import java.awt.image.VolatileImage;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
public class NotebookController {
    private Notebook notebook;
    private NotebookView view;
    private Scanner input;
    private Map<RecordFieldsEnum, String> recordData;

    public NotebookController(Notebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
        this.input = new Scanner(System.in);
        this.recordData = new EnumMap<>(RecordFieldsEnum.class);
    }

    public void addRecord(){
        Record newRecord = infoRequest();
        view.showMessage(notebook.addRecord(newRecord) ? ("контакт создан \n\n" + newRecord.toString()) : "контакт с таким именем уже существует");
    }

    private Record infoRequest(){
        view.showMessage("Заполните последовательно поля. Если поле не является обязательным его можно пропустить нажав \"enter\"\n");
        for (RecordFieldsEnum rg : RecordFieldsEnum.values()){
            view.showMessage(rg.getName() + ": ");
            do {
                String userInput = input.nextLine();
                if (rg == RecordFieldsEnum.GROUP &&! Group.isValidGroup(userInput)) {
                    view.showMessage("Такой группы контактов не существует. Выберите из " +
                                    Arrays.toString(Arrays.stream(Group.values())
                            .map(Group::getRussianName)
                            .toArray()));
                } else if (!isValid(rg.getPattern(), userInput) && !userInput.isEmpty()) {
                    view.showMessage("Поле \"" + rg.getName() + "\" должно быть заполнено в формате " + rg.getPattern() + ": ");
                } else if (userInput.isEmpty() && rg.isRequired()) {
                    view.showMessage("Поле \"" + rg.getName() + "\" должно быть заполнено: ");
                } else {
                    recordData.put(rg, userInput);
                    break;
                }
            } while(true);
        }
        return new Record(recordData);
    }
    
    public static boolean isValid(Pattern pattern, String input){
        Matcher lastNameMatcher = pattern.matcher(input);
        return lastNameMatcher.matches();
    }
}
