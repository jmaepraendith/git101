package ku.cs.services;
import ku.cs.models.IdentityList;

public class IdentityHardCodeDataSource {

    public IdentityList readData() {
        IdentityList list = new IdentityList();
        list.addIdentity("Alexandra Mikhailov","Fictional Character");
        list.addIdentity("Catherine Perfect","Fictional Character");
        list.addIdentity("Natalie","Fictional Character");
        list.addIdentity("Nicole Kidman","Real Person");
        list.addIdentity("Loki","Fictional Character");
        list.addIdentity("Cillian Murphy","Real Person");
        list.addIdentity("Mads Mikkelsen","Real Person");
        return list;
    }

}