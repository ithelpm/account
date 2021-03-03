import csv
import sys

if __name__ == '__main__':
    csvList_fromJava = [sys.argv]

    fileName = "wriTest.csv"

    with open(fileName, 'a', newline='') as javaCSV:
        java_csvWrite = csv.writer(javaCSV)

        java_csvWrite.writerows(csvList_fromJava)
"""
|a|b|c|d|e|
|1| | | | |
|2| | | | |
|3| | | | |
|
|
|
"""
