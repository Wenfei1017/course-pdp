package edu.neu.ccs.cs5010;

public class SkierInfo {
    private String skierID;
    private String liftID;
    private String timestamp;

    public SkierInfo(String skierID){
        this.skierID = skierID;
    }

    public void setLiftIDandTimestamp(String liftID, String timestamp){
        this.liftID = liftID;
        this.timestamp = timestamp;
    }

    public String getLiftID(){
        return liftID;
    }

    public String getTimestamp(){
        return getTimestamp();
    }
}
