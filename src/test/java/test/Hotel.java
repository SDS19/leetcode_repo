package test;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Hotel {
    private Room[][] rooms;

    public Hotel() {
        rooms = new Room[3][10];
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++) {
                if (i==0) rooms[i][j] = new Room((i+1)*100+j+1, "single", true);
                else if (i==1) rooms[i][j] = new Room((i+1)*100+j+1, "standard", true);
                else rooms[i][j] = new Room((i+1)*100+j+1, "luxury", true);
            }
    }

    public void printStatus(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++)
                System.out.print(rooms[i][j]);
            System.out.println();
        }
    }

    public void checkIn(int roomNr){
        Room room = rooms[roomNr/100-1][roomNr%100-1];
        if (room.getRoomStatus()) {
            room.setRoomStatus(false);
            System.out.println(roomNr+" check in success!");
        } else System.out.println("This room is already checked in!");
    }

    public void checkOut(int roomNr){
        Room room = rooms[roomNr/100-1][roomNr%100-1];
        if (!room.getRoomStatus()) {
            room.setRoomStatus(true);
            System.out.println(roomNr+" check out success!");
        } else System.out.println("This room is free!");
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        System.out.println("功能代码：0.查看房间列表 1.Check In 2.Check Out 3.Exit");
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter function number: ");
            int i = s.nextInt();
            switch (i) {
                case 0: hotel.printStatus(); break;
                case 1:
                    System.out.print("Please enter room number: ");
                    hotel.checkIn(s.nextInt());
                    break;
                case 2:
                    System.out.print("Please enter room number: ");
                    hotel.checkOut(s.nextInt());
                    break;
                case 3:
                    System.out.println("Exit system success!");
                    return;
            }
        }
    }
}

class Room {
    private int roomNr;
    private String roomType;
    private boolean roomStatus;

    public Room() {
    }

    public Room(int roomNr, String roomType, boolean roomStatus) {
        this.roomNr = roomNr;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public String toString() {
        return  "[" + roomNr +
                ", " + roomType +
                ", " + (roomStatus ? "free" : "occupied") +
                ']';
    }
}
