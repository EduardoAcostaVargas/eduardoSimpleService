FROM ubuntu:latest
LABEL authors="acoeduj"

ENTRYPOINT ["top", "-b"]