package org.example.regex.userCreation;

import org.example.regex.entities.User;

import java.util.List;

public interface ParseData {

    List<User> parseList(String user) throws UserParseException;
}
