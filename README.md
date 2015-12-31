 Jigaspace collaboration tool.
 
 Free and opensource.
 
 DB Setup
 
 ```sql
 CREATE ROLE jigaspace LOGIN ENCRYPTED PASSWORD 'md5cf3400c3950bfc6ab939e5f5e585a25c'
  SUPERUSER CREATEDB CREATEROLE
   VALID UNTIL 'infinity';

 CREATE DATABASE jigaspace
  WITH ENCODING='UTF8'
       OWNER=jigaspace
       CONNECTION LIMIT=-1;
```
