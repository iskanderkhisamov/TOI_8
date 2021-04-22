package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="greeting")
public class Greeting {

    @Id
    private Long id;
    private String content;

    public Greeting() {

    }

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(id, greeting.id) && Objects.equals(content, greeting.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }
}