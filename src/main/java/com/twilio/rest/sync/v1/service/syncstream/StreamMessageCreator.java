/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.syncstream;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

public class StreamMessageCreator extends Creator<StreamMessage> {
    private final String pathServiceSid;
    private final String pathStreamSid;
    private final Map<String, Object> data;

    /**
     * Construct a new StreamMessageCreator.
     *
     * @param pathServiceSid The SID of the Sync Service to create the new Stream
     *                       Message in
     * @param pathStreamSid The SID of the Sync Stream to create the new Stream
     *                      Message resource for
     * @param data A JSON string that represents an arbitrary, schema-less object
     *             that makes up the Stream Message body
     */
    public StreamMessageCreator(final String pathServiceSid,
                                final String pathStreamSid,
                                final Map<String, Object> data) {
        this.pathServiceSid = pathServiceSid;
        this.pathStreamSid = pathStreamSid;
        this.data = data;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created StreamMessage
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public StreamMessage create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Streams/" + this.pathStreamSid + "/Messages"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("StreamMessage creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return StreamMessage.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }
    }
}