# spreadsheet

## run it

```bash
lein run -m jobs.csv
```

Write a program in Java to read in a spreadsheet, evaluate the value of each cell, and output the values to a
file.

**Input Format:**
- A csv file with m rows and n columns
- The input file will have no headers
- Cells will not be surrounded in double quotes

**Example:**

_input.csv_
```
B2+2,A1+A2
B2-3,7+5
```

_output.csv_
```
14.00,23.00
9.00,12.00
```
