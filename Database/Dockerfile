FROM mariadb:latest
COPY skitter.sql /tmp/skitter.sql
RUN mysql -u root -p $MYSQL_ROOT_PASSWORD < /tmp/skitter.sql
