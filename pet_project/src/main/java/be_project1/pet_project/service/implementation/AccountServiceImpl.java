package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.service.validator.AccountServiceVal;
import be_project1.pet_project.dto.request.LoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;
import be_project1.pet_project.dto.response.AccountManageRes;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    // Init
    private final AccountServiceVal accountServiceVal;

    @Autowired
    public AccountServiceImpl(@Qualifier("accountServiceVal") AccountServiceVal accountServiceVal) {
        this.accountServiceVal = accountServiceVal;
    }

    // Login
    @Override
    public Object login(LoginReq request) {
        String error = accountServiceVal.login(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Logout
    @Override
    public Object logout(String accountID) {
        String error = accountServiceVal.logout(accountID);
        if (error != null) {
            return error;
        }

        return accountID;
    }

    // create
    @Override
    public Object create(AccountManageReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        String error = accountServiceVal.create(request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // delete
    @Override
    public Object delete(String accountID) {
        String error = accountServiceVal.delete(accountID);
        if (error != null) {
            return error;
        }

        return accountID;
    }

    // update
    @Override
    public Object update(String accountID, AccountManageReq request) {
        String error = accountServiceVal.update(accountID, request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // search
    @Override
    public Object search(String sort, int page, int size, AccountManageReq request) {
        String error = accountServiceVal.search(request);
        if (error != null) {
            return error;
        }

        AccountManageRes response = new AccountManageRes();
        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }
}
