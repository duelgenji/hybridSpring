package com.duelgenji.hybridSpring.neo4j;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Movie {

    @Id
    @GeneratedValue
    Long id;
    String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    Person director;

//    @Relationship(type="ACTS_IN", direction = Relationship.INCOMING)
//    Set<Person> actors;
//
//    @Relationship(type = "RATED")
//    List<Rating> ratings;
}