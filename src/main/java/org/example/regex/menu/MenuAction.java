package org.example.regex.menu;

import org.example.regex.userCreation.UserParseException;

import java.io.IOException;

public interface MenuAction {
    String getActionName();
    void execute() throws IOException, UserParseException;
    boolean exitMethod();
}
