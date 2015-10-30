#!/bin/bash
SERVER="localhost"
PORT="2222"

rm obsPlugin/build/libs/*
./gradlew build stage -Prelease
ssh root@$SERVER -p $PORT "rm -f /opt/avid/avid-interplay-central/plugins/obsplugin/*"
scp -P $PORT obsPlugin/build/libs/* root@$SERVER:/opt/avid/avid-interplay-central/plugins/obsplugin/
scp -P $PORT libs/* root@$SERVER:/opt/avid/avid-interplay-central/plugins/obsplugin/
ssh root@$SERVER -p $PORT "service avid-interplay-central restart"
