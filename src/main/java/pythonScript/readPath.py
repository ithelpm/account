from tkinter import filedialog
import tkinter as tk
import sys

tk.Tk().withdraw()

def selectDirectory():
    path = filedialog.askdirectory()
    return path

if __name__ == '__main__':
    directory = selectDirectory()
    print(directory)