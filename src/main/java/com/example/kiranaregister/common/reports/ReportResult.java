package com.example.kiranaregister.common.reports;

import com.example.kiranaregister.dtos.transaction.TransactionResponseDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportResult {
    /**
     * Report Result is used as a Dto to the Report which shows the store id at which it was generated and
     * List of transacations durign the period
     * report summary to show the calicated credit/debit amounts.
     */
    private Long storeId;
    private List<TransactionResponseDto> transactionList;
    private String reportSummary;
}
