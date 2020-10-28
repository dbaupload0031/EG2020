FROM ubuntu
WORKDIR /go
#ADD server /go
COPY server .
CMD ["/bin/sh","-c", "/go/server","sleep 3000000"]
