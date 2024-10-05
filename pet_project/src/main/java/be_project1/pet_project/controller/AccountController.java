package be_project1.pet_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;
import be_project1.pet_project.service.AccountService;

@RestController("userController")
public class AccountController {
    
    private final AccountService accountService;

    @Autowired
    public AccountController(@Qualifier("accountServiceImpl") AccountService accountService) {
        this.accountService = accountService;
    }

    // Test
    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }

    // Login
    @PostMapping(URLConst.USER_LOGIN)
    public Object login(@RequestBody AccountLoginReq request) {
        return accountService.login(request);
    }

    // Logout
    @PostMapping(URLConst.USER_LOGOUT)
    public Object logout(@PathVariable("user_id") String userID) {
        return accountService.logout(userID);
    }

    // Create
    @PostMapping(URLConst.USER_CREATE)
    public Object createAccount(@RequestBody AccountManageReq request) {
        return accountService.createAccount(request);
    }

    // Delete
    @DeleteMapping(URLConst.USER_DELETE)
    public Object deleteAccount(@PathVariable("user_id") String userID) { 
        return accountService.deleteAccount(userID);
    }

     // Update
    @PutMapping(URLConst.USER_UPDATE)
    public Object updateAccount(@PathVariable("user_id") String userID,  @RequestBody AccountManageReq request) { 
        return accountService.updateAccount(request);
    }

    // Search
    @PostMapping(URLConst.USER_SEARCH)
    public Object searchAccount(@RequestParam("sort") String sort,
                             @RequestParam("page") int page,
                             @RequestParam("size") int size,
                             @RequestBody AccountManageReq request) {
        return accountService.searchAccount(sort, page, size, request);
    }
}
