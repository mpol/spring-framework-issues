package pl.bug;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"app-test-context.xml"})
public class TestInterceptor {

	@Autowired private IC c;
	@Autowired @Qualifier("c-with-autowired") private ICWithAutoWired cWithAutoWired;
	@Autowired private AnyInterceptor anyInterceptor;
	
	
	@Test
	public void should() throws Exception {
		c.getD();
		cWithAutoWired.getD();
		
		Assert.assertEquals( anyInterceptor.getInvokedBy().size(), 1 );
		Assert.assertEquals( anyInterceptor.getInvokedBy().get(0), C.class.getName());
	}
}
