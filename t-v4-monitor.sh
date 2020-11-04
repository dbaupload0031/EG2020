#!/bin/bash
#
# 2020@sam
#  monitor t-v4.py process
process1=t-v4.py
logfile=t-v4.log
newdate="`date +"%Y%m%d-%H%M%S"`"

function chk_process() {
 ProcNumber=`ps -ef |grep -w $process1|grep -v grep|wc -l`
}
function send_msg() {
#curl  "https://api.telegram.org/bot737415584:AAFLnQ16EclnCWMe-j_Sj9WzD5DBmQj-2ro/sendMessage?chat_id=-370864478&text=${message_text}"
curl -s -X POST https://alarm.evebcomp.com/sender/tg -d tos="-458966585"  -d content="${message_text}"
}
function exec_cmd() {
  nohup python $process1 > ${logfile} 2>&1  &
}

chk_process
if [ $ProcNumber -le 0 ]
then
   message_text="(warning/`hostname`) t-v4.py process is not running."
   send_msg
   cd /root/projs/crise/
     if [ -f "$logfile" ]; then
         mv ${logfile} logs/${logfile}.${newdate}
     fi
   exec_cmd
   sleep 5
   chk_process
   if [ $ProcNumber -gt 0 ]
   then
   message_text="(ok/`hostname`) t-v4.py process is back to normal."
   send_msg
   else
   message_text="(warning/`hostname`) t-v4.py status is NOT startup."
   send_msg
   fi
fi
