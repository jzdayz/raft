package io.github.jzdayz.raft;

import lombok.Data;

@Data
public class Log {
    // 日志对应的任期
    private long term;
}
