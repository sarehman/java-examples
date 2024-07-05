package demo.hw.server;

import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Map;

@WebService
public interface HelloWorld {

    String sayHi(String text);

    String sayHiToUser(User user);

    /* Map passing
     * JAXB also does not support Maps.  It handles Lists great, but Maps are
     * not supported directly.  They also require use of a XmlAdapter to map
     * the maps into beans that JAXB can use.
     */
    @XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
    Map<Integer, User> getUsers();
}
