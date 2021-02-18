package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    private int id;
    private boolean open;
    private Collection<String> author;
    private Collection <String> assignee;
    private Collection <String> label;



}
