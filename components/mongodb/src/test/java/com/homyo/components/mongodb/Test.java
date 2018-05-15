package com.homyo.components.mongodb;

import com.homyo.components.mongodb.test.domin.UserDO;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    /**
     * 原生客户端
     * @param args
     */
//    public static void main(String[] args) {
//        MongoClient client = new MongoClient("vm-docker", 27017);
//        MongoDatabase database = client.getDatabase("user_system");
//        MongoCollection collection = database.getCollection("user");
//
//        for (int i = 0 ; i < 1000; ++i) {
//            Document document = new Document();
//            document.put("name", "yaya");
//            document.put("pwd", "123456");
//            collection.insertOne(document);
//        }
//
//        List<Document> documents = new ArrayList<>();
//        collection.find(Filters.and(Filters.eq("name", "yaya"))).limit(10).into(documents);
//        System.out.println(documents);
//    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MongoOperations operations = new MongoTemplate(new MongoClient("vm-docker", 27017), "system_user");
        UserDO user = new UserDO();
        user.setUserName("111");
        user.setUserPwd("123456");
        operations.insert(user);
        System.out.println("end");
    }
}
