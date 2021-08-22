import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.customer.dao.CustomerDao;
import com.customer.dao.impl.Customerdaoimpl;
import com.main.shop.model.Customer;
import com.repository.CustomerRepository;
import com.service.CustomerService;
import com.shop.exception.BusinessException;

class JunitTest{
	Customer customer;
	CustomerService customerRepository  ;
	CustomerDao customerDao;

	@BeforeAll
    public void setUp() throws Exception {
		 customerDao=new Customerdaoimpl();
		customerRepository  = new CustomerService();
	
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
    public void customerPasswordValidationWithCorrectData() {
        try {
        	assertTrue(customerDao.isUserAlreadyExist("suruchi"));
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void customerPasswordValidationWithIncorrectData() {
        try {
            assertFalse(customerDao.isUserAlreadyExist("Drrrrr"));
        } catch (BusinessException e) {
            
        }
    }

}
