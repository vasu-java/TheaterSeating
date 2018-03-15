package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vasu Jilagam on 3/14/2018 for TheaterSeating.
 */
public class Theater {
    private List<Row> rows;
    private List<Request> requests;
    private int totalSeats;

    public int getTotalSeats() {
        totalSeats = 0;
        for(Row row : rows)
            totalSeats += row.getTotalSeats();

        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public Theater initTheatre(Theater theater, List<String> rowsData, List<String> requestsData) {
        int rowNumber = 0;
        rows = new ArrayList<>();
        requests = new ArrayList<>();

        for(String rowStr : rowsData) {
            rowNumber++;
            Row row = prepareRowObject(rowStr, rowNumber);
            addRow(row);
        }

        for(String requestStr : requestsData) {
            Request request = prepareSeatingRequestObj(requestStr);
            addRequest(request);
        }

        return theater;
    }

    private Row prepareRowObject(String nextLine, int rowNum) {
        Row row = new Row();
        row.setRowNumber(rowNum);
        int[] seatSections = Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        row.setSections(row.prepareSections(seatSections));
        return row;
    }

    public Request prepareSeatingRequestObj(String nextLine) {
        List<String> items = Arrays.asList(nextLine.split("\\s+"));
        Request seatingRequest = new Request();
        seatingRequest.setName(items.get(0));
        seatingRequest.setNoOfSeats(Integer.parseInt(items.get(1)));

        return seatingRequest;
    }

    public void processSeatingRequests() {
        for( Request seatingRequest : requests) {
            //LOGGER.debug("*******Request : "+seatingRequest.getName());
            assignSeats(seatingRequest);
            if(seatingRequest.getStatus() == null) {
                if(getTotalSeats() >= seatingRequest.getNoOfSeats()) {
                    seatingRequest.setStatus(ErrorsEnum.SPLIT.getErrorDsc());
                } else
                    seatingRequest.setStatus(ErrorsEnum.CANT_HANDLE.getErrorDsc());
            }
            //LOGGER.debug(seatingRequest.getStatus());
        }
    }

    public Request assignSeats(Request request) {
        boolean flag = false;
        for(Row row : rows) {
            for(Section section : row.getSections()) {
                flag = section.isPartyCapable(request.getNoOfSeats());
                if(flag) {
                    section.setAvailableSeats(section.getTotalSeats()-request.getNoOfSeats());
                    request.setStatus(row.getRowNumberDesc()+" "+section.getSectionNumberDesc());

                    break;
                }
            }
            if(flag)
                break;
        }

        return request;
    }
}
