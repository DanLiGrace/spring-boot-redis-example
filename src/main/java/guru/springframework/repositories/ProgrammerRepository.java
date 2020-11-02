package guru.springframework.repositories;

import guru.springframework.domain.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dli
 */
public interface ProgrammerRepository {
    void setProgrammerAsString(String idKey, String programmer);
    String getProgrammerAsString(String idkey);

    // list
    void AddToProgrammersList(Programmer programmer);

    List<Programmer> getProgrammersListMembers();

    Long getProgrammersListCount();

    // Set
    void AddToProgrammersSet(Programmer ... programmers);

    Set<Programmer> getProgrammersSetMembers();

    boolean isSetMember(Programmer programmer);

    // Hash
    void saveHash(Programmer programmer);

    void updateHash(Programmer programmer);

    Map<Integer, Programmer> findAllHash();

    Programmer findInHash(int id);

    void deleteHash(int id);
}
