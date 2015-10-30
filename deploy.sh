#!/bin/bash
SERVER="media-central"
PORT="22"

rm obsPlugin/build/libs/*
./gradlew build stage -Prelease
ssh root@$SERVER -p $PORT "rm -f /opt/avid/avid-interplay-central/plugins/obs/*"
scp -P $PORT obsPlugin/build/libs/* root@$SERVER:/opt/avid/avid-interplay-central/plugins/obs/
scp -P $PORT libs/* root@$SERVER:/opt/avid/avid-interplay-central/plugins/obs/
ssh root@$SERVER -p $PORT "service avid-interplay-central restart"
