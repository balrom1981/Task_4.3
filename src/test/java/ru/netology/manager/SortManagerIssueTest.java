package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SortManagerIssueTest {
    private IssueRepository repository = new IssueRepository();
    private Set<Label> labels = new HashSet<>();

    @BeforeEach
    public void setup() {
        labels.add(new Label(1, "bug","bug", "red"));
        repository.save(new Issue(
                2, true, "Вася", "Петя", labels
        ));
        repository.save(new Issue(
                3, true, "Семен", "Коля", labels
        ));
        repository.save(new Issue(
                1, true, "Женя", "Петя", labels
        ));
    }

    @Test
    public void shouldSortListOfIssue() {
        SortManagerIssue manager = new SortManagerIssue(repository);
        List<Issue> issues;

        issues = manager.sort(SortManagerIssue.NEWEST_FIRST);
        assertEquals(3, issues.get(0).getId());
        assertEquals(2, issues.get(1).getId());
        assertEquals(1, issues.get(2).getId());

        issues = manager.sort(SortManagerIssue.OLDEST_FIRST);
        assertEquals(1, issues.get(0).getId());
        assertEquals(2, issues.get(1).getId());
        assertEquals(3, issues.get(2).getId());
    }
}