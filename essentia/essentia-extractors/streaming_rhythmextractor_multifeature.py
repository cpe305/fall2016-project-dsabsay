# This is essentially the streaming_rhythmextractor_multifeature.cpp written in
# python

from __future__ import print_function
import sys
import essentia
import essentia.streaming

print("Python version of rhythm extractor (beat tracker, BPM, positions of tempo changes) based on multifeature beat tracker (see the BeatTrackerMultiFeature algorithm)")

try:
  infile = sys.argv[1]
except:
  print("usage: ", sys.argv[0], "<input audio file>")
  sys.exit()

loader = essentia.streaming.MonoLoader(filename = infile)

rhythm_extractor = essentia.streaming.RhythmExtractor2013(method="multifeature")

pool = essentia.Pool()

# connect algorithms
print("-------- connecting algos --------")

loader.audio >> rhythm_extractor.signal
rhythm_extractor.ticks >> (pool, "rhythm.ticks")
rhythm_extractor.confidence >> (pool, "rhythm.ticks_confidence")
rhythm_extractor.bpm >> (pool, "rhythm.bpm")
rhythm_extractor.estimates >> (pool, "rhythm.estimates")
rhythm_extractor.bpmIntervals >> (pool, "rhythm.bpmIntervals")

# starting algorithms
print("-------- start processing ", infile, " --------")

essentia.run(loader)

#print results

def print_array(array):
  print("[", end="")
  for i in range(0, array.size):
    print(array[i], end="")
    if (i != array.size - 1):
      print(", ", end="")

  print("]")


print("-------- results --------")
print("bpm: ", pool["rhythm.bpm"])
print("ticks: ", end="")
print_array(pool["rhythm.ticks"])
print("ticks detection confidence: ", pool["rhythm.ticks_confidence"])
print("estimates: ", end="")
print_array(pool["rhythm.estimates"])
print("bpmIntervals: ", end="")
print_array(pool["rhythm.bpmIntervals"])
