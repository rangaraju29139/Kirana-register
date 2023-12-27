package com.example.kiranaregister.factories;

import com.example.kiranaregister.common.reports.ReportResult;
import com.example.kiranaregister.entities.enums.ReportType;

import java.time.LocalDateTime;

public interface StoreTransactionStatementReport {

    public ReportResult getReportResult(ReportType reportType, LocalDateTime from, LocalDateTime to);
}
