1.下载docker镜像 docker pull morunchang/fastdfs
2.运行tracker docker run -d --name tracker --net=host morunchang/fastdfs sh tracker.sh
3.运行storage docker run -d --name storage -p 80:80 --net=host -e TRACKER_IP=192.168.1.111:22122 -e GROUP_NAME=group1 morunchang/fastdfs sh storage.sh
4.进入storage docker exec -it storage  /bin/bash
5.修改nginx配置文件 vi /data/nginx/conf/nginx.conf
    新增
    location /group1/M00 {
        proxy_next_upstream http_502 http_504 error timeout invalid_header;
        proxy_cache http-cache;
        proxy_cache_valid  200 304 12h;
        proxy_cache_key $uri$is_args$args;
        proxy_pass http://fdfs_group1;
        expires 30d;
    }
7.重启storagedocker restart storage
