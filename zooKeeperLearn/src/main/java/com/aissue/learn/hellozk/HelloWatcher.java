package com.aissue.learn.hellozk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class HelloWatcher implements Watcher{

    public void process(WatchedEvent watchedEvent) {
        System.out.println("HelloWatcher is moving ... "+watchedEvent.getType().name());
    }
}
