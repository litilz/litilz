package com.ecommerce.repos.entity;


import javax.persistence.*;

@Entity
@Table(name = "q_a")
public class Q_AEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;


    @Basic(optional = false)
    @Column(name = "question")
    private String question;

    @Basic(optional = false)
    @Column(name = "answer")
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
