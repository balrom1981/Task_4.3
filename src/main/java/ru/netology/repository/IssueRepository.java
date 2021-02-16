package ru.netology.repository;

import ru.netology.domain.Issue;

public class IssueRepository {
    private Issue[] items = new Issue[0];

    public void save(Issue item) {
        int length = items.length + 1;
        Issue[] tmp = new Issue[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Issue[] findAll() {
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
        int length = items.length - 1;
        Issue[] tmp = new Issue[length];
        int index = 0;
        for (Issue item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }


}

