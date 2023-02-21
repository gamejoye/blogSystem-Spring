package com.gamejoye.service;

import com.gamejoye.mapper.TalkMapper;
import com.gamejoye.pojo.Talk;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "DynamicService")
public class DynamicService {
    @Autowired
    SqlSessionTemplate sqlSession;

    @Autowired
    TalkMapper talkMapper;
    public List<Talk> getAllTalksByName(String name) {
        return talkMapper.selectAllTalksByName(name);
    }

    public void deleteTalk(int id) {
        talkMapper.deleteTalk(id);
    }

    public void postTalk(Talk talk) {
        talkMapper.postTalk(talk);
    }
}
