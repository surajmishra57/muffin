package org.example.desing_patterns.behavioral.b4_iterator_pattern;

import org.example.lld_interview_problems.parkinglot.ParkingFloor;

public class MusicPlayer {
    public static void main(String[] args) {
        PlayList playList = new PlayList();
        playList.addSong("i found the pen");
        playList.addSong("tum kyu chle");
        playList.addSong("main kya kru");
        playList.addSong("you and i ");

        Iterator<String> iterator = playList.createIterator();
        while (iterator.hasNext()) {
            System.out.println("playing : " + iterator.next());
        }
    }
}
