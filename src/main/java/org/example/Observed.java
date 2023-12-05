package org.example;

public interface Observed {
    void addObserver(Subscriber observer);

    void removeObserver(Subscriber observer);

    void notifyObservers();
}
