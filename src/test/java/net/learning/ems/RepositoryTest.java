package net.learning.ems;

import net.learning.ems.dto.EmployeeDto;
import net.learning.ems.entity.Employee;
import net.learning.ems.mapper.EmployeeMapper;
import net.learning.ems.repository.EmployeeRepository;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    private EmployeeRepository myRepository;

    @Test
    public void testRepositoryMethod() {
        EmployeeDto entity = new EmployeeDto("Newkoko","ESH","emailTest@gmail.com");
        Employee entityMapped = EmployeeMapper.employeedtoToemployee(entity);
        Employee entitySaved =  myRepository.save(entityMapped);
        Employee entityRetried = myRepository.findById(entitySaved.getId()).orElse(null);
        assertEquals(entitySaved.getId(), entityRetried.getId());
        MatcherAssert.assertThat(entitySaved, samePropertyValuesAs(entityRetried));
    }
}
