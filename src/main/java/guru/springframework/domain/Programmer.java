package guru.springframework.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dli
 */
@Data
public class Programmer implements Serializable {
    private Long id;
    private String name;
    private String company;
}
