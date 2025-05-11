package com.cd.TestSpring.repository;

import com.cd.TestSpring.entity.StudentEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentEntry, String> {


}
