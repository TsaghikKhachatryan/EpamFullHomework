package com.epam.models;

import com.epam.exceptions.MarkOutOfRangeException;

public class Mark {

    private static final int MIN_MARK_VALUE =0;
    private static final int MAX_MARK_VALUE =10;

    private int value;
    private String subject;

    private Mark(MarkBuilder builder) {
        this.value = builder.value;
        this.subject = builder.subject;
    }

    public static class MarkBuilder {
        private int value;
        private String subject;

        public MarkBuilder value(int value) {
            if(value<MIN_MARK_VALUE||value>MAX_MARK_VALUE){
                throw new MarkOutOfRangeException(value);
            }
            this.value = value;
            return this;
        }

        public MarkBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Mark build() {
            Mark mark = new Mark(this);
            return mark;
        }

    }

    public int getValue() {
        return value;
    }

    public String getSubject() {
        return subject;
    }
}
