package ua.javacourse;

import ua.javacourse.controller.NotebookController;
import ua.javacourse.model.Notebook;

/**
 *
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Notebook notebook = new Notebook();
        NotebookView view = new NotebookView();
        NotebookController controller = new NotebookController(notebook, view);

        controller.addRecord();
    }
}
