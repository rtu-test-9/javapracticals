#!/bin/bash
passwd="5812"
imageName="helloworldimage1"
containername="helloworldContainer1"
echo $passwd | sudo -S docker build -t $imageName build/docker/
echo $passwd | sudo -S docker run --name=$containername $imageName