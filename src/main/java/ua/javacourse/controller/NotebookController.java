package ua.javacourse.controller;

import ua.javacourse.NotebookView;
import ua.javacourse.model.Group;
import ua.javacourse.model.Notebook;
import ua.javacourse.model.Record;
import ua.javacourse.model.RecFields;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
public class NotebookController {
    private Properties properties;
    private Notebook notebook;
    private NotebookView view;
    private Scanner input;
    private Map<RecFields, String> recordData;

    public NotebookController(Notebook notebook, NotebookView view) {
        this.notebook = notebook;
        this.view = view;
        this.properties = new Properties();
        this.input = new Scanner(System.in);
        this.recordData = new EnumMap<>(RecFields.class);
        propertyLoader();
    }

    private void propertyLoader(){
        try {
            FileInputStream propStream = new FileInputStream("regexp_en_ru.properties");
            // applying UTF-8
            InputStreamReader streamReader = new InputStreamReader(propStream,"UTF-8");
            properties.load(streamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRecord(){
        Record newRecord = infoRequest();
        view.showMessage(notebook.addRecord(newRecord) ? ("контакт создан \n\n" + newRecord.toString()) : "контакт с таким именем уже существует");
    }

    private Record infoRequest(){
        view.showMessage("Заполните последовательно поля. Если поле не является обязательным его можно пропустить нажав \"enter\"\n");
        for (RecFields rg : RecFields.values()){
            view.showMessage(rg.getName() + ": ");
            do {
                String userInput = input.nextLine();
                if (rg == RecFields.GROUP &&! Group.isValidGroup(userInput)) {
                    view.showMessage("Такой группы контактов не существует. Выберите из " +
                                    Arrays.toString(Arrays.stream(Group.values())
                            .map(Group::getRussianName)
                            .toArray()));
                } else if (!isValid(Pattern.compile(properties.getProperty(rg.toString())), userInput) && !userInput.isEmpty()) {
                    view.showMessage("Поле \"" + rg.getName() + "\" должно быть заполнено в формате " + properties.getProperty(rg.toString()) + ": ");
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
