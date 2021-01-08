/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.accounts.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
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
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SecondaryAuthToken extends Resource {
    private static final long serialVersionUID = 162357599411604L;

    /**
     * Create a SecondaryAuthTokenCreator to execute create.
     *
     * @return SecondaryAuthTokenCreator capable of executing the create
     */
    public static SecondaryAuthTokenCreator creator() {
        return new SecondaryAuthTokenCreator();
    }

    /**
     * Create a SecondaryAuthTokenDeleter to execute delete.
     *
     * @return SecondaryAuthTokenDeleter capable of executing the delete
     */
    public static SecondaryAuthTokenDeleter deleter() {
        return new SecondaryAuthTokenDeleter();
    }

    /**
     * Converts a JSON String into a SecondaryAuthToken object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SecondaryAuthToken object represented by the provided JSON
     */
    public static SecondaryAuthToken fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SecondaryAuthToken.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SecondaryAuthToken object using the
     * provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SecondaryAuthToken object represented by the provided JSON
     */
    public static SecondaryAuthToken fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SecondaryAuthToken.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String secondaryAuthToken;
    private final URI url;

    @JsonCreator
    private SecondaryAuthToken(@JsonProperty("account_sid")
                               final String accountSid,
                               @JsonProperty("date_created")
                               final String dateCreated,
                               @JsonProperty("date_updated")
                               final String dateUpdated,
                               @JsonProperty("secondary_auth_token")
                               final String secondaryAuthToken,
                               @JsonProperty("url")
                               final URI url) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.secondaryAuthToken = secondaryAuthToken;
        this.url = url;
    }

    /**
     * Returns The SID of the Account that the secondary Auth Token was created for.
     *
     * @return The SID of the Account that the secondary Auth Token was created for
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The ISO 8601 formatted date and time in UTC when the resource was
     * created.
     *
     * @return The ISO 8601 formatted date and time in UTC when the resource was
     *         created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 formatted date and time in UTC when the resource was
     * last updated.
     *
     * @return The ISO 8601 formatted date and time in UTC when the resource was
     *         last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The generated secondary Auth Token.
     *
     * @return The generated secondary Auth Token
     */
    public final String getSecondaryAuthToken() {
        return this.secondaryAuthToken;
    }

    /**
     * Returns The URI for this resource, relative to `https://accounts.twilio.com`.
     *
     * @return The URI for this resource, relative to `https://accounts.twilio.com`
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SecondaryAuthToken other = (SecondaryAuthToken) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(secondaryAuthToken, other.secondaryAuthToken) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            secondaryAuthToken,
                            url);
    }
}