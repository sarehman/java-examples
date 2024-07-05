package demo.hw.server;

import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "User")
public class UserImpl implements User{

    String name;

    public UserImpl(){}
    public UserImpl(String s){
        name = s;
    }

    public void setName(String s){
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
