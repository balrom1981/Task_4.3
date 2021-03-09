package ru.netology.manager;

import ru.netology.domain.Issue;

import ru.netology.repository.IssueRepository;

import java.util.List;

public class SortManagerIssue {
    public static final short NEWEST_FIRST = 0;
    public static final short OLDEST_FIRST = 1;

    private final IssueRepository repository;

    public SortManagerIssue(IssueRepository repository) {
        this.repository = repository;
    }

    public List<Issue> sort(short orderBy) {
        List<Issue> items = repository.findAll();
        items.sort((Issue i1, Issue i2) -> {
            if(i1.getId() == i2.getId()) return 0;
            if (orderBy == OLDEST_FIRST) {
                if (i1.getId() > i2.getId()) return 1;
                else return -1;
            }
            if (i1.getId() < i2.getId()) return 1;
            else return -1;
        });
        return items;
    }
}