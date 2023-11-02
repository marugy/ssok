package com.ssok.namecard.domain.mongo.repository;


import com.ssok.namecard.domain.mongo.document.Namecard;
import com.ssok.namecard.domain.mongo.document.TestUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NamecardMongoRepository extends MongoRepository<TestUser, String> {

    TestUser findByName(String name);
}