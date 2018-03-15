package main;

import model.Theater;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vasu Jilagam on 3/14/2018 for JavaTestProject.
 */
public class ProcessTheaterSeating {
    public static void main(String[] args) {
        Theater theater = readFilePrepareTheatreObj();

        theater.processSeatingRequests();

        printOutPut(theater);
    }

    private static Theater readFilePrepareTheatreObj() {
        boolean requestDataStarted = false;
        List<String> rowsData = new ArrayList<>();
        List<String> requestsData = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./src/main/resources/seating.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();

            if(nextLine != null && nextLine.trim().length() == 0) {
                requestDataStarted = true;
                continue;
            }

            if(requestDataStarted) {
                requestsData.add(nextLine);
            } else {
                rowsData.add(nextLine);
            }
        }

        Theater theater = new Theater();
        theater = theater.initTheatre(theater, rowsData, requestsData);
        return theater;
    }

    private static void printOutPut(Theater theater) {
        theater.getRequests().stream().forEach(p -> System.out.println(p));
    }
}
