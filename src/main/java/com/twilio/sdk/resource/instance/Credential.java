package com.twilio.sdk.resource.instance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.InstanceResource;


public class Credential extends InstanceResource {

    /** The Constant SID_PROPERTY. */
    private static final String SID_PROPERTY = "sid";
    private String requestCredentialListSid;

    /**
     * Instantiates a new Credential.
     *
     * @param client the client
     */
     public Credential(TwilioRestClient client) {
         super(client);
     }

     /**
      * Instantiates a new Credential.
      *
      * @param client the client
      * @param sid the sid
      */
     public Credential(TwilioRestClient client, String credentialListSid, String sid) {
         super(client);
         if (sid == null) {
             throw new IllegalStateException("The Sid for a Credential can not be null");
         }
         this.setProperty(SID_PROPERTY, sid);
         this.requestCredentialListSid = credentialListSid;
     }

	/**
	 * Instantiates a new Credential.
	 *
	 * @param client the client
	 * @param properties the properties
	 */
	public Credential(TwilioRestClient client, Map<String, Object> properties) {
		super(client, properties);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.Resource#getResourceLocation()
	 */
	@Override
	protected String getResourceLocation() {
		return "/" + TwilioRestClient.DEFAULT_VERSION
            + "/Accounts/" + this.getRequestAccountSid()
            + "/SIP/CredentialLists/" + this.getRequestCredentialListSid()
            + "/Credentials/" + this.getSid()
            + ".json";
	}

	/*
	 * Property getters
	 */

	/**
	 * Gets the sid.
	 *
	 * @return the sid
	 */
	public String getSid() {
		return this.getProperty(SID_PROPERTY);
	}

	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public Date getDateCreated() {
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss Z");
		try {
			return format.parse(this.getProperty("date_created"));
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Gets the date updated.
	 *
	 * @return the date updated
	 */
	public Date getDateUpdated() {
		SimpleDateFormat format = new SimpleDateFormat(
				"EEE, dd MMM yyyy HH:mm:ss Z");
		try {
			return format.parse(this.getProperty("date_updated"));
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Gets the account sid.
	 *
	 * @return the account sid
	 */
	public String getAccountSid() {
		return this.getProperty("account_sid");
	}

	/**
	 * Gets the username
	 *
	 * @return the account sid
	 */
	public String getUsername() {
		return this.getProperty("username");
	}

    /**
     * Gets the sid of the parent credential list
     *
     * @return the credential list sid
     */
    public String getRequestCredentialListSid() {
        return this.requestCredentialListSid;
    }

    /**
     * Delete this {@link Credential}.
     * @throws TwilioRestException
     *             if there is an error in the request
     * @return true, if successful
     *
     */
    public boolean delete() throws TwilioRestException {
        TwilioRestResponse response = this.getClient().safeRequest(
                this.getResourceLocation(), "DELETE", null);

        return !response.isError();
    }
}
