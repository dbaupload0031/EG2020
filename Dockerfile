FROM ubuntu
WORKDIR /go
#ADD server /go
COPY server .
COPY /tmp/gosrc/a.go  .
CMD ["/bin/sh","-c", "/go/server"]
#CMD ["/bin/sh","-c", "sleep 3000000"]

