package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasu Jilagam on 3/14/2018 for TheatreSeating.
 */
public class Row {
    private List<Section> sections;
    private int totalSeats;
    private int rowNumber;

    @Override
    public String toString() {
        return "Row{" +
                "rowNumber=" + rowNumber +
                ", totalSeats=" + getTotalSeats() +
                ", sections=" + sections +
                '}';
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getRowNumberDesc() {
        return "Row "+rowNumber;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getTotalSeats() {
        totalSeats = 0;
        for(Section section : sections)
            totalSeats += section.getTotalSeats();

        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public List<Section> prepareSections(int[] seatSections) {
        int sectionNum = 0;
        sections = new ArrayList<Section>();
        for (int seats : seatSections) {
            sectionNum++;
            Section section = new Section();
            section.setTotalSeats(seats);
            section.setAvailableSeats(seats);
            section.setSectionNumber(sectionNum);
            addSection(section);
        }
        return sections;
    }
}
