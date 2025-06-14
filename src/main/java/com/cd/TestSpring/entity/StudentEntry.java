package com.cd.TestSpring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "student_entries")

//@Getter
//@Setter
@Data
@NoArgsConstructor
public class StudentEntry {
    @Id
    private ObjectId id;

    private String name;

    private String title;

    private LocalDateTime date;

//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public LocalDateTime getDate(){
//        return date;
//    }
//
//    public void setDate(LocalDateTime date){
//        this.date = date;
//    }
}
