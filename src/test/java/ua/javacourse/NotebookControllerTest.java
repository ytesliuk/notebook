package ua.javacourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ua.javacourse.controller.DuplicatedRecordException;
import ua.javacourse.controller.NotebookController;
import ua.javacourse.model.Notebook;
import ua.javacourse.model.RecFields;
import ua.javacourse.model.Record;

import java.io.*;
import java.util.EnumMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
class NotebookControllerTest {
    Notebook notebook;
    Properties properties;

    @BeforeEach
    void setUp(){
        notebook = new Notebook();
        properties = new Properties();
    }

    @Test
    void infoRequest() {
    }

    @Disabled
    @Test
    void infoRequest1() {
        assertTrue(NotebookController.isValid(Pattern.compile("[a-zA-Z][a-zA-Z0-9\\Q.-,_\\E]{5,31}"),"hl-,.kjdgldksg"));
    }

    @Test
    void addRecord() throws DuplicatedRecordException {
        InputStream stream;
        InputStreamReader streamReader;
        try {
            stream = new FileInputStream("target/test-classes/TestRecord_UTF-8.properties");
            streamReader = new InputStreamReader(stream,"UTF-8");
            properties.load(streamReader);
            Map<RecFields,String> fieldsMap = new EnumMap<>(RecFields.class);
            for (RecFields rf : RecFields.values()){
                fieldsMap.put(rf,properties.getProperty(rf.toString()));
            }

            try {
                notebook.addRecord(new Record(fieldsMap));
            } catch (DuplicatedRecordException e) {
                System.err.println("Ошибка в тесте. тут не должно выбивать exception");
                fail();
            }

            stream = new FileInputStream("target/test-classes/TestRecordDuplicated.properties");
            streamReader = new InputStreamReader(stream,"UTF-8");
            properties.clear();
            properties.load(streamReader);

            Map<RecFields,String> fieldsMap2 = new EnumMap<>(RecFields.class);
            for (RecFields rf : RecFields.values()){
                fieldsMap2.put(rf,properties.getProperty(rf.toString()));
            }
            Record record2 = new Record(fieldsMap2);
            assertThrows(DuplicatedRecordException.class,() -> notebook.addRecord(record2));

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            fail();
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }

    }
}