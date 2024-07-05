package demo.hw.server;

import jakarta.jws.WebService;

import java.util.LinkedHashMap;
import java.util.Map;

@WebService(
        endpointInterface = "demo.hw.server.HelloWorld",
        serviceName = "HelloWorld"
)
public class HelloWorldImpl implements HelloWorld {

    Map<Integer, User> userMap = new LinkedHashMap<>();

    @Override
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello" + text;
    }

    @Override
    public String sayHiToUser(User user) {
        System.out.println("sayHiToUser called");
        userMap.put(userMap.size() + 1, user);
        return "Hello " +user.getName();
    }

    @Override
    public Map<Integer, User> getUsers() {
        System.out.println("getUsers called");
        return userMap;
    }
}
