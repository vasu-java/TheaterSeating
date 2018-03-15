package model;

/**
 * Created by vjilag200 on 3/13/2018 for JavaTestProject.
 */
public class Request {
    private String name;
    private int noOfSeats;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name +" "+  status;
    }
}
