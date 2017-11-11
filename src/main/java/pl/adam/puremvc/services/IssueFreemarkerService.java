package pl.adam.puremvc.services;

import org.springframework.stereotype.Service;
import pl.adam.puremvc.dto.Issue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SkyNET on 2017-11-11.
 */

@Service
public class IssueFreemarkerService implements CrudIssue {

    @Override
    public Issue findById(Integer id) {
        return new Issue("Krzysztof", "Krzysztof",12, new Date());
    }

    @Override
    public List<Issue> findAll() {
            List<Issue> issueses = new ArrayList<>(6);
            issueses.add(new Issue("Wojtyła", "Wojtyła", 124, new Date()));
            issueses.add(new Issue("Yoyne", "Yoyne", 897, new Date()));
            issueses.add(new Issue("ZimmermannY", "ZimmermannY", 24, new Date()));
            issueses.add(new Issue("Krzysztof", "Krzysztof",12, new Date()));
            issueses.add(new Issue("Adam", "Adam",11, new Date()));
            issueses.add(new Issue("ZimmermannP", "ZimmermannP", 123, new Date()));
        return issueses;
    }

}
