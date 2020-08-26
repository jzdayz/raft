package io.github.jzdayz.raft;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class RaftNode {

    // 服务器最后一次知道的任期号（初始化为 0，持续递增）
    private long currentTerm;

    // 在当前获得选票的候选人的 Id
    private long votedFor;

    // 已知的最大的已经被提交的日志条目的索引值
    private long commitIndex;

    // 最后被应用到状态机的日志条目索引值
    private long lastApplied;

    private LogManager logManager;

    public RaftNode(LogManager logManager) {
        this.logManager = logManager;
    }
}
