package ru.netology.manager;

import ru.netology.domain.Issue;

import ru.netology.repository.IssueRepository;

public class ProductManager {
    private IssueRepository repository;

    public ProductManager(IssueRepository repository) {
        this.repository = repository;
    }

    public Issue[] searchBy(String text) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.findAll()) {
            if (matches(issue, text)) {
                Issue[] tmp = new Issue[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Issue issue, String search) {
        // ваш код
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return true;
    }


}