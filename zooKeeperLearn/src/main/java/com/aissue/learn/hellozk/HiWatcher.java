package com.aissue.learn.hellozk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class HiWatcher implements Watcher{

    public void process(WatchedEvent watchedEvent) {
        System.out.println("aissueWatcher is moving ... "+watchedEvent.getType().name());
    }
}
