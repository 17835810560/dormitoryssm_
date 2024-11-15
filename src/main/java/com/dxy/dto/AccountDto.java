package com.dxy.dto;

import lombok.Data;

import javax.management.relation.InvalidRelationTypeException;
import java.awt.print.PrinterGraphics;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Data
public class AccountDto<T> {
    /**
     * -1 账号错误
     * -2 密码错误
     * 0  账号和密码都正确
     */
    private Integer code;

    private T  admin;
}
