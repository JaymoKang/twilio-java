/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.syncstream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class StreamMessage extends Resource {
    private static final long serialVersionUID = 144642288348060L;

    /**
     * Create a StreamMessageCreator to execute create.
     *
     * @param pathServiceSid The SID of the Sync Service to create the new Stream
     *                       Message in
     * @param pathStreamSid The SID of the Sync Stream to create the new Stream
     *                      Message resource for
     * @param data A JSON string that represents an arbitrary, schema-less object
     *             that makes up the Stream Message body
     * @return StreamMessageCreator capable of executing the create
     */
    public static StreamMessageCreator creator(final String pathServiceSid,
                                               final String pathStreamSid,
                                               final Map<String, Object> data) {
        return new StreamMessageCreator(pathServiceSid, pathStreamSid, data);
    }

    /**
     * Converts a JSON String into a StreamMessage object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return StreamMessage object represented by the provided JSON
     */
    public static StreamMessage fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, StreamMessage.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a StreamMessage object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return StreamMessage object represented by the provided JSON
     */
    public static StreamMessage fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, StreamMessage.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final Map<String, Object> data;

    @JsonCreator
    private StreamMessage(@JsonProperty("sid")
                          final String sid,
                          @JsonProperty("data")
                          final Map<String, Object> data) {
        this.sid = sid;
        this.data = data;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns Stream Message body.
     *
     * @return Stream Message body
     */
    public final Map<String, Object> getData() {
        return this.data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StreamMessage other = (StreamMessage) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            data);
    }
}