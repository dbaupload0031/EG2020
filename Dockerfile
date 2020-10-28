FROM golang
WORKDIR /go
ADD server /go
CMD ["sleep 3000000; /go/server"]
