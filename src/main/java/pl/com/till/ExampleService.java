package pl.com.till;

/**
 * {@link Service} with hard-coded input data.
 */
@org.springframework.stereotype.Service
public class ExampleService implements Service {

	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return "Hello world!";
	}

}
