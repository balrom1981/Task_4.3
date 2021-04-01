package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterManager {

    private final IssueRepository repository;

    public FilterManager(IssueRepository repository) {
        this.repository = repository;
    }

    public List<Issue> filterByStatus(boolean open) {
        List<Issue> issues = repository.findAll();
        return issues.stream()
                .filter((Issue i)-> i.isOpen() == open)
                .collect(Collectors.toList());
    }

    ;

    public List<Issue> filterByAuthor(String author) {
        List<Issue> issues = repository.findAll();
        return issues.stream()
                .filter((Issue i)-> i.getAuthor() == author)
                .collect(Collectors.toList());
    }

    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> issues = repository.findAll();
        return issues.stream()
                .filter((Issue i)-> i.getAssignee() == assignee)
                .collect(Collectors.toList());
    }

//    public List<Issue> filterByLabel(Set<Label> labels) {
//        return Issue;
//    }
}
