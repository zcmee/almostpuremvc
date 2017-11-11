package pl.adam.puremvc.services;

import pl.adam.puremvc.dto.Issue;

import java.util.List;

/**
 * Created by SkyNET on 2017-11-11.
 */


public interface CrudIssue {
    Issue findById(Integer id);
    List<Issue> findAll();
}
