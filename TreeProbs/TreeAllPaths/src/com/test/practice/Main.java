package com.test.practice;


import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.lang.Package;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;


public class Main {

    static int runSum = 0;
    static int curMax = 0;


    private static class Coord {
        private int x;
        private int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int passedVal) {
            x = passedVal;
        }

        public void setY(int passedVal) {
            y = passedVal;
        }

    }


    static int getLeftIndex(Coord curCordinate, ArrayList treeAsArray, Coord returnCordinate) {
        int xindex, yindex;
        xindex = curCordinate.getX();
        yindex = curCordinate.getY();

        xindex = xindex + 1;

        int indexInArr = (xindex * (xindex + 1) / 2) + yindex;
        if (indexInArr < treeAsArray.size()) {
            returnCordinate.setX(xindex);
            returnCordinate.setY(yindex);
            return 0;
        } else {

            return -1;
        }
    }

    static int getRightIndex(Coord curCordinate, ArrayList treeAsArray, Coord returnCordinate) {


        int xindex, yindex;
        xindex = curCordinate.getX();
        yindex = curCordinate.getY();

        xindex = xindex + 1;
        yindex = yindex + 1;

        int indexInArr = (xindex * (xindex + 1) / 2) + yindex;
        if (indexInArr < treeAsArray.size()) {
            returnCordinate.setX(xindex);
            returnCordinate.setY(yindex);
            return 0;
        } else {

            return -1;
        }
    }


    static int getValue(ArrayList treeAsArray, Coord curCordinate) {

        int xindex, yindex;
        xindex = curCordinate.getX();
        yindex = curCordinate.getY();
        if (xindex == 0 && yindex == 0) {
            return (int) (treeAsArray.get(0));
        }

        if (xindex == 1 && yindex == 0) {

            return (int) (treeAsArray.get(1));

        }

        if (xindex == 1 && yindex == 1) {

            return (int) (treeAsArray.get(2));

        }

        int indexInArr = (xindex * (xindex + 1) / 2) + yindex;

        if (indexInArr >= treeAsArray.size() || indexInArr <= -1) {
            System.out.println("odd: " + indexInArr + " " + xindex + " " + yindex);
        }
        if (indexInArr < treeAsArray.size()) {
            return (int) (treeAsArray.get(indexInArr));
        } else {
            return -1;
        }


    }


    static void traversepath(Coord curCordinate, ArrayList treeAsArray) {


        int xindex, yindex;
        xindex = curCordinate.getX();
        yindex = curCordinate.getY();

        /* do the accounting summing up the value for curIndex */
        runSum = runSum + (int) getValue(treeAsArray, curCordinate);

        int totalNodes = treeAsArray.size();
        Coord leftchildCordinate = new Coord(-1, -1);
        Coord rightchildCordinate = new Coord(-1, -1);
        int lchildIndex = getLeftIndex(curCordinate, treeAsArray, leftchildCordinate);
        int rchildIndex = getRightIndex(curCordinate, treeAsArray, rightchildCordinate);

        System.out.println("Cur cordinate: " + curCordinate.getX() + " " + curCordinate.getY() + " " + "Ret:" + lchildIndex + "Left coordinate: " + leftchildCordinate.getX() + " " + leftchildCordinate.getY());
        System.out.println("Ret" + rchildIndex + "Right coordinate: " + rightchildCordinate.getX() + " " + rightchildCordinate.getY());

        if ((lchildIndex == -1) && (rchildIndex == -1)) {
            if (runSum > curMax) {
                curMax = runSum;
            }


            /* ok we traversed the path backtrack now*/
            runSum = runSum - (int) getValue(treeAsArray, curCordinate);
            return;
        }


        traversepath(leftchildCordinate, treeAsArray);
        traversepath(rightchildCordinate, treeAsArray);

        /* ok we traversed the path backtrack now*/
        runSum = runSum - (int) (getValue(treeAsArray, curCordinate));

    }

    static void traverseAllPaths(ArrayList treeAsArray) {


        curMax = 0;
        runSum = 0;

        traversepath(new Coord(0, 0), treeAsArray);

        System.out.println("The maximum is " + curMax);


    }


    //http://wcipeg.com/problem/ioi9411

    public static void main(String args[]) {
        try {
            File dir = new File(".");
            File fIn = new File(dir.getCanonicalPath() + File.separator + "in_wcipeg.txt");
            FileInputStream fIs = new FileInputStream(fIn);

            BufferedReader br = new BufferedReader(new InputStreamReader(fIs));

            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            line = br.readLine();
            int numLevels = Integer.parseInt(line);

            //construct_tree

            ArrayList<Integer> treeAsArray = new ArrayList<Integer>();

            for (int i = 0; i < numLevels; i++) {
                line = br.readLine();
                String[] strsplit = line.split(" ");
                for (int j = 0; j < strsplit.length; j++) {

                    treeAsArray.add(Integer.parseInt(strsplit[j]));
                }
            }

            traverseAllPaths(treeAsArray);


        } catch (IOException e) {
            System.out.println(" IO exception ");
        }


    }
}
