package com.project;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PharmapaymentApplicationTests {

	@Test
public	void contextLoads() {
		 final String rawString = "medical";

         

         Base64.Encoder encoder = Base64.getEncoder();

         byte[] encodedContent = encoder.encode(rawString.getBytes());



         Base64.Decoder decoder = Base64.getDecoder();

         byte[] decodedContent = decoder.decode(encodedContent);



         String decodedString = new String(decodedContent);

         assertThat(decodedString, is(rawString));
	}

}
