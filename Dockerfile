FROM golang
WORKDIR /go
ADD server /go
CMD ["/go/server"]
