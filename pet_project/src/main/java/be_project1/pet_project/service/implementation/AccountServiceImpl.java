package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.service.validator.AccountServiceVal;
import be_project1.pet_project.dto.request.AccountReq;
import be_project1.pet_project.dto.response.AccountRes;

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
    public Object login(AccountReq request) {
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

    // Create
    @Override
    public Object create(AccountReq request) {
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

    // Read
    @Override
    public Object read(String sort, int page, int size, AccountReq request) {
        String error = accountServiceVal.read(request);
        if (error != null) {
            return error;
        }

        AccountRes response = new AccountRes();
        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String accountID, AccountReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);
        
        String error = accountServiceVal.update(accountID, request);
        if (error != null) {
            return error;
        }

        return request;
    }

    // Delete
    @Override
    public Object delete(String accountID) {
        String error = accountServiceVal.delete(accountID);
        if (error != null) {
            return error;
        }

        return accountID;
    }
}
