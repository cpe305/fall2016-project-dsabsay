#!/usr/bin/env bash

# script to install essentia (for Linux)

# install dependencies
# sudo apt-get install build-essential libfftw3-dev libavcodec-dev libavformat-dev libavutil-dev libavresample-dev python-dev libsamplerate0-dev libtag1-dev
sudo apt-get install build-essential libavcodec-dev libavformat-dev libavutil-dev libavresample-dev python-dev libsamplerate0-dev libtag1-dev

sudo apt-get install python-numpy-dev python-numpy

# navigate to essentia's directory
cd /home/travis/build/cpe305/fall2016-project-dsabsay/essentia/essentia-releases/essentia-2.1_beta3

# configure
./waf configure --mode=release --build-static --with-python --lightweight --fft=KISS

# compile
./waf

./waf install