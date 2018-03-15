package model;

/**
 * Created by Vasu Jilagam on 3/14/2018 for TheatreSeating.
 */
public class Section {
    private int totalSeats;
    private int availableSeats;
    private int sectionNumber;
    private String assignedTo;

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getSectionNumberDesc() {
        return "Section "+sectionNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isPartyCapable(int requestedSeats) {
        return ( (availableSeats - requestedSeats == 0)
                || (availableSeats - requestedSeats > 1) ) ? true : false;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionNumber=" + sectionNumber +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}
