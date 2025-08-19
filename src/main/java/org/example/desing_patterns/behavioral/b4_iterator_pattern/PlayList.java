package org.example.desing_patterns.behavioral.b4_iterator_pattern;

import java.util.ArrayList;
import java.util.List;

public class PlayList implements IteratorCollection<String> {

    private final List<String> songs = new ArrayList<>();

    public void addSong(String song) {
        this.songs.add(song);
    }

    public String getSong(int index) {
        return this.songs.get(index);
    }

    public int getSize() {
        return this.songs.size();
    }


    @Override
    public Iterator<String> createIterator() {
        return new PlayListIterator(this);
    }
}
