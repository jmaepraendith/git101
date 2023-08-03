package ku.cs.models;

public class Identity {

    private String myfavpersonsname;
    private String theirstatus;

    private String  doyoulovethem;

    private int yearthattheyreborn;

    public Identity( String name, String status){
        this.myfavpersonsname = name;
        this.theirstatus = status;
        doyoulovethem = "";

    }

    public Identity(String name, String status,String doyoulovethem) {
        this.myfavpersonsname = name;
        this.theirstatus = status;
        this.doyoulovethem = doyoulovethem;
    }
    public void SoDoYouLoveThem(String ans){
        if(!ans.equals("")){
            doyoulovethem = ans;
        }
    }

    public Identity( String name, String status, int yearthattheyreborn) {

        this.myfavpersonsname = name;
        this.yearthattheyreborn = yearthattheyreborn;
        this.theirstatus = status;

    }

    public boolean isName(String namw){
        return myfavpersonsname.equals(namw);
    }

    public String getTheirStatus() {
        return theirstatus;
    }

    public String getMyFavPersonsName() {
        return myfavpersonsname;
    }

    public int getYearThatTheyreBorn() {
        return yearthattheyreborn;
    }

    public String getDoYouLoveThem(){return doyoulovethem;}

    public int CalAge() {
        return 2023-yearthattheyreborn ;
    }

    @Override
    public String toString() {
        return "{" +
                "Name: '" + myfavpersonsname + '\'' +
                ", Status: '" + theirstatus + '\'' +
                ", Love?: " + doyoulovethem +
                '}';
    }

//
}
