package models;

import Exceptions.MarkOutOfRangeException;

public class Mark {
    private int value;
    private String subject;

    private Mark(MarkBuilder builder) {
        this.value = builder.value;
        this.subject = builder.subject;
    }

    public static class MarkBuilder {
        private int minMarkValue=0;
        private int maxMarkValue=10;
        private int value;
        private String subject;

        public MarkBuilder value(int value) {
            if(value<minMarkValue||value>maxMarkValue){
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
            Mark m = new Mark(this);
            return m;
        }

    }

    public int getValue() {
        return value;
    }

    public String getSubject() {
        return subject;
    }
}
