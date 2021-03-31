package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FilterManagerTest {
    private IssueRepository repository = new IssueRepository();
    private Set<Label> labels = new HashSet<>();
    private Label one = new Label(1, "bug", "bug", "red");
    private Label two = new Label(2, "documentation", "documentation", "blue");
    private Label three = new Label(3, "help wanted", "help wanted", "green");

    private Issue first = new Issue(1, true, "Petr", "Ivan", labels);
    private Issue second = new Issue(2, false, "Petr", "Max", labels);
    private Issue third = new Issue(3, true, "Ivan", "Max", labels);
    private Issue fourth = new Issue(4, false, "Max", "Petr", labels);
    private Issue fifth = new Issue(5, false, "Ivan", "Elena", labels);
    private Issue sixth = new Issue(6, true, "Elena", "Petr", labels);


    @BeforeEach
    void setRepository() {
        labels.add(one);
        labels.add(two);
        labels.add(three);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    public void shouldFilterByStatus() {
        FilterManager manager = new FilterManager(repository);
        List<Issue> issues;

        issues = manager.filterByStatus(true);
        assertEquals(1, issues.get(0).getId());
        assertEquals(3, issues.get(1).getId());
        assertEquals(6, issues.get(2).getId());

        issues = manager.filterByStatus(false);
        assertEquals(2, issues.get(0).getId());
        assertEquals(4, issues.get(1).getId());
        assertEquals(5, issues.get(2).getId());

    }

    @Test
    public void shouldFilterByAuthor() {
        FilterManager manager = new FilterManager(repository);
        List<Issue> issues;

        issues = manager.filterByAuthor("Ivan");
        assertEquals(3, issues.get(0).getId());
        assertEquals(6, issues.get(1).getId());
    }

    @Test
    public void shouldFilterByAssignee() {
        FilterManager manager = new FilterManager(repository);
        List<Issue> issues;

        issues = manager.filterByAssignee("Elena");
        assertEquals(5, issues.get(0).getId());
    }

    @Test
    public void shouldFilterByLabel() {
        FilterManager manager = new FilterManager(repository);
        List<Issue> issues;
    }

}
