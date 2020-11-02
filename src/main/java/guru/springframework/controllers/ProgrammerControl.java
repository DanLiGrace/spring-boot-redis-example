package guru.springframework.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.domain.Programmer;
import guru.springframework.services.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dli
 */
@RestController
public class ProgrammerControl {
    @Autowired
    private ProgrammerService programmerService;

    @RequestMapping(method = RequestMethod.POST, value = "/programmer-string")
    public void saveProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),objectMapper.writeValueAsString(programmer));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/programmer-string/{id}")
    public String readProgrammer(@PathVariable String id){
        return programmerService.getProgrammerAsString(id);
    }

    // *******************LIST Demo*******************//

    // add programmer to list
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-list")
    public void addToProgrammerList(@RequestBody Programmer programmer) {
        programmerService.AddToProgrammersList(programmer);

    }

    // get all programmers from a list
    @RequestMapping("/programmers-list")
    public List<Programmer> getProgrammerListMembers() {
        return programmerService.getProgrammersListMembers();

    }

    // count all programmers in a list
    @RequestMapping("/programmers-list/count")
    public Long getProgrammerListCount() {
        return programmerService.getProgrammersListCount();

    }

    // *******************SET Demo*******************//

    // add programmers to set
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-set")
    public void AddToProgrammerstSet(@RequestBody Programmer... programmers) {
        programmerService.AddToProgrammersSet(programmers);

    }

    // get all programmers from a set
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-set")
    public Set<Programmer> getProgrammersSetMembers() {
        return programmerService.getProgrammersSetMembers();

    }

    // Check if programmer already exists in the set
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-set/member")
    public boolean isSetMember(@RequestBody Programmer programmer) {
        return programmerService.isSetMember(programmer);

    }

    // *****************HASH Demo**********************//

    // add programmer to hash
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-hash")
    public void savePHash(@RequestBody Programmer programmer) {
        programmerService.savePHash(programmer);

    }

    // update programmer in hash
    @RequestMapping(method = RequestMethod.PUT, value = "/programmers-hash")
    public void updatePHash(@RequestBody Programmer programmer) {
        programmerService.updatePHash(programmer);

    }

    // get all programmers from hash
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-hash")
    public Map<Integer, Programmer> FindAllPHash() {
        return programmerService.findAllPHash();

    }

    // get programmer from hash
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-hash/{id}")
    public Programmer FindPInHash(@PathVariable int id) {
        return programmerService.findPInHash(id);

    }

    // delete programmer from hash
    @RequestMapping(method = RequestMethod.DELETE, value = "/programmers-hash/{id}")
    public void deletePhash(@PathVariable int id) {
        programmerService.deletePhash(id);

    }


}
