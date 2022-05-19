package io.conferencer.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Vote extends PanacheEntity {

    @ManyToOne
    SessionAbstract sessionAbstract;

    @ManyToOne
    Reviewer reviewer;

    public Vote(SessionAbstract sessionAbstract, Reviewer reviewer) {
        this.sessionAbstract = sessionAbstract;
        this.reviewer = reviewer;
    }

    public Vote() {
    }

    @Override
    public String toString() {
        return "Vote{" +
                "sessionAbstract=" + sessionAbstract +
                ", reviewer=" + reviewer +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (sessionAbstract != null ? !sessionAbstract.equals(vote.sessionAbstract) : vote.sessionAbstract != null)
            return false;
        return reviewer != null ? reviewer.equals(vote.reviewer) : vote.reviewer == null;
    }

    @Override
    public int hashCode() {
        int result = sessionAbstract != null ? sessionAbstract.hashCode() : 0;
        result = 31 * result + (reviewer != null ? reviewer.hashCode() : 0);
        return result;
    }

    public SessionAbstract getSessionAbstract() {
        return sessionAbstract;
    }

    public void setSessionAbstract(SessionAbstract sessionAbstract) {
        this.sessionAbstract = sessionAbstract;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
}

