package ku.cs.models;

public class Identity {

    private String myfavpersonsname;
    private String theirstatus;
    private double myfavnumber;

    public Identity( String name, String status, double myfavnumber) {

        this.myfavpersonsname = name;
        this.myfavnumber = myfavnumber;
        this.theirstatus = status;

    }

    public String getTheirStatus() {
        return theirstatus;
    }

    public String getMyFavPersonsName() {
        return myfavpersonsname;
    }

    public double getMyFavNumber() {
        return myfavnumber;
    }

    public double calculateSquare() {
        return myfavnumber * myfavnumber;
    }

    public double calculateCube() {
        return myfavnumber * myfavnumber * myfavnumber;
    }


}
