package io.github.jzdayz.raft;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
@AllArgsConstructor
@Slf4j
public class RaftController {

    private RaftNode currentNode;

    // 日志复制
    @RequestMapping("")
    public Object applyLog(@RequestBody ApplyLog<?> requestLog){
        // 如果 term < currentTerm 就返回 false
        if (requestLog.getTerm() < currentNode.getCurrentTerm()){
            return R.error();
        }
        // 如果日志在 prevLogIndex 位置处的日志条目的任期号和 prevLogTerm 不匹配，则返回 false
        Log prevLog = currentNode.getLogManager().get(requestLog.getPrevLogIndex());
        if (prevLog.getTerm() != requestLog.getPrevLogTerm()){
            return R.error();
        }
    }
    // 领导选举
}
