package com.revature.controllers;

import com.revature.entities.BankAccount;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {
    
    private final BankAccountService bankAccountService;

    @Autowired
    BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable Long accountNumber) throws BankAccountNotFoundException {
        return new ResponseEntity<BankAccount>(bankAccountService.findBankAccountById(accountNumber), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
        return new ResponseEntity<List<BankAccount>>(bankAccountService.findAllBankAccounts(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BankAccount> addBankAccount(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<BankAccount>(bankAccountService.saveBankAccount(bankAccount), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<BankAccount> editBankAccount(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<BankAccount>(bankAccountService.editBankAccount(bankAccount), HttpStatus.OK);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<BankAccount> deleteBankAccount(@PathVariable Long accountNumber) throws BankAccountNotFoundException{
        return new ResponseEntity<BankAccount>(bankAccountService.deleteBankAccount(accountNumber), HttpStatus.OK);
    }
}
