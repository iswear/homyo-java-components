package com.homyo.components.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static class User implements Serializable, Bson {

        private static final long serialVersionUID = 7468167149667657217L;

        private String name;

        private String pwd;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        @Override
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> aClass, CodecRegistry codecRegistry) {
            return null;
        }
    }


    public static void main(String[] args) {
        MongoClient client = new MongoClient("vm-docker", 27017);
        MongoDatabase database = client.getDatabase("user_system");
        MongoCollection collection = database.getCollection("user");

        Document document = new Document();
        document.put("name", "yaya");
        document.put("pwd", "123456");
        collection.insertOne(document);

        List<Document> documents = new ArrayList<>();
        collection.find(Filters.eq("name", "yaya")).into(documents);
        System.out.println(documents);
    }
}
