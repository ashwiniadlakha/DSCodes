/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import jdk.nashorn.internal.ir.LexicalContext;

/**
 * @author ashwini.adlakha
 * @version $Id: RoomRequired.java, v 0.1 2020-06-05 12:19 PM ashwini.adlakha Exp $$
 */
public class RoomRequired {


    static class TimeBoundary implements Comparable<TimeBoundary>{
        public int startTime;
        public int endTime;

        public TimeBoundary(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }


        @Override
        public int compareTo(TimeBoundary o) {
            return this.startTime - o.startTime;
        }
    }

    static class Room {
        public int startTime;
        public int endTime;

        static public PriorityQueue<Room> roomEndTimeHeap = new PriorityQueue<Room>(new RoomEndTimeComparator());


        public Room(int startTime, int endTime){
            this.endTime = endTime;
            this.startTime = startTime;
            roomEndTimeHeap.add(this);
        }
    }

    static class RoomStartTimeComparator implements Comparator<Room>{

        @Override
        public int compare(Room o1, Room o2) {
            if(o1.startTime > o2.startTime){
                return -1;
            }
            if(o1.startTime < o2.startTime){
                return 1;
            }

            return 0;
        }
    }


    static class RoomEndTimeComparator implements Comparator<Room>{


        @Override
        public int compare(Room o1, Room o2) {
            if(o1.endTime > o2.endTime){
                return 1;
            }

            if(o1.endTime < o2.endTime){
                return -1;
            }

            return 0;
        }
    }



    public static void main(String[] a){

        List<TimeBoundary> lectures = getInput();

        Collections.sort(lectures);

        List<Room> rooms = new ArrayList<Room>();

        for(TimeBoundary lecture : lectures){

            Room room = checkAndReturnIfExistingRoomCanBeUsed(lecture, rooms);
            if(room != null){
                assignInExistingRoom(lecture, room);
            }else{
                assignInNewRoom(lecture, rooms);
            }
        }

        System.out.println(rooms.size());

    }

    private static void assignInNewRoom(TimeBoundary lecture, List<Room> rooms) {
        Room room = new Room(lecture.startTime, lecture.endTime);
        rooms.add(room);
    }

    private static void assignInExistingRoom(TimeBoundary lecture, Room room) {
        room.endTime = lecture.endTime;
        Room.roomEndTimeHeap.add(room);
    }

    private static Room checkAndReturnIfExistingRoomCanBeUsed(TimeBoundary lecture, List<Room> rooms) {


        if(!rooms.isEmpty() && Room.roomEndTimeHeap.peek().endTime < lecture.startTime && Room.roomEndTimeHeap.peek().endTime < lecture.endTime ){
            return Room.roomEndTimeHeap.remove();
        }else{
            return null;
        }
    }

    static List<TimeBoundary> getInput(){
        //[(30, 75), (0, 50), (60, 150)]

        // [(30, 75), (0, 50), (60, 150), (80, 100)]

        /**
         *
         *
         * max(end time) of the class
         *
         * start time > database (min heap)
         *
         * room -> 0 -50 60-150
         *
         *
         *
         *  room 2->   30 -75 80 100
         *
         *  max(start time)
         *  min(endTime)
         *
         *
         * for(startTime : Heap.remove()){
         *      //0
         *      // 30
         *      // 60
         *      //80
         * }
         *
         *
         */

        List<TimeBoundary> lectures = new ArrayList<TimeBoundary>();
        TimeBoundary lecture1 = new TimeBoundary(30, 75);
        lectures.add(lecture1);
        TimeBoundary lecture2 = new TimeBoundary(0, 50);
        lectures.add(lecture2);
        TimeBoundary lecture3 = new TimeBoundary(60, 150);
        lectures.add(lecture3);
        lectures.add(new TimeBoundary(80, 100));

        return lectures;

    }
}