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