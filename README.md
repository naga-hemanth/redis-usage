# Introduction

Instead of Directly using the Operations I made a mini project using those Operations The flow of project goes like this there will be instructor and courses and instructor will be having dome license period and can publish courses until that time I'm using redis expire to enable this feature and for saving instructor I'm using redis set ,and for getting the instructor I'm using get,And coming to Course a Course will be having rating and the course Hash will be sorted by the help of redis Zset on the basis of rating as score we can get the courses in a range by using Zrange and rank using Zrank and save using Zadd.

