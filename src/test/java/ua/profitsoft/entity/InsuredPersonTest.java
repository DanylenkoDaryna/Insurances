package ua.profitsoft.entity;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class InsuredPersonTest {

    @Test
    public void outFIO() {

        InsuredPerson actual = new InsuredPerson(3, "Kovalenko Ivan Nikolaevich", LocalDate.of(1993,
                12, 9), 45);
        String expected = "Kovalenko I.N.";

        Assert.assertEquals(expected, actual.outFIO(actual.getFlname()));
    }
}