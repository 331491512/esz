PATH=${JAVA_HOME}/bin:${CATALINA_HOME}/bin:/usr/kerberos/sbin:/usr/kerberos/bin:/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin

#grep DSuiFang
ps -ef  | grep merge.jar | grep -v grep | awk '{print $2}' | xargs -t -l kill -9
