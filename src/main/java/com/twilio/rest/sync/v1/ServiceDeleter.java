/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ServiceDeleter extends Deleter<Service> {
    private final String pathSid;

    /**
     * Construct a new ServiceDeleter.
     *
     * @param pathSid The SID of the Service resource to delete
     */
    public ServiceDeleter(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     *
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Service delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return response.getStatusCode() == 204;
    }
}