package org.example.regex;

import org.example.regex.entities.User;
import org.example.regex.menu.Menu;
import org.example.regex.userCreation.ParseData;
import org.example.regex.userCreation.UserParseException;
import org.example.regex.userCreation.UserParseParseData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {

    /*
    имеется текст, состоящий из описания пользователей, разделенных запятой (разбить поможет split),
    каждый пользователь описан как nickname:username@password при этом.
    если у пользователя нет nickname, то в качестве nickname используется имя пользователя
    пароль может отсутствовать.

    Например:

     programmer:vasia@123 соответствует объекту User(nickname="programmer", username="vasia",password="123")

     programmer:vasia объекту User(nickname="programmer", username="vasia",password=null)

     vasia@1234 объекту User(nickname="vasia", username="vasia",password="1234")

     vasia объекту User(nickname="vasia", username="vasia",password=null)

     vasia:@trulala - невалидный пользователь



    Написать класс UserParser, содержащий методы
    User parse(String user) - принимает текст вида vasia@1234 и возвращает созданого на основе него пользователя
    List<User> parseList(String user) - принимает строку содержащую пользователей, разделенных запятой и возвращающий список пользователей

*/

    public static void main(String[] args) throws IOException, UserParseException {
//запрос для примера : programmer:vasia@123,programmer:vasia,vasia@1234,vasia

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Menu menu = context.getBean(Menu.class);
        menu.showMenu();

    }
}
