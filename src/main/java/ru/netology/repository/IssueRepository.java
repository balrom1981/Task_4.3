package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private List<Issue> items = new ArrayList<>();

    public void save(Issue item) {
        items.add(item);
    }

    public List<Issue> findAll() {
        return items;
    }

    public Issue findById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public void saveAll(Collection<Issue> issues) {
        items.addAll(issues);
    }

    public void removeAll(Collection<Issue> issues) {
        items.removeAll(issues);
    }


}

