# RhythmTrainer

[![Build Status](https://travis-ci.org/cpe305/fall2016-project-dsabsay.svg?branch=master)](https://travis-ci.org/cpe305/fall2016-project-dsabsay)

RhythmTrainer is an application that will help you practice sight-reading rhythms.

More documentation here: https://cpe305.github.io/fall2016-project-dsabsay/

## Description
RhythmTrainer presents rhythms in standard music notation. You can then record yourself performing the rhythms using the microphone in your computer. You can perform the rhythm by clapping, snapping, tapping a pencil on a desk, or doing anything else that produces distinct attacks. RhythmTrainer will then grade your performance and give you a score.

## Dependencies
* JavaFX
* Music notation is rendered with VexFlow (https://github.com/0xfe/vexflow) and VexTab (https://github.com/0xfe/vextab).
* The open-source (AGPL-3.0) Essentia library is used for the audio analysis. More information about Essentia can be found here: http://essentia.upf.edu
