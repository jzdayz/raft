package io.github.jzdayz.raft;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LogManager {

    private Map<Long, Log> indexLog = new HashMap<>();

    public Log get(long index) {
        return indexLog.get(index);
    }

}
