import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

public class EmployeeNotNullTest {

    @Test
    public void simpleNotNullTest(){
        Employee e = new Employee();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Employee>> validationResponse = validator.validate(e);

        assertNotNull(validationResponse);
        assertEquals(validationResponse.size(),1);


    }


}
