package com.project.swipe.service.serviceImpl;

import com.project.swipe.model.AccountTypes;
import com.project.swipe.repository.AccountTypesRepository;
import com.project.swipe.service.service.AccountTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypesServiceImpl implements AccountTypesService {
    @Autowired
    private AccountTypesRepository accountTypesRepository;

    @Override
    public List<AccountTypes> findAll() {
        return accountTypesRepository.findAll();
    }
}
