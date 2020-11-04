/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class ChallengeTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/identity/Challenges");
            request.addPostParam("FactorSid", serialize("YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
            request.addHeaderParam("Twilio-Sandbox-Mode", serialize("twilio_sandbox_mode"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.creator("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").setTwilioSandboxMode("twilio_sandbox_mode").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"status\": \"pending\",\"responded_reason\": \"none\",\"details\": {\"message\": \"Hi! Mr. John Doe, would you like to sign up?\",\"date\": \"2020-07-01T12:13:14Z\",\"fields\": [{\"label\": \"Action\",\"value\": \"Sign up in portal\"}]},\"hidden_details\": {\"ip\": \"172.168.1.234\"},\"factor_type\": \"push\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Challenge.creator("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", "YFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").setTwilioSandboxMode("twilio_sandbox_mode").create();
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/identity/Challenges/YCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            request.addHeaderParam("Twilio-Sandbox-Mode", serialize("twilio_sandbox_mode"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.fetcher("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", "YCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").setTwilioSandboxMode("twilio_sandbox_mode").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchSidResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"status\": \"pending\",\"responded_reason\": \"none\",\"details\": {\"message\": \"Hi! Mr. John Doe, would you like to sign up?\",\"date\": \"2020-07-01T12:13:14Z\",\"fields\": [{\"label\": \"Action\",\"value\": \"Sign up in portal\"}]},\"hidden_details\": {\"ip\": \"172.168.1.234\"},\"factor_type\": \"push\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Challenge.fetcher("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", "YCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").setTwilioSandboxMode("twilio_sandbox_mode").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/identity/Challenges");
            request.addHeaderParam("Twilio-Sandbox-Mode", serialize("twilio_sandbox_mode"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.reader("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").setTwilioSandboxMode("twilio_sandbox_mode").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"challenges\": [],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"challenges\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Challenge.reader("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").setTwilioSandboxMode("twilio_sandbox_mode").read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"challenges\": [{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"status\": \"pending\",\"responded_reason\": \"none\",\"details\": {\"message\": \"Hi! Mr. John Doe, would you like to sign up?\",\"date\": \"2020-07-01T12:13:14Z\",\"fields\": [{\"label\": \"Action\",\"value\": \"Sign up in portal\"}]},\"hidden_details\": {\"ip\": \"172.168.1.234\"},\"factor_type\": \"push\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"challenges\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Challenge.reader("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").setTwilioSandboxMode("twilio_sandbox_mode").read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.VERIFY.toString(),
                                          "/v2/Services/VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Entities/identity/Challenges/YCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            request.addHeaderParam("Twilio-Sandbox-Mode", serialize("twilio_sandbox_mode"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Challenge.updater("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", "YCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").setTwilioSandboxMode("twilio_sandbox_mode").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testVerifySidResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"entity_sid\": \"YEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"ff483d1ff591898a9942916050d2ca3f\",\"factor_sid\": \"YFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"date_responded\": \"2015-07-30T20:00:00Z\",\"expiration_date\": \"2015-07-30T20:00:00Z\",\"status\": \"approved\",\"responded_reason\": \"none\",\"details\": {\"message\": \"Hi! Mr. John Doe, would you like to sign up?\",\"date\": \"2020-07-01T12:13:14Z\",\"fields\": [{\"label\": \"Action\",\"value\": \"Sign up in portal\"}]},\"hidden_details\": {\"ip\": \"172.168.1.234\"},\"factor_type\": \"push\",\"url\": \"https://verify.twilio.com/v2/Services/VAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Entities/ff483d1ff591898a9942916050d2ca3f/Challenges/YCaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Challenge.updater("VAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", "YCXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").setTwilioSandboxMode("twilio_sandbox_mode").update();
    }
}