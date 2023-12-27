# Kirana Register
## Problem Statement -
Develop a backend service designed to empower Kirana stores in managing their
transaction registers. This service aims to facilitate the daily tracking of all credit and debit
transactions, providing a comprehensive solution for effective financial record-keeping.
### Coding Guidelines:-
1. Idiomatic Java code, incorporating proper usage of data structures, adhering to best
   practices, and following standard code conventions.
2. Leveraging SpringBoot annotations for streamlined development. (Mandatory)
3. Prioritising project maintainability through strategies such as decoupling and
   abstraction.
4. Fostering readability through descriptive names for variables, classes, functions,
   applications, and packages.
5. Ensure the absence of "dead code" within the repository, including but not limited to
   empty modules, unused configurations and commented code.
6. Consider incorporating unit tests for enhanced code quality (Optional but highly
   recommended).
7. Ensure comprehensive documentation through doc strings that not only clarify the
   real-world problems being addressed but also document attributes and parameters.
8. Provide basic API documentation for better understanding.
9. Demonstrate a heightened awareness of database transactions, locks, and potential
   race conditions in your codebase. 
### Functional Requirement:-
1. Need an API for recording transactions. Transactions can be recorded in both INR
   and USD. Refer to this API for currency conversion -
   https://api.fxratesapi.com/latest.
2. An API for displaying transactions with the capability to group them for daily reports.
3. You can use a database of your choice SQL or NoSQL.
4. Tech Stack - JAVA and SpringBoot


------------------------------------------------


### Requirements


- [] creating a store.
- [ ] creating a customer/User.
- [ ] store can be able to create credit / debit transactions.
- [ ] Transaction can be recorded in both INR and USD.
- [ ] type of currency accepted in a store is fixed initially during the store setup while making the transaction we can convert using the currency conversion Api.
- [ ] A transaction can happen between a store and store or store and customer
- [ ] Store can able to see the daily report of transactions.
- [ ] Authentication

### Future Scope of Requirements

- [ ] Store can have different employees with different roles and authorizations.
- [ ] stock in store can also be maintained with each product cost price and selling price.
- [ ] consumer based reporting can also be achieved.


### Entities 

- Customer
  - id
  - firstName
  - lastName
  - email
  - password
  - phoneNumber

- Store
  - id
  - name
  - description
  - CurrencyType operationalCurrency
  - address
  - User storeOwner
  - balance

- Transaction
  - id
  - description
  - storeId (transaction happened at)
  - ConsumerType consumerType
  - consumerId
  - PaymentType paymentType
  - CurrencyType currencyType
  - referenceId
  - totalAmount

- StoreReport
  - ReportResult generateReport(date);
- DailyReport implements Report
- MonthlyReport implements Report
- YearlyReport implements Report
- ReportFactory

- ConsumerReport
  - ReportResult generateReport(ConsumerType consumerType,Long consumerId)
- ConsumerReportFactory

- ReportResult
  - storeId
  - ReportType reportType
  - List<Transaction> transactions
  - String Result Summary 


   
#### Enums 

- CurrencyType
  - IND
  - USD
  
- PaymentType
  - CASH
  - UPI
  - CARD
  - ONLINE_BANKING
- ConsumerType
  - STORE
  - CUSTOMER
- ReportType
  - DAILY
  - MONTHLY
  - YEARLY
  - CONSUMER
- TransactionType
  - CREDIT
  - DEBIT




## Api Documentation 


#### CreateCustomer
POST: http://localhost:8080/api/v1/customer
BODY: 
```json
{
    "firstName": "xxxxx",
    "lastName": "xxxxxxx",
    "email": "xxxxxx@gmail.com",
    "phoneNumber": "xxxxx",
    "password": "xxxxxx"
}
```

RESPONSE: 
201: header: location: http://localhost:8080/api/v1/customer/id    # id being the id of the customer created.


#### Get Customer 
GET: http://localhost:8080/api/v1/customer/id
id being the id of the customer 
BODY: 
RESPONSE: 
```json
{
"id": 1,
"firstName": "xxxxx",
"lastName": "xxxxxxxx",
"email": "xxxxxxxxx@gmail.com",
"phoneNumber": "xxxxxx"
}

```


#### create Store
POST: http://localhost:8080/api/v1/store
BODY: 
```json
{
    "name": "store1",
    "description": "store1 description",
    "address": "store1 address",
    "storeOwnerId": 1,
    "operationalCurrency": "INR"
    
}
```

RESPONSE: 

201: with created status and response header : http://localhost:8080/api/v1/store/1
with 1 being the store id created


#### get Store
GET: http://localhost:8080/api/v1/store/1
BODY:
RESPONSE:
status code : 200
```json
{
    "id": 1,
    "name": "store1",
    "description": "store1 description",
    "address": "store1 address",
    "storeOwnerId": 1,
    "operationalCurrency": "INR",
    "balance": 0.0
}
```

#### Create Transaction
POST: http://localhost:8080/api/v1/store/1/transaction
Sample Payload: 
```json
{
    "description": "transaction 1 done at store 2",
    "consumerType": "STORE",
    "consumerId": 1,
    "paymentType": "UPI",
    "totalAmount": 100.0,
    "currencyType": "EUR",
    "transactionType": "DEBIT"

}
```
Sample Response: 
201: Header->  Location: http://localhost:8080/api/v1/store/1/transaction/5


#### Get TransactionByTransactionId
GET: http://localhost:8080/api/v1/store/1/transaction/1
Sample Response:
```json

{
    "id": 1,
    "description": "transaction 1 done at store 2",
    "storeId": 1,
    "consumerType": "CUSTOMER",
    "consumerId": 1,
    "paymentType": "UPI",
    "referenceId": null,
    "totalAmount": 9249.771794328015,
    "currencyType": "EUR",
    "createdTime": "2023-12-27T23:32:58.929828",
    "transactionType": "DEBIT"
}
```


#### GetAllTransactionsByStoreId
GET: http://localhost:8080/api/v1/store/1/transactions
Sample Response:

```json

[
    {
        "id": 3,
        "description": "transaction 1 done at store 2",
        "storeId": 1,
        "consumerType": "STORE",
        "consumerId": 1,
        "paymentType": "UPI",
        "referenceId": null,
        "totalAmount": 9247.38440585943,
        "currencyType": "EUR",
        "createdTime": "2023-12-27T23:57:11.723086",
        "transactionType": "DEBIT"
    },
    {
        "id": 4,
        "description": "transaction 1 done at store 2",
        "storeId": 1,
        "consumerType": "STORE",
        "consumerId": 1,
        "paymentType": "UPI",
        "referenceId": null,
        "totalAmount": 9247.38440585943,
        "currencyType": "EUR",
        "createdTime": "2023-12-27T23:57:13.828684",
        "transactionType": "DEBIT"
    },
    {
        "id": 5,
        "description": "transaction 1 done at store 2",
        "storeId": 1,
        "consumerType": "STORE",
        "consumerId": 1,
        "paymentType": "UPI",
        "referenceId": null,
        "totalAmount": 9247.38440585943,
        "currencyType": "EUR",
        "createdTime": "2023-12-27T23:57:16.097758",
        "transactionType": "DEBIT"
    }
]
```


