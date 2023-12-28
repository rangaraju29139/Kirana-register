package com.example.kiranaregister.services;

import com.example.kiranaregister.dtos.transaction.TransactionResponseDtoMapper;
import com.example.kiranaregister.entities.Store;
import com.example.kiranaregister.entities.Transaction;
import com.example.kiranaregister.entities.enums.ConsumerType;
import com.example.kiranaregister.repositories.TransactionRepository;
import com.example.kiranaregister.strategies.currencyconversion.CurrencyConversion;
import com.example.kiranaregister.strategies.currencyconversion.CurrencyConversionStrategy;
import com.example.kiranaregister.strategies.currencyconversion.OtherCurrencyConversionStrategy;
import com.example.kiranaregister.strategies.currencyconversion.UsdCurrencyConversionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier("v1")
public class TransactionServiceImplV1 implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;




    @Override
    public Optional<Transaction> createTransaction(Transaction transaction) {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        String from = transaction.getCurrencyType().toString();
        String to = transaction.getStore().getOperationalCurrency().toString();
        Double amount = transaction.getTotalAmount();
        Double totalAmountConverted;

        if(from.equalsIgnoreCase(to)) {
            totalAmountConverted = amount;
        }else if(from.equals("USD") || to.equals("USD")){
            currencyConversion.setCurrencyConversionStrategy(new UsdCurrencyConversionStrategy());
            totalAmountConverted = currencyConversion.convertCurrency(from,to,amount);
        }else{
            currencyConversion.setCurrencyConversionStrategy((new OtherCurrencyConversionStrategy()));
            totalAmountConverted = currencyConversion.convertCurrency(from,to,amount);
        }

        transaction.setTotalAmount(totalAmountConverted);


        return Optional.of(transactionRepository.save(transaction));
    }

    @Override
    public Optional<Transaction> getTransaction(Long id) {
        return  transactionRepository.findById(id);

    }

    @Override
    public Optional<List<Transaction>> getAllTransactionsAtStoreByConsumer(Store store, ConsumerType consumerType, Long consumerId) {
        return Optional.of(transactionRepository.findTransactionsByStoreAndConsumerTypeAndConsumerId(store,consumerType,consumerId));
    }

    @Override
    public Optional<List<Transaction>> getStoreStatement(Store store, LocalDateTime fromDate, LocalDateTime toDate) {
      Optional<List<Transaction>> transactionsList=  Optional.of(transactionRepository.findAllByStoreAndCreatedTimeBetween(store, fromDate, toDate));
      if(transactionsList.isEmpty() || transactionsList.get().size() == 0){
          return Optional.empty();
      }
      return transactionsList;

    }
}
