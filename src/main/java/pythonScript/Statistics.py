import sys
import numpy as np
from matplotlib import pyplot as plt
import csv

EVAAIR = "green"

def removeNone(remList, rowNum):
    for x in range(rowNum):
        while '' in remList[x]:
            remList[x].remove('')

    return remList



def priceSum(_List):
    _sumList = [sum(x) for x in _List]
    return _sumList



def listToInt(_List, rowNum):
    for x in range(rowNum):
        _List[x] = list(map(int, _List[x]))

    return _List



def listDataIntegration(_List, rowNum):
    csvData_Date = []
    for x in range(0, rowNum):
        remv = _List[x][0]
        csvData_Date.append(remv)
        del  _List[x][0]

    return csvData_Date, priceSum(listToInt(_List, rowNum))



def grapHistogram_Output(_Date, _Sum):
    histogramLeft = np.array(_Date)
    histogramHeight = np.array(_Sum)

    plt.barh(histogramLeft, histogramHeight, color=EVAAIR)

    plt.title("Account")
    plt.xlabel("Price(Daily)")
    plt.ylabel("Date")


    plt.savefig("Account.png", bbox_inches='tight', dpi=800)



if __name__ == '__main__':
    fileName = "Spent.csv"
    with open(fileName, 'r') as csvFile:
        csvReader = csv.reader(csvFile)
        csvList = list(csvReader)

    csvRowCnt = len(csvList)

    removeNone(csvList, csvRowCnt)

    csvData_Date, csvData_Sum = listDataIntegration(removeNone(csvList, csvRowCnt), csvRowCnt)

    grapHistogram_Output(csvData_Date, csvData_Sum)

'''
Deadline : Feb 26, 2021
'''
