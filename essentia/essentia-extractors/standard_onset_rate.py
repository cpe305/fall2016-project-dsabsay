# This is essentially the standard_onsetrate.cpp extractor written in python

from __future__ import print_function
import sys
import essentia

import essentia.standard

try:
  infile = sys.argv[1]
except:
  print("usage:", sys.argv[0], "<input audio file>")
  sys.exit()

loader = essentia.standard.MonoLoader(filename=infile)
audio = loader()

onset_rate = essentia.standard.OnsetRate()

onsets = onset_rate(audio)

print("onsetRate: ", onsets[1])
print("onsetTimes: [", end="")

for i in range(0, onsets[0].size):
  print(onsets[0][i], end="")
  if (i != onsets[0].size - 1):
    print(", ", end="") 

print("]")

#print("onsetTimes: ", onsets[0])
