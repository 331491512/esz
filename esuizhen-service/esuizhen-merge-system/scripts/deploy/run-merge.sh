nohup java -jar merge.jar >> /dev/null 2>error_log &
# 详细信息 tail -f log/$date.log
# 一般错误信息 tail -f error_log
# nohup java -jar merge.jar >> /dev/null 2>&1 &
# nohup java -jar /usr/local/java/esz/merge.jar 2>&1 &
