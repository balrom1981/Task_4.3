package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.List;
import java.util.Set;

public class FilterManager {

    private final IssueRepository repository;

    public FilterManager(IssueRepository repository) {
        this.repository = repository;
    }

    public List<Issue> filterByStatus(boolean open) {
        return Issue;
    }

    ;

    public List<Issue> filterByAuthor(String author) {
        return Issue;
    }

    ;

    public List<Issue> filterByAssignee(String assignee) {
        return Issue;
    }

    ;

    public List<Issue> filterByLabel(Set<Label> labels) {
        return Issue;
    }

    ;
}
