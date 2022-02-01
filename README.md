# Format Hero

A tiny tool to help create patterns.
The first one is to create patterns for the `DateTimeFormatter` class.

## 1. DateTimeFormatter Pattern Fabricator

A tool to help build DateTimeFormatter patterns.

1. Build Date Pattern, by Adding Only, from 3 options

    Separator is dash `-` by default (LATER: can be set via constructor or `with` method)

    Select "value"

      Year  -> choose: 4 or 2 digits `y`
      
      Month -> choose: leading 0 or not `M`
      
      Day   -> choose: leading 0 or not `d`

    Show updated pattern with multiple examples

```
DONE Select yyyy
DONE >> Pattern is 'yyyy', example: 2022
DONE Select M
DONE >> Pattern is yyyy-M, example: 2022-1
DONE Select dd
DONE >> Pattern is yyyy-M-dd, example: 2022-1-26
DONE Select MM
DONE >> Pattern is yyyy-MM-dd, example: 2022-01-26
```
