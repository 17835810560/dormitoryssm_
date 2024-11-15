package com.dxy.service;

import com.dxy.dto.AccountDto;
import com.dxy.entity.SystemAdmin;
import com.dxy.form.AccountForm;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}
