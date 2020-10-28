FROM golang
WORKDIR /go
ADD server /go
CMD ["/bin/sh","-c","sleep 3000000", "/go/server"]
