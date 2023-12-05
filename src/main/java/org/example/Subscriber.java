package org.example;

import java.util.List;

/**
 * Класс "Подписчик"
 */
public class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getObserverName() {
        return this.name;
    }

    @Override
    public void update(List<String> posts) {
        System.out.println("Подписчик " + name + ", видит следующие публикации: " + posts + "\n---------------");
    }
}
