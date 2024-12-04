package com.example.dataroutetest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDataSource extends AbstractRoutingDataSource {
    
    private static final Logger log = LoggerFactory.getLogger(RoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        String dataSourceType = isReadOnly ? "slave" : "master";
        
        log.info("Current Transaction Readonly: {}", isReadOnly);
        log.info("Routing to {} DataSource", dataSourceType);
        
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            log.info("Transaction Name: {}", TransactionSynchronizationManager.getCurrentTransactionName());
            log.info("Transaction Isolation Level: {}", TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
        } else {
            log.info("No active transaction");
        }
        
        return dataSourceType;
    }
}
