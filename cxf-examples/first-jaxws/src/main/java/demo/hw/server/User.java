package demo.hw.server;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(UserAdapter.class)
public interface User {
    String getName();
}
