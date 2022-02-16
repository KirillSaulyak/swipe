package com.project.swipe.service.service;

import com.project.swipe.model.PersonalAccounts;

import java.util.List;

public interface PersonalAccountsService {
    PersonalAccounts save(PersonalAccounts personalAccounts);

    PersonalAccounts findById(Integer id);

    List<PersonalAccounts> findAll();

    void deleteById(Integer id);
}
