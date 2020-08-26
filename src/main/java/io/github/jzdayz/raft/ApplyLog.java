package io.github.jzdayz.raft;

import lombok.Data;

import java.util.List;

@Data
public class ApplyLog<T> {
    // 领导人的任期号
    private long term;
    // 领导人的 Id，以便于跟随者重定向请求
    private long leaderId;
    // 新的日志条目紧随之前的索引值
    private long prevLogIndex;
    // 	prevLogIndex 条目的任期号
    private long prevLogTerm;
    // 领导人已经提交的日志的索引值
    private long leaderCommit;
    // 提交的数据
    private List<T> entries;
}
