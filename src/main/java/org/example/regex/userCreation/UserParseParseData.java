package org.example.regex.userCreation;

import org.example.regex.entities.User;

import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserParseParseData implements ParseData {



    private User parse(String user) throws UserParseException {
        User user1 = new User();
        Pattern pattern = Pattern.compile("(?:([a-zA-Z]+):)?(?:([a-zA-Z]+))@?(?:(\\d*))?");
        Matcher m = pattern.matcher(user);


        if (!m.matches()) {
            throw new UserParseException("невалидный пользователь");
        }
        user1.setNickname(m.group(1));
        user1.setUsername(m.group(2));


        if (m.group(3).isEmpty()) user1.setPassword(null);
        else user1.setPassword(Integer.parseInt(m.group(3)));


        if (user1.getNickname() == null) user1.setNickname(user1.getUsername());

        return user1;
    }

    @Override
    public List<User> parseList(String user) throws UserParseException {
        List<User> userList = new ArrayList<>();
        String[] users = user.split(",");

        for (String s : users) {
            if (s == null) continue;
            userList.add(parse(s));
        }
        return userList;
    }
}
