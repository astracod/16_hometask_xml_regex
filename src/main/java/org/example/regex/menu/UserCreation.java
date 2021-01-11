package org.example.regex.menu;

import org.example.regex.entities.User;
import org.example.regex.userCreation.ParseData;
import org.example.regex.userCreation.UserParseException;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class UserCreation implements MenuAction {

    private ParseData parseData;
    private Scanner scanner;
    private PrintStream out;
    private String name;
//
    public UserCreation(ParseData parseData, Scanner scanner, PrintStream out) {
        this.parseData = parseData;
        this.scanner = scanner;
        this.out = out;
        this.name = " Создание пользователя";
    }

    private void showUsers(List<User> userList) {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public String getActionName() {
        return name;
    }

    @Override
    public void execute() throws  UserParseException {
        out.print(" Введите данные из адресной строки для создания пользователя : ");
        String userStr = scanner.nextLine();
        List<User> userList = parseData.parseList(userStr);
        System.out.println("---------------------------");
        showUsers(userList);
        System.out.println("---------------------------");
    }

    @Override
    public boolean exitMethod() {
        return false;
    }
}
