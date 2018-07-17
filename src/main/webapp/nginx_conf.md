#emp

server {
   listen       8888;
#      server_name  localhost;

location /api{
 proxy_pass "http://localhost:6656/api";
}

location / {
proxy_pass "http://localhost:9000";    
}

}