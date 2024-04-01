package com.example.demo.singleton;

public class SingletonService {
    private final static SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }
}
