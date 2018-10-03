package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntriesRepo;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntriesRepo = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = timeEntriesRepo.create(timeEntry);

        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }
    @GetMapping ("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(name="id") long id) {
        TimeEntry findTimeEntry = timeEntriesRepo.find(id);
        if(findTimeEntry != null )
            return new ResponseEntity<>(findTimeEntry, HttpStatus.OK);
        else
            return new ResponseEntity<>(findTimeEntry, HttpStatus.NOT_FOUND);
    }

    @PutMapping ("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry updatedTimeEntry = timeEntriesRepo.update(id,timeEntry);
        if (updatedTimeEntry != null )
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        else
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity delete(@PathVariable(name="id") long id) {

        timeEntriesRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntriesRepo.list();

        return new ResponseEntity<>(timeEntryList, HttpStatus.OK);
    }
}
