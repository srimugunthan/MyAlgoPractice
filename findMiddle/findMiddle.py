#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Apr 29 22:34:16 2020

@author: srimugunthan
"""
import math
def find_middle(alist):
    l = len(alist)-1
    return alist[math.floor(l/2)]

a = [1,2,3]
print(find_middle(a))