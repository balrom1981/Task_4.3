package ru.netology.manager;

import ru.netology.domain.Issue;

import ru.netology.domain.IssueAscPredicat;
import ru.netology.repository.IssueRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class SortManagerIssue {
    private IssueRepository repository;
    private IssueAscPredicat predicate = new IssueAscPredicat();

    public SortManagerIssue(IssueRepository repository) {
        this.repository = repository;
    }

    public Issue[] searchBy(String author) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (matches(issue, author)) {
                Issue[] tmp = new Issue[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Issue issue, String author) {
        if () {
            return true;
        }
        return false;
    }


}