package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.PersonalAccounts;
import com.project.swipe.repository.PersonalAccountsRepository;
import com.project.swipe.service.service.PersonalAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalAccountsServiceImpl implements PersonalAccountsService {
    @Autowired
    private PersonalAccountsRepository personalAccountsRepository;

    @Override
    public PersonalAccounts save(PersonalAccounts personalAccounts) {
        return personalAccountsRepository.save(personalAccounts);
    }

    @Override
    public PersonalAccounts findById(Integer id) {
        Optional<PersonalAccounts> personalAccount = personalAccountsRepository.findById(id);
        if (!personalAccount.isEmpty()) {
            return personalAccount.get();
        }
        return null;
    }

    @Override
    public List<PersonalAccounts> findAll() {
        return personalAccountsRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        personalAccountsRepository.deleteById(id);
    }
}
