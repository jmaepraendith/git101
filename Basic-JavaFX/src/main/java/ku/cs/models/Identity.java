package ku.cs.models;

public class Identity {

    private String MyFavPersonsName;
    private String TheirStatus;

    private String  DoYouLoveThem;

    private int yearthattheyreborn;

    public Identity( String name, String status){
        this.MyFavPersonsName = name;
        this.TheirStatus = status;
        DoYouLoveThem = "";

    }

    public Identity(String name, String status,String doyoulovethem) {
        this.MyFavPersonsName = name;
        this.TheirStatus = status;
        this.DoYouLoveThem = doyoulovethem;
    }
    public void SoDoYouLoveThem(String ans){
        if(!ans.equals("")){
            DoYouLoveThem = ans;
        }
    }

    public Identity( String name, String status, int yearthattheyreborn) {

        this.MyFavPersonsName = name;
        this.yearthattheyreborn = yearthattheyreborn;
        this.TheirStatus = status;

    }

    public boolean isName(String namw){
        return MyFavPersonsName.equals(namw);
    }

    public String getTheirStatus() {
        return TheirStatus;
    }

    public String getMyFavPersonsName() {
        return MyFavPersonsName;
    }

    public int getYearThatTheyreBorn() {
        return yearthattheyreborn;
    }

    public String getDoYouLoveThem(){return DoYouLoveThem;}

    public int CalAge() {
        return 2023-yearthattheyreborn ;
    }

    @Override
    public String toString() {
        return "{" +
                "Name: '" + MyFavPersonsName + '\'' +
                ", Status: '" + TheirStatus + '\'' +
                ", Love?: " + DoYouLoveThem +
                '}';
    }
}
