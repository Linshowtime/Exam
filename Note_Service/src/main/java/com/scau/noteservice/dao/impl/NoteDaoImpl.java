package com.scau.noteservice.dao.impl;

import com.scau.noteservice.dao.NoteDao;
import com.scau.noteservice.model.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author showtime
 * @version V1.0
 * @date 2019-03-07 17:17
 */
@Component
public class NoteDaoImpl implements NoteDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveNote(NoteEntity noteEntity) {
        Query query=new Query(Criteria.where("registerNo").is(noteEntity.getRegisterNo()));
        Update update = Update.update("title",noteEntity.getTitle()).set("content",noteEntity.getContent());
        mongoTemplate.upsert(query,update,"noteEntity");
    }
    @Override
    public NoteEntity findNoteByRegisterNo(String registerNo) {
        Query query=new Query(Criteria.where("registerNo").is(registerNo));
        return mongoTemplate.findOne(query , NoteEntity.class);
    }
}
