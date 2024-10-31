package com.example.dbservice.config;

import com.example.dbservice.vo.DataSourceType;

public class TransactionContextHolder {
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType type) {
        contextHolder.set(type);
    }

    public static DataSourceType getCurrentDataSourceType() {
        return contextHolder.get() != null ? contextHolder.get() : DataSourceType.WRITE;
    }

    public static void clear() {
        contextHolder.remove();
    }
}