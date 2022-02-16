package com.project.swipe.controller;

import com.google.gson.Gson;
import com.project.swipe.fileManager.FileManager;
import com.project.swipe.fileManager.TypesFile;
import com.project.swipe.model.PersonalAccounts;
import com.project.swipe.service.service.PersonalAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.List;

@RestController
public class RestControllerPersonalAccounts {
    @Autowired
    private PersonalAccountsService personalAccountsService;
    @Autowired
    private FileManager fileManager;
    @Autowired
    private Gson gson;

    @GetMapping("/personal-accounts")
    public List<PersonalAccounts> getPersonalAccounts() {
        return personalAccountsService.findAll();
    }

    @GetMapping("/personal-accounts/{idPersonalAccounts}")
    public PersonalAccounts getPersonalAccountById(@PathVariable Integer idPersonalAccounts) {
        return personalAccountsService.findById(idPersonalAccounts);
    }

    @PostMapping("/personal-accounts")
    public PersonalAccounts postPersonalAccounts(@RequestParam(name = "personalAccounts") String personalAccountsJson,
                                                 @RequestParam(name = "photo", required = false) MultipartFile file) {
        PersonalAccounts personalAccounts = gson.fromJson(personalAccountsJson, PersonalAccounts.class);

        if (file != null) {
            personalAccounts.setPathToImage(fileManager.uploadFile(TypesFile.IMAGE, file).toString());
        }


        return personalAccountsService.save(personalAccounts);
    }

    @PutMapping("personal-accounts/{idPersonalAccounts}") //id для поддержки однотипности rest запросов
    public PersonalAccounts putPersonalAccounts(@RequestParam(name = "personalAccounts") String personalAccountsJson,
                                                @RequestParam(name = "photo", required = false) MultipartFile file) {
        PersonalAccounts personalAccounts = gson.fromJson(personalAccountsJson, PersonalAccounts.class);
        if (!file.isEmpty()) {
            if (personalAccounts.getPathToImage() != null) {
                fileManager.deleteFile(Paths.get(personalAccounts.getPathToImage()));
            }
            personalAccounts.setPathToImage(fileManager.uploadFile(TypesFile.IMAGE, file).toString());
        }
        return personalAccountsService.save(personalAccounts);
    }

    @DeleteMapping("/personal-accounts/{idPersonalAccounts}")
    public String deletePersonalAccounts(@PathVariable Integer idPersonalAccounts) {
        PersonalAccounts personalAccounts = personalAccountsService.findById(idPersonalAccounts);

        if (personalAccounts != null) {
            if (personalAccounts.getPathToImage() != null) {
                fileManager.deleteFile(Paths.get(personalAccounts.getPathToImage()));
            }
            personalAccountsService.deleteById(personalAccounts.getIdPersonalAccount());
            return "was deleted idPersonalAccount = " + idPersonalAccounts;
        } else {
            return "no such PersonalAccount";
        }
    }
}
