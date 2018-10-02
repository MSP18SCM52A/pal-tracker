package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntriesRepo;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntriesRepo = timeEntriesRepo;
    }
    @PostMapping
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        TimeEntry createdTimeEntry = timeEntriesRepo.create(timeEntryToCreate);

        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    public ResponseEntity<TimeEntry> read(long l) {
        return null;
    }

    public ResponseEntity<TimeEntry> update(long l, TimeEntry expected) {
        TimeEntry updatedTimeEntry = timeEntriesRepo.update(l,expected);

        return new ResponseEntity<>(updatedTimeEntry, HttpStatus.CREATED);
    }

    public ResponseEntity<TimeEntry> delete(long l) {

        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntriesRepo.list();

        return new ResponseEntity<>(timeEntryList, HttpStatus.CREATED);
    }
}
