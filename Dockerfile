FROM redis:latest

# 기본 Redis 설정 파일 복사 (필요할 경우)
COPY redis.conf /usr/local/etc/redis/redis.conf

# 기본 명령어를 사용하여 Redis 서버 실행
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]