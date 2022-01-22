package ch.teko.prg;

import net.bytebuddy.utility.RandomString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DemoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name = "Test";
}
