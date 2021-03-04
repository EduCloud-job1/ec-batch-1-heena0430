package com.heena.ec.multithread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MultiThread
extends Thread {
int fileNumber = 1;

public static void main(String[] args) {
    startMergingfiles(9);
}

public MultiThread(int fileNum) {
    fileNumber = fileNum;
}

public static void startMergingfiles(int numberOfFiles) {
    int objectcounter = 0;

    while (numberOfFiles != 1) {
        try {
            ArrayList<MultiThread> objectList = new ArrayList<MultiThread>();
            for (int j = 1; j <= numberOfFiles; j = j + 2) {
                if (numberOfFiles == j) {// Last Single remaining File

                } else {
                    objectList.add(new MultiThread(j));
                    objectList.get(objectcounter).start();
                    objectList.get(objectcounter).join();
                    objectcounter++;
                }
            }
            objectcounter = 0;
            numberOfFiles = numberOfFiles / 2;

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

public void run() {

    try {
        FileReader fileReader1 = new FileReader("https://s3.ap-south-1.amazonaws.com/const.educloud.in/api/studentAndCourseJSON.json" + Integer.toString(1));
        FileReader fileReader2 = new FileReader("https://s3.ap-south-1.amazonaws.com/const.educloud.in/api/CourseAndExamsJSON.json" + Integer.toString(2));
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        String line1 = bufferedReader1.readLine();
        String line2 = bufferedReader2.readLine();

        FileWriter tmpFile = new FileWriter(" https://s3.ap-south-1.amazonaws.com/const.educloud.in/api/ExamAndExamResultsJSON.json" + Integer.toString(3) + "op.txt", false);
        int whichFileToRead = 0;

        boolean file_1_reader = true;
        boolean file_2_reader = true;

        while (file_1_reader || file_2_reader) {
            if (file_1_reader == false) {
                tmpFile.write(line2 + "\r\n");
                whichFileToRead = 2;
            } else if (file_2_reader == false) {
                tmpFile.write(line1 + "\r\n");
                whichFileToRead = 1;
            } else {
                String value1 = line1.substring(0, 10);
                String value2 = line2.substring(0, 10);
                int ans = value1.compareTo(value2);
                if (ans < 0) {
                    tmpFile.write(line1 + "\r\n");
                    whichFileToRead = 1;
                } else if (ans > 0) {
                    tmpFile.write(line2 + "\r\n");
                    whichFileToRead = 2;
                } else if (ans == 0) {
                    tmpFile.write(line1 + "\r\n");
                    whichFileToRead = 1;
                }
            }

            if (whichFileToRead == 1) {
                line1 = bufferedReader1.readLine();
                if (line1 == null)
                    file_1_reader = false;
            } else {
                line2 = bufferedReader2.readLine();
                if (line2 == null)
                    file_2_reader = false;

            }
        }

        tmpFile.close();
        bufferedReader1.close();
        bufferedReader2.close();
        fileReader1.close();
        fileReader2.close();

    } catch (Exception e) {
        System.out.println(e);
    }

 }
}