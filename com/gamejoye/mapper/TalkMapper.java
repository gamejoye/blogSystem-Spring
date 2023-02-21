package com.gamejoye.mapper;

import com.gamejoye.pojo.Talk;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TalkMapper {
    List<Talk> selectAllTalksByName(String name);
    void deleteTalk(int id);
    void postTalk(Talk talk);
}
