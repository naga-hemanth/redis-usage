# Introduction

Instead of Directly using the Operations I made a mini project using those Operations The flow of project goes like this there will be instructor and courses and instructor will be having dome license period and can publish courses until that time I'm using redis expire to enable this feature and for saving instructor I'm using redis set ,and for getting the instructor I'm using get,And coming to Course a Course will be having rating and the course Hash will be sorted by the help of redis Zset on the basis of rating as score we can get the courses in a range by using Zrange and rank using Zrank and save using Zadd.

# What Language I used?
I used java for the Whole thing because of the avialability of build tools like maven and also rich implementation of redis clients like Jedis,Lettuce,Reddison

# Further Improvements
The further improments can be using Normalization while saving to Database which I'm not following due to less time, and also If we want to communicate with reddis in Reactive way(the Thread need to be released while comminucating with redis )
 we can use Reactive_spring_data because of implementation using web flux
 
# Data Structures Used 


# Does this support multithreading
Yes! My application supports Multithreading because of the use of LettuceConnection factory which is designed specially for multi threading purposes this is one of the reason behind using Java as language 


