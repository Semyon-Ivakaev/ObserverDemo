package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SocialNetwork socialNetwork = new SocialNetwork();
        List<Subscriber> users = new ArrayList<>();
        users.add(new Subscriber("User1"));
        users.add(new Subscriber("User2"));
        users.add(new Subscriber("User3"));

        users.forEach(socialNetwork::addObserver);
        //region Расшифровка
        socialNetwork.addObserver(new Subscriber("User1"));
        socialNetwork.addObserver(new Subscriber("User2"));
        socialNetwork.addObserver(new Subscriber("User3"));
        //endregion

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("'Добавить' или 'Удалить' пост? А еще ты можешь 'Заблокировать' пользователя");
            String action = scanner.nextLine();
            System.out.println("---------------");

            if ("Добавить".equals(action)) {
                System.out.println("Введите текст нового поста:");
                String addPostText = scanner.nextLine();
                System.out.println("---------------");

                socialNetwork.addPost(addPostText);
            } else if ("Удалить".equals(action)) {
                System.out.println("Введите пост, который хотите удалить:");
                String removePostText = scanner.nextLine();
                System.out.println("---------------");

                socialNetwork.removePost(removePostText);
            } else if ("Заблокировать".equals(action)) {
                System.out.println("Введите имя подписчика, которого хотите заблокировать:");
                String blockUserName = scanner.nextLine();
                System.out.println("---------------");

                List<Subscriber> subscribers = socialNetwork.getSubscribers();
                List<Subscriber> subscribersForRemove = new ArrayList<>();
                subscribers.forEach(subscriber -> {
                    String name = subscriber.getObserverName();
                    if (name.equals(blockUserName)) {
                        subscribersForRemove.add(subscriber);
                    }
                });

                subscribersForRemove.forEach(socialNetwork::removeObserver);

            } else {
                System.out.println("Программа завершила своё выполнение");
                break;
            }
        }
        scanner.close();
    }
}