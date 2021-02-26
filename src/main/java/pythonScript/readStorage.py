import csv
from pathlib import Path

with open(str(Path(__file__).parent.parent)+r'\storage\Data Storage.csv', newline='') as f:
    rows = csv.DictReader(f)

    for row in rows:
        print(row)
