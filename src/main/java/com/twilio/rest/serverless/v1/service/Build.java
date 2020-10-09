/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Build extends Resource {
    private static final long serialVersionUID = 112894986851836L;

    public enum Status {
        BUILDING("building"),
        COMPLETED("completed"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    /**
     * Create a BuildReader to execute read.
     *
     * @param pathServiceSid The SID of the Service to read the Build resources from
     * @return BuildReader capable of executing the read
     */
    public static BuildReader reader(final String pathServiceSid) {
        return new BuildReader(pathServiceSid);
    }

    /**
     * Create a BuildFetcher to execute fetch.
     *
     * @param pathServiceSid The SID of the Service to fetch the Build resource from
     * @param pathSid The SID of the Build resource to fetch
     * @return BuildFetcher capable of executing the fetch
     */
    public static BuildFetcher fetcher(final String pathServiceSid,
                                       final String pathSid) {
        return new BuildFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a BuildDeleter to execute delete.
     *
     * @param pathServiceSid The SID of the Service to delete the Build resource
     *                       from
     * @param pathSid The SID of the Build resource to delete
     * @return BuildDeleter capable of executing the delete
     */
    public static BuildDeleter deleter(final String pathServiceSid,
                                       final String pathSid) {
        return new BuildDeleter(pathServiceSid, pathSid);
    }

    /**
     * Create a BuildCreator to execute create.
     *
     * @param pathServiceSid The SID of the Service to create the Build resource
     *                       under
     * @return BuildCreator capable of executing the create
     */
    public static BuildCreator creator(final String pathServiceSid) {
        return new BuildCreator(pathServiceSid);
    }

    /**
     * Converts a JSON String into a Build object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Build object represented by the provided JSON
     */
    public static Build fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Build.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Build object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Build object represented by the provided JSON
     */
    public static Build fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Build.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final Build.Status status;
    private final List<Map<String, Object>> assetVersions;
    private final List<Map<String, Object>> functionVersions;
    private final List<Map<String, Object>> dependencies;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Build(@JsonProperty("sid")
                  final String sid,
                  @JsonProperty("account_sid")
                  final String accountSid,
                  @JsonProperty("service_sid")
                  final String serviceSid,
                  @JsonProperty("status")
                  final Build.Status status,
                  @JsonProperty("asset_versions")
                  final List<Map<String, Object>> assetVersions,
                  @JsonProperty("function_versions")
                  final List<Map<String, Object>> functionVersions,
                  @JsonProperty("dependencies")
                  final List<Map<String, Object>> dependencies,
                  @JsonProperty("date_created")
                  final String dateCreated,
                  @JsonProperty("date_updated")
                  final String dateUpdated,
                  @JsonProperty("url")
                  final URI url,
                  @JsonProperty("links")
                  final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.status = status;
        this.assetVersions = assetVersions;
        this.functionVersions = functionVersions;
        this.dependencies = dependencies;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The unique string that identifies the Build resource.
     *
     * @return The unique string that identifies the Build resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Account that created the Build resource.
     *
     * @return The SID of the Account that created the Build resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The SID of the Service that the Build resource is associated with.
     *
     * @return The SID of the Service that the Build resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The status of the Build.
     *
     * @return The status of the Build
     */
    public final Build.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The list of Asset Version resource SIDs that are included in the
     * Build.
     *
     * @return The list of Asset Version resource SIDs that are included in the
     *         Build
     */
    public final List<Map<String, Object>> getAssetVersions() {
        return this.assetVersions;
    }

    /**
     * Returns The list of Function Version resource SIDs that are included in the
     * Build.
     *
     * @return The list of Function Version resource SIDs that are included in the
     *         Build
     */
    public final List<Map<String, Object>> getFunctionVersions() {
        return this.functionVersions;
    }

    /**
     * Returns A list of objects that describe the Dependencies included in the
     * Build.
     *
     * @return A list of objects that describe the Dependencies included in the
     *         Build
     */
    public final List<Map<String, Object>> getDependencies() {
        return this.dependencies;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Build resource was
     * created.
     *
     * @return The ISO 8601 date and time in GMT when the Build resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the Build resource was last
     * updated.
     *
     * @return The ISO 8601 date and time in GMT when the Build resource was last
     *         updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the Build resource.
     *
     * @return The absolute URL of the Build resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The links.
     *
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Build other = (Build) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(status, other.status) &&
               Objects.equals(assetVersions, other.assetVersions) &&
               Objects.equals(functionVersions, other.functionVersions) &&
               Objects.equals(dependencies, other.dependencies) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            status,
                            assetVersions,
                            functionVersions,
                            dependencies,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }
}