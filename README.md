# Velotio-Code
This is three solutions of given problem statements.

## Problem Statement 1
Design database schema for Instagram

### Solution
The Image file are present in the Problem1 folder is the schema of Instagram.
I made some assumptions please check it on .txt file on same folder.

## Problem Statement 2

Let’s suppose we need to search across 100s of documents (search for words). One way to do it is to go one file at a time. 
But that will take too long. So write a multi-threaded or multi-process program to run the search across 100s of files. 
Keep the number of threads/processes configurable. 
Output - files which have the word being searched.

### Solution
Created the java program which perform the linear and parallel search operation.
Run the searchByThreads.java file.

Test Case: 
100                 - Number of files
file48content67     - Search text
18                  - No of threads

## Problem Statement 3
You are a big bank and you are making a list of the most financially reliable customers. 
This is going to be a sorted list and with most reliable customers in the end. Now there are multiple criteria for 
determining the overall reliability and all of them must be used according to their priorities. Following are the criteria:
Total Account Balance - The more the better
Age - The less the better
Salary - The more the better
Number of dependents - The less the better
These criteria have the priority as mentioned above, i.e. Total account balance will take priority over age. So for example, 
P1 with age 25 and 100 account balance will be placed higher than P2 with age 22 and account balance 80 
but if both had the same account balance then P2 will be placed higher. The same way, all the 4 criteria will come 
into picture in sorting all the people accordingly.
Now you are given a list of objects with each object representing a person and has the above attributes. 
Your task is to sort them.

### Solution
Created the java program having 3 classes. Customer, Main and Comparator
Simply run the BigBank.java file

Test Cases: 
There are two test cases given in program. (Static data)
