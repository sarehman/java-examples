package demo.hw.server;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class UserAdapter extends XmlAdapter<UserImpl, User> {

    @Override
    public User unmarshal(UserImpl user) throws Exception {
        return user;
    }

    @Override
    public UserImpl marshal(User user) throws Exception {
        if(user instanceof UserImpl){
            return (UserImpl) user;
        }
        return new UserImpl(user.getName());
    }
}
