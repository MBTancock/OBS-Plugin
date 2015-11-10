#!/bin/bash
SERVER="media-central"
PORT="22"
USER=root

# clean the build folder
rm obsPlugin/build/libs/*
# run the gradle build
./gradlew build stage -Prelease
# clean the plugin directory on the MediaCentral server
ssh $USER@$SERVER -p $PORT "rm -f /opt/avid/avid-interplay-central/plugins/obs/*"
# copy the plugin to the MediaCentral server
scp -P $PORT obsPlugin/build/libs/* $USER@$SERVER:/opt/avid/avid-interplay-central/plugins/obs/
# copy any dependencies to the MediaCentral server
scp -P $PORT libs/* $USER@$SERVER:/opt/avid/avid-interplay-central/plugins/obs/
# restart the MediaCentral service
ssh $USER@$SERVER -p $PORT "service avid-interplay-central restart"
