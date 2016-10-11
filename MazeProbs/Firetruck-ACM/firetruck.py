#!/usr/bin/python

import sys,os


count = 0;
street_map = [[]]
finaldest = 0;

def process():
	print "in function process"
	for i in range(0,count):
		print "from",street_map[i][0],"to",street_map[i][1]," "	

def printpath():
	print "path"
	for i in range(0,len(pathsofar)):
		print " ", pathsofar[i]," ",
	print " "

def searchpath(curpt, pathsofar,recursecount):
	
	found = 0
	for i in range(0,count):
		if (street_map[i][0] == curpt) & (street_map[i][1] not in pathsofar):
			prevpt = curpt
			curpt  = street_map[i][1];
			found = 1;
		elif (street_map[i][1] == curpt) & (street_map[i][0] not in pathsofar):
			prevpt = curpt
			curpt = street_map[i][0];
			found = 1;

		if found == 1:
			pathsofar.append(curpt)
			if curpt == finaldest:
				printpath()
				#backtrack
				pathsofar.remove(curpt)
			else:
				recursecount = recursecount+1
				searchpath(curpt, pathsofar,recursecount)
				#backtrack
				pathsofar.remove(curpt);
				curpt = prevpt
	
			found = 0
		
	

file = open('./input.txt')
street_map = [[0 for i in xrange(2)] for i in xrange(22)]
line = file.readline()       
if not line:
	print "error"
if line.strip():
	linestring = line.split()

value = int(linestring[0])
finaldest = value
print "start",value,"to 1"
while 1:		
	line = file.readline()       # read line by line
	if not line: break
		# print line,
	if line.strip():
		linestring = line.split()
	value = int(linestring[0])
	value2 = int(linestring[1])


	if value == 0  & value2 == 0: break

	street_map[count][0] = value;
	street_map[count][1] = value2;
	count=count+1;
	
for i in range(0,count):
	print "from",street_map[i][0],"to",street_map[i][1]," "	
	

file.close()

pathsofar=[]
#process()
pathsofar.append(1);
searchpath(1,pathsofar,0);
print "ok the END"



