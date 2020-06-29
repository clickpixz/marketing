package com.example.market.constant;

public interface AppConstants {

    // Ma code tra ve cho cac API thanh cong
    String SUCC_CODE = "API000";
    // Ma code tra ve cho cac exception khong phai la AppException
    String SYSTEM_ERROR = "APP001";

    String NOT_FOUND = "APP002";

    // Cac app exception thi phai tra ve theo ma loi qui dinh
    String NULL_OBJ = "APP100";
    String DUPPLICATE = "APP200";
    String MAX_LENGHTH = "APP300";

    interface DATE_FORMAT {

        String GLOBAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        String ORACLE_DATE_FORMAT = "yyyy-mm-dd hh24:mi:ss";
    }
}
