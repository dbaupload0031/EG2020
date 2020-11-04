#!/usr/bin/env python
import threading
import librtmp
import time
import Queue
import sys
import os
import subprocess
import requests
import datetime
def rtmp_monitor(stream_url='rtmp://10.0.6.55/live', app=None):
        print app
        sys.stdout.flush()
        connection = librtmp.RTMP(url="%s/%s" %(stream_url,app), live=True, timeout=5)
        connection.connect()
        stream = connection.create_stream()
        RETRY = 5
        if connection.connected:
          while RETRY:
                RETRY = RETRY-1
                format_time = time.strftime("%Y%m%d-%H:%M:%S", time.localtime())
                start_time = time.time()
                stream_data = stream.read(1024)
                msg = ("%s - [%s table] read stream data:%s" % (format_time,app, len(stream_data)))
                print msg
               sys.stdout.flush()
                if not len(stream_data) and RETRY == 0:
                  #os.chdir("/home/ubuntu/projs/%s" %(app))
                  os.chdir("/root/projs/%s" %(app))
                  cid  = subprocess.check_output("docker ps | grep %s | awk '{print $1}'" %app,  shell=True)
                  log_handle = subprocess.check_output("tail -5  `docker inspect --format='{{.LogPath}}' %s` > /tmp/logfile.%s" %(cid,app), shell=True)
                  file = open('/tmp/logfile.%s' %app,mode='r')
                  all_of_it = file.read()
                  file.close()
                  str2="### [%s table] ###" %app + " " + str(all_of_it[-2000:])
                  child1 = subprocess.check_output("/usr/local/bin/docker-compose restart", shell=True)
                  print "Done! Time taken: {}".format(time.time()-start_time)
                  sys.stdout.flush()
                  msg="[Warning] " + msg
                  r = requests.post("https://alarm.evebcomp.com/sender/tg",data={"tos":"-458966585","content": msg})
                  r = requests.post("https://alarm.evebcomp.com/sender/tg",data={"tos":"-458966585","content": str2})
                  #r = requests.post("https://alarm.evebcomp.com/sender/tg",data={"tos":"-370864478","content": msg})
                  #r = requests.post("https://alarm.evebcomp.com/sender/tg",data={"tos":"-370864478","content": str2})
if __name__ == '__main__':
        streams = ['b1','b2','b5','b6','b7','b8','b15','b16','b17','b18','b19']
        #streams = ['b1','b2','b5','b6','b7','b8']
        #streams = ['crise','demo']
        while True:
          for table in streams:
            rtmp_monitor(app=table)
          time.sleep(30)