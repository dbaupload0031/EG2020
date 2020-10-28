FROM golang
WORKDIR /go
ADD server /go
CMD ["/root/go/server"]
