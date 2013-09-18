package com.twilio.sdk.verbs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SipTest {

    /**
     * Test the SIP noun with a text element representing the URI.
     */
    @Test
    public void testBasicSip() {
        Sip sip = new Sip("sip:alice@twilio.com;transport=udp");
        assertEquals("<Sip>sip:alice@twilio.com;transport=udp</Sip>", sip.toXML());
    }

    /**
     * Test the SIP noun with a child URI noun.
     * @throws TwiMLException
     */
    @Test
    public void testSipUriNoun() throws TwiMLException {
        Sip sip = new Sip();
        Uri uri = new Uri("sip:alice@twilio.com;transport=udp");
        uri.setUsername("alice");
        uri.setPassword("hellotwilio");
        sip.append(uri);
        assertEquals("<Sip><Uri username=\"alice\" password=\"hellotwilio\">sip:alice@twilio.com;transport=udp</Uri></Sip>",
                sip.toXML());
    }
}
