FROM ubuntu:latest
LABEL authors="bkulk"

ENTRYPOINT ["top", "-b"]