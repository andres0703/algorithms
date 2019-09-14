package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataProcessor {
    private static final String ERROR_MESSAGE = "\nInvalid data set: No.";
    private static final double PI = 3.14;
    private static final double PSI = 6.84845;
    private static final double ZETA = 3.26;
    private final Map<Character, Double> map = new HashMap<>();

    private final String[] data;      // original data stored in string array
    private final int numberOfSets;   // total number of sets
    private int p;              // pointer of the string array
    private int setIdx;         // index of data set

    public DataProcessor(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        numberOfSets = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        // store data in file to a string array
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String s1 = s.replace(" ", "");
            if (s1.length() == 0) continue;  // skip blank line
            list.add(s);
        }
        data = (String[]) list.toArray(new String[0]);

        // construct map
        map.put('a', 3.1);
        map.put('b', 4.1);
        map.put('c', 6.0);

        processData();
    }

    private void processData() {

        Outerloop:
        while (p < data.length) {
            assert data[p].charAt(0) == '*';

            String[] setInfo = data[p].substring(1).split("\\s+");

            p++; setIdx++;
            int numOfRecords = Integer.parseInt(setInfo[0]);
            int numOfElements = Integer.parseInt(setInfo[1]);

            // get the number of the current data set records
            int count = 0;
            while (p + count < data.length && data[p + count].charAt(0) != '*') {
                count++;
            }

            // if number of records is incorrect
            if (count != numOfRecords) {
                System.out.println(ERROR_MESSAGE + setIdx);
                p += count;
                continue;
            }

            // check if every data record has the correct number of elements
            for (int i = 0; i < numOfRecords; i++) {
                String[] arr = data[p + i].split("\\s+");
                if (arr.length != numOfElements) {
                    System.out.println(ERROR_MESSAGE + setIdx);
                    p += numOfRecords;
                    continue Outerloop;
                }
            }

            // by this point, the number of data records and number of elements in each record are correct
            try {
                if (numOfElements == 2)       printTwo(p, numOfRecords);
                else if (numOfElements == 3)  printThree(p, numOfRecords);
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MESSAGE + setIdx);
            }

            p += numOfRecords;  // move the pointer to the next data group control line
        }
    }

    // console output if number of elements in records is 2
    private void printTwo(int idx, int numberOfRecords) throws NumberFormatException {

        double sumOfResults = 0.0;
        String output = "\nValid data set: " + setIdx;

        for (int i = 0; i < numberOfRecords; i++) {
            String[] arr = data[idx + i].split("\\s+");
            double[] nums = new double[2];
            nums[0] = Double.parseDouble(arr[0]);
            nums[1] = Double.parseDouble(arr[1]);

            double avg = (nums[0] + nums[1]) / 2;
            double form = PI * PI * nums[0] + PSI * (2.44 + Math.pow(nums[1], 3)) * 3;
            sumOfResults += form;

            output += "\nAVG = " + String.format("%.3f", avg);
            output += ", FORM = " + String.format("%.3f", form);
        }

        double avgOfResult = sumOfResults / numberOfRecords;
        output += "\nAverage of results = " + String.format("%.3f", avgOfResult);
        output += "\nNumber of records in this data set: " + numberOfRecords;

        System.out.println(output);
    }

    // console output if number of elements in records is 3
    private void printThree(int idx, int numberOfRecords) throws NumberFormatException {
        double sumOfResults = 0.0;
        String output = "\nValid data set: " + setIdx;

        for (int i = 0; i < numberOfRecords; i++) {
            String[] arr = data[idx + i].split("\\s+");
            double[] nums = new double[3];
            nums[0] = Double.parseDouble(arr[0]);
            nums[1] = Double.parseDouble(arr[1]);

            // get the third parameter by letter -> number mapping
            try {
                nums[2] = Double.parseDouble(arr[2]);
            } catch (NumberFormatException e) {
                if (arr[2].length() > 1 || !map.containsKey(arr[2].charAt(0))) {
                    nums[2] = map.get('a');
                } else {
                    nums[2] = map.get(arr[2].charAt(0));
                }
            }

            double avg = (nums[0] + nums[1] + nums[2]) / 3;
            double form = PI * PI * nums[0] + PSI * (2.44 + Math.pow(nums[1], 3)) * 3 + (Math.pow(ZETA, nums[2]) / nums[1]) * Math.log(nums[2]);
            sumOfResults += form;

            output += "\nAVG 33 = " + String.format("%.3f", avg);
            output += ", FORM 33 = " + String.format("%.3f", form);
        }

        double avgOfResult = sumOfResults / numberOfRecords;
        output += "\nAverage of results = " + String.format("%.3f", avgOfResult);
        output += "\nNumber of records in this data set: " + numberOfRecords;

        System.out.println(output);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        DataProcessor dataProcessor = new DataProcessor(file);
        dataProcessor.processData();
    }
}
