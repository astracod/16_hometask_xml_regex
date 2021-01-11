package org.example.regex.menu;

import org.example.regex.userCreation.ParseData;
import org.example.regex.userCreation.UserParseException;
import org.example.regex.userCreation.UserParseParseData;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {


    private ParseData parseData;
    private List<MenuAction> menuActions;
    private Scanner scanner;
    private PrintStream out;

    public Menu() {
        this.parseData = new UserParseParseData();
        this.menuActions = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.out = System.out;
        menuActions.add(new UserCreationMenuAction(parseData, scanner, out));
        menuActions.add(new ExitMenuAction(out));
    }


    protected void show() {
        for (int i = 0; i < menuActions.size(); i++) {
            out.println((i + 1) + " ) " + menuActions.get(i).getActionName());
        }
    }

    protected int action() {
        out.println(" Введите номер запроса : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMenu() throws IOException, UserParseException {
        while (true) {
            show();
            int index = action() - 1;
            if (menuActions.size() > index && index >= 0) {
                menuActions.get(index).execute();
                if (menuActions.get(index).exitMethod()) break;
            }
        }
    }
}
