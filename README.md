

# Introduction

Instead of Directly using the Operations I made a mini project using those Operations The flow of project goes like this there will be instructor and courses and instructor will be having some license period and can publish courses until that time I'm using redis expire to enable this feature and for saving instructor I'm using redis set ,and for getting the instructor I'm using get,And coming to Course a Course will be having rating and the course Hash will be sorted by the help of redis Zset on the basis of rating as score we can get the courses in a range by using Zrange and rank using Zrank and save using Zadd.

# Technology and Frameworks use 
Maven,Spring boot,Docker 

# Installation
If u know how to use docker u can use docker compose to set the entire thing else u can use Normal ide
Step-1 install docker and start docker daemon
Step-2 go to redis-usage folder
Step-3 execute docker-compose build
Step-4 execute docker-compose up
# What Language I used?
I used java for the Whole thing because of the avialability of build tools like maven and also rich implementation of redis clients like Jedis,Lettuce,Reddison

# Further Improvements
The further improments can be using Normalization while saving to Database which I'm not following due to less time, and also If we want to communicate with reddis in Reactive way(the Thread need to be released while comminucating with redis )
 we can use Reactive_spring_data because of implementation using web flux
 
# Data Structures Used 
Map-For storing the deatails of Instructor
Set-while doing insertions in course using Zadd internally

# Does this support multithreading
Yes! My application supports Multithreading because of the use of LettuceConnection factory provide setEnableTransactionSupport which is designed specially for multi threading purposes this is one of the reason behind using Java as language 

# Postman Collection
https://www.getpostman.com/collections/cf29ea68165aecf4a2ce


