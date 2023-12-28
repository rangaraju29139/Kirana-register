package com.example.kiranaregister.controllers;


import com.example.kiranaregister.common.reports.ReportResult;
import com.example.kiranaregister.dtos.transaction.TransactionResponseDtoMapper;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ReportType;
import com.example.kiranaregister.entities.enums.TransactionType;
import com.example.kiranaregister.services.CustomerService;
import com.example.kiranaregister.services.StoreService;
import com.example.kiranaregister.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Handles the reqeusts related to reports
 */
@RestController
public class ReportController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private TransactionService transactionService;

    /**
     * Handles the request related to  statement reports at store between the certain time period
     * @param reportType
     * @param storeId
     * @param fromDate
     * @param toDate
     * @return
     */
    @RequestMapping(value = "/api/v1/report/{reportType}/store/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<ReportResult> getStatementReport(@PathVariable ReportType reportType, @PathVariable Long storeId, @RequestParam(value = "fromDate") @DateTimeFormat(pattern = "ddMMyyyy") Date fromDate,@RequestParam(value = "toDate") @DateTimeFormat(pattern = "ddMMyyyy") Date toDate){
       if(toDate.before(fromDate)) return ResponseEntity.badRequest().build();

        Optional<Store> store = storeService.getStore(storeId);
        LocalDateTime fromDateTime = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime toDateTime = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        if(store.isEmpty()) return ResponseEntity.internalServerError().build();

        ReportResult result = ReportResult.builder().storeId(storeId).build();



            if(reportType.equals(ReportType.STORE_STATEMENT)){
               Optional<List<Transaction>> transactionList = transactionService.getStoreStatement(store.get(),fromDateTime,toDateTime);
               if(transactionList.isEmpty() ) return ResponseEntity.noContent().build();
              result.setTransactionList(transactionList.get().stream().map(TransactionResponseDtoMapper::mapToTransactionResponseDto).collect(Collectors.toList()));

              Double totalBalance = result.getTransactionList().stream().mapToDouble((transaction)->{
                  if(transaction.getTransactionType() == TransactionType.CREDIT){
                      return transaction.getTotalAmount();
                  }else{
                      return -1.0*transaction.getTotalAmount();
                  }
              }).sum();
              result.setReportSummary("Your Report with Store having id "+ storeId + " during "+fromDate.toString() + " to "+toDate.toString() + " is "+ totalBalance);
            return ResponseEntity.ok(result);
            }else{
                /**
                 * Need to Implemented for Other Reporting Types
                 *
                 */
                return ResponseEntity.badRequest().build();
            }
    }

}
