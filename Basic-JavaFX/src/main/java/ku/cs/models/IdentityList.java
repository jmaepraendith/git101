package ku.cs.models;

import java.util.ArrayList;

public class IdentityList {

    private static ArrayList<Identity> identities;

    public IdentityList(){
        identities = new ArrayList<>();
    }

    public void addIdentity(String Name, String Status){
        Name = Name.trim();
        Status = Status.trim();
        if(!Name.equals("") && !Status.equals("")){
            Identity exist = findthatperson(Name);
            if(exist==null){
                identities.add(new Identity(Name.trim(),Status.trim()));
            }
        }
    }

    public static Identity findthatperson(String Name){
        for(Identity identity : identities){
            if(identity.isName(Name)){
                return identity;
            }
        }
        return null;
    }

    public static void giveloveTold(String name, String yn) {
        Identity exist = findthatperson(name);
        if (exist != null) {
            exist.SoDoYouLoveThem(yn);
        }
    }

    public ArrayList<Identity> getIdentities(){
        return identities;
    }

}
