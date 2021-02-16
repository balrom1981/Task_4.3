package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue implements Comparable<Issue> {
    private int id;
    private boolean open;
    private String author;
    private String assignee;
    private String label;

    @Override
    public int compareTo(Issue o) {
        return 0;
    }
}
