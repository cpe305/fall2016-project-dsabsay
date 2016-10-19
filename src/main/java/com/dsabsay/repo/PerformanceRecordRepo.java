package com.dsabsay.repo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.dsabsay.model.PerformanceRecord;
import com.dsabsay.model.RhythmRecord;
import com.dsabsay.model.SightSingingRecord;

public interface PerformanceRecordRepo {
    public void savePerformanceRecord(PerformanceRecord record) throws IOException;
    
    public List<SightSingingRecord> getSightSingingRecords();
    
    public List<RhythmRecord> getRhythmRecords();
    
    public Map<String, List<SightSingingRecord>> getSightSingingRecordsByCategory();
    
    public Map<String, List<RhythmRecord>> getRhythmRecordsByCategory();
}
