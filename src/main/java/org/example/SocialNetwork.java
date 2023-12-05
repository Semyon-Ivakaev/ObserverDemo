package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс "Социальная сеть"
 */
public class SocialNetwork implements Observed {
    // Список постов
    private final List<String> posts = new ArrayList<>();
    // Список подписчиков
    private final List<Subscriber> subscribers = new ArrayList<>();

    public List<Subscriber> getSubscribers() {
        return this.subscribers;
    }

    public void addPost(String post) {
        this.posts.add(post);
        notifyObservers();
    }

    public void removePost(String post) {
        this.posts.remove(post);
        notifyObservers();
    }

    @Override
    public void addObserver(Subscriber observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Subscriber observer) {
        subscribers.remove(observer);
        System.out.println("''''''");
        System.out.println("Заблокирован пользователь: " + observer.getObserverName());
        System.out.println("''''''");
    }

    @Override
    public void notifyObservers() {
        this.subscribers.forEach(observer -> observer.update(this.posts));
    }
}
