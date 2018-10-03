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
    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        TimeEntry createdTimeEntry = timeEntriesRepo.create(timeEntryToCreate);

        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }
    @GetMapping ({"id"})
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry findTimeEntry = timeEntriesRepo.find(id);
        if(findTimeEntry != null )
            return new ResponseEntity<>(findTimeEntry, HttpStatus.OK);
        else
            return new ResponseEntity<>(findTimeEntry, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TimeEntry> update(@RequestBody long l, TimeEntry expected) {
        TimeEntry updatedTimeEntry = timeEntriesRepo.update(l,expected);
        if (updatedTimeEntry != null )
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        else
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.NOT_FOUND);
    }

    @GetMapping({"id"})
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {

       timeEntriesRepo.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntriesRepo.list();

        return new ResponseEntity<>(timeEntryList, HttpStatus.OK);
    }
}
