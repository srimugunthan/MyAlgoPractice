#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 29 22:43:37 2020

@author: srimugunthan
"""

def findtwosum(alist, total):
    dict = {}
    idx = 0
    for x in alist:
        p = total - x
        dict[p] = idx
        idx = idx+1
  
    idx = 0
    for x in alist:
        if x in dict.keys():
            print("indexes are:", dict[x], idx)
            return True
        idx = idx +1 
    return False


a = [1,4,6,4,2,6]
print(findtwosum(a, 5))