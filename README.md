# DateTimeFormatter Pattern Fabricator

A tool to help build DateTimeFormatter patterns.

1. Build Date Pattern, by Adding Only, from 3 options
    Separator is dash `-` by default (LATER: can be set via constructor or `with` method)

    Select "value"

      Year  -> choose: 4 or 2 digits `y`
      Month -> choose: leading 0 or not `M`
      Day   -> choose: leading 0 or not `d`

    Show updated pattern with example

DONE Select yyyy
DONE >> Pattern is 'yyyy', example: 2022
DONE Select M
>> Pattern is yyyy-M, example: 2022-1
Select dd
>> Pattern is yyyy-M-dd, example: 2022-1-26
Select MM
>> Pattern is yyyy-MM-dd, example: 2022-01-26
