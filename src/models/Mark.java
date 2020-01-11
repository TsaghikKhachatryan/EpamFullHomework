package models;

import Exceptions.MarkOutOfRangeException;

public class Mark {
    private int value;
    private Subject subject;

    private Mark(MarkBuilder builder) {
        this.value = builder.value;
        this.subject = builder.subject;
    }

    public static class MarkBuilder {
        private int minMarkValue=0;
        private int maxMarkValue=10;
        private int value;
        private Subject subject;

        public MarkBuilder value(int value) {
            if(value<minMarkValue||value>maxMarkValue){
                throw new MarkOutOfRangeException(value);
            }
            this.value = value;
            return this;
        }

        public MarkBuilder subject(Subject subject) {
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

    public Subject getSubject() {
        return subject;
    }
}
