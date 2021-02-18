package ru.netology.domain;

import java.util.Collection;
import java.util.function.Predicate;

public class IssueAscPredicat implements Predicate<Issue> {

    @Override
    public boolean test(Issue issue) {
        return false;
    }

    public Predicate<Issue> sortAuthor(Issue issue) {
        return author -> author.getAuthor() == author;
    }

    public Predicate<Issue> sortAssignee(Issue issue) {
        return assignee -> assignee.getAssignee() == assignee;
    }

    public Predicate<Issue> sortLabel(Issue issue) {
        return label -> label.getAssignee() == label;
    }

 }
