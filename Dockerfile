FROM ubuntu
WORKDIR /go
#ADD server /go
COPY server .
#CMD ["/bin/sh","-c", "/go/server"]
CMD ["/bin/sh","-c", "sleep 3000000"]

