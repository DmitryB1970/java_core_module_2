package org.javaacademy.core.module2.homework3.ex5;

import java.time.LocalDateTime;

public class Feedback {

    private int id;
    private String text;
    private int like;
    private LocalDateTime localDateTime;

    public int getId() {
        return id;
    }

    public int getLike() {
        return like;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getText() {
        return text;
    }

    public Feedback(int id, int like, LocalDateTime localDateTime, String text) {
        this.id = id;
        this.like = like;
        this.localDateTime = localDateTime;
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Feedback{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", like=").append(like);
        sb.append(", localDateTime=").append(localDateTime);
        sb.append('}');
        return sb.toString();
    }
}
