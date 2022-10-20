# Zopa Technical Test
Technical Test - Zopa:

### Tech Stack:
| Technology | Version |
|--|--|
| **Kotlin** | 1.4.31 |
| **OpenCSV** | 5.4 |
| **JUnit 4** | 4.1.5 |
| **Gradle** | 7.0.2 |

### How To Run The Zopa Application:
> At the terminal:  
`./gradlew build`

> Then run:  
`./gradlew run --args=1700`

##### I'm sorry, it's my first time creating a Kotlin app and I was not able to follow the pattern: ./zopa-rate 1700


### How To Run The Tests:
All the test classes are on package test: **zopa.technical.test**
- `ValidationHelperTest`
- `CalculationServiceImplTest`
- `OfferServiceImplTest`

### Proposal

There is a need for an application to find a quote from Zopa’s market of lenders for 36-month
loans that apply interest on a monthly basis.
Each lender in the market offers an amount of money to lend and the annual interest rate
they expect in return. The table below provides an example of market data:

To ensure that Zopa's quotes are competitive, select a combination of lenders’ offers which
gives the lowest possible rate. The monthly repayment and the total repayment amounts
should be shown in addition to the amount requested and the annual interest rate for the
quote.

Repayment amounts should be displayed to two decimal places and the annual interest rate
displayed to one decimal place.
A quote may be requested in any £100 increment between £1000 and £15000 inclusive. If
the market does not have enough offers to fulfil the request, then the application should
output “It is not possible to provide a quote.”


The application should take one argument:  
**[loan_amount]**

**And write to standard output in the format:**  
Requested amount: £XXXX  
Annual Interest Rate: X.X%  
Monthly repayment: £XXXX.XX  
Total repayment: £XXXX.XX
