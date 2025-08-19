package org.example.desing_patterns.behavioral.b4_iterator_pattern;

public class PlayListIterator implements Iterator<String> {
    private final PlayList playList;
    private int index = 0;

    public PlayListIterator(PlayList playList) {
        this.playList = playList;
    }

    @Override
    public boolean hasNext() {
        return playList.getSize() > index;
    }

    @Override
    public String next() {
        return playList.getSong(index++);
    }
}
