FROM golang
WORKDIR /go
#ADD server /go
COPY server .
CMD ["/bin/sh","-c","sleep 3000000", "/go/server"]
