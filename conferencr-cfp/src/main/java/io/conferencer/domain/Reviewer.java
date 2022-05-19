package io.conferencer.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Reviewer extends PanacheEntity {

    @Column(unique = true)
    String email;

    public Reviewer(String email) {
        this.email = email;
    }

    public Reviewer() {
    }

    @Override
    public String toString() {
        return "Reviewer{" +
                "email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviewer reviewer = (Reviewer) o;

        return email != null ? email.equals(reviewer.email) : reviewer.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
