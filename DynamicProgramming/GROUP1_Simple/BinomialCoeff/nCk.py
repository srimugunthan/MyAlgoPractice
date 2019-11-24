#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Nov 24 19:55:55 2019

@author: srimugunthan
"""
#https://www.geeksforgeeks.org/binomial-coefficient-dp-9/

def nCi ( n,  k):
    if(k == 0 or k == n):
        return 1
    else:
        return nCi(n-1,k-1) + nCi(n-1,k)
    

def nCk_iterative(n, k):
    C = [[0 for x in range(k+1)] for y in range(n+1)] 
    


    for i in range(0, n+1):
        for j in range(0, (min(i,k)+1)):
            if(j == 0 or j == i):
                C[i][j] = 1            

            else:
                C[i][j] = C[i-1][j-1] + C[i-1][j]
            
    return C[n][k]
    



n = 5
k = 2
print("the value of nCi ", nCk_iterative(5,2))
print("the value of nCi ", nCi(5,2))
