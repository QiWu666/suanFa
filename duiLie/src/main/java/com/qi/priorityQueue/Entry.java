package com.qi.priorityQueue;

public class Entry implements Priority {
    private Integer priority;
    private String text;
    @Override
    public int priority() {
        return this.priority;
    }

    public Entry(Integer priority, String text) {
        this.priority = priority;
        this.text = text;
    }

    public Entry(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "priority=" + priority +
                ", text='" + text + '\'' +
                '}';
    }
}
