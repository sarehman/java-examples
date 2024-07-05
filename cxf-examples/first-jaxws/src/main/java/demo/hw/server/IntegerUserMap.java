package demo.hw.server;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlType(name = "IntegerUserMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegerUserMap {

    @XmlElement(nillable = false, name = "entry")
    List<IntegerUserEntry> entries = new ArrayList<>();

    public List<IntegerUserEntry> getEntries() {
        return entries;
    }

    @XmlType(name = "IdentifiedUser")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class IntegerUserEntry{
        @XmlElement(nillable = false, required = true)
        Integer id;

        User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
