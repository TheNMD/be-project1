package be_project1.pet_project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountCreateReq;
import be_project1.pet_project.dto.request.AccountReadReq;
import be_project1.pet_project.dto.request.AccountUpdateReq;

@RestController("accountController")
@RequestMapping("/api/v1")
public class AccountController {
    // Init
    private final AccountService accountService;

    @Autowired
    public AccountController(@Qualifier("accountServiceImpl") AccountService accountService) {
        this.accountService = accountService;
    }

    // Login
    @PostMapping(URLConst.LOGIN)
    public ResponseEntity<?> login(@Validated @RequestBody AccountLoginReq request) {
        Object res = accountService.login(request);
        String message = "Login successful";
        return ResponseEntity.ok(message);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT)
    public ResponseEntity<?> logout(@Validated @PathVariable("user_id") String accountID) {
        Object res = accountService.logout(accountID);
        String message = "Logout successful";
        return ResponseEntity.ok(message);
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT)
    public ResponseEntity<?> createAccount(@Validated @RequestBody AccountCreateReq request) {
        Object res = accountService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT)
    public ResponseEntity<?> readAccount(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody AccountReadReq request) {
        Object res = accountService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

     // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT)
    public ResponseEntity<?> updateAccount(
        @Validated
        @PathVariable("user_id") String accountID,
        @RequestBody AccountUpdateReq request) {
        Object res = accountService.update(accountID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT)
    public ResponseEntity<?> deleteAccount(@Validated @PathVariable("user_id") String accountID) {
        Object res =  accountService.delete(accountID);
        return ResponseEntity.ok(res);
    }
}
