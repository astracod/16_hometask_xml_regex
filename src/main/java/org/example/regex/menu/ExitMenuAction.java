package org.example.regex.menu;

import org.example.regex.userCreation.UserParseException;

import java.io.IOException;
import java.io.PrintStream;

public class ExitMenuAction implements MenuAction {
    private PrintStream out;

    public ExitMenuAction(PrintStream out) {
        this.out = out;
    }

    @Override
    public String getActionName() {
        return " Выход";
    }

    @Override
    public void execute() throws IOException {
        out.println(" Успехов в изучении Java !!!");
    }

    @Override
    public boolean exitMethod() {
        return true;
    }
}
