/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.usage.record;

import com.google.common.collect.Range;
import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

public class LastMonthReader extends Reader<LastMonth> {
    private String accountSid;
    private LastMonth.Category category;
    private DateTime absoluteStartDate;
    private Range<DateTime> rangeStartDate;
    private DateTime absoluteEndDate;
    private Range<DateTime> rangeEndDate;

    /**
     * Construct a new LastMonthReader.
     */
    public LastMonthReader() {
    }

    /**
     * Construct a new LastMonthReader.
     * 
     * @param accountSid The account_sid
     */
    public LastMonthReader(final String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     * The category.
     * 
     * @param category The category
     * @return this
     */
    public LastMonthReader byCategory(final LastMonth.Category category) {
        this.category = category;
        return this;
    }

    /**
     * The absolute_start_date.
     * 
     * @param absoluteStartDate The absolute_start_date
     * @return this
     */
    public LastMonthReader byStartDate(final DateTime absoluteStartDate) {
        this.rangeStartDate = null;
        this.absoluteStartDate = absoluteStartDate;
        return this;
    }

    /**
     * The range_start_date.
     * 
     * @param rangeStartDate The range_start_date
     * @return this
     */
    public LastMonthReader byStartDate(final Range<DateTime> rangeStartDate) {
        this.absoluteStartDate = null;
        this.rangeStartDate = rangeStartDate;
        return this;
    }

    /**
     * The absolute_end_date.
     * 
     * @param absoluteEndDate The absolute_end_date
     * @return this
     */
    public LastMonthReader byEndDate(final DateTime absoluteEndDate) {
        this.rangeEndDate = null;
        this.absoluteEndDate = absoluteEndDate;
        return this;
    }

    /**
     * The range_end_date.
     * 
     * @param rangeEndDate The range_end_date
     * @return this
     */
    public LastMonthReader byEndDate(final Range<DateTime> rangeEndDate) {
        this.absoluteEndDate = null;
        this.rangeEndDate = rangeEndDate;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return LastMonth ResourceSet
     */
    @Override
    public ResourceSet<LastMonth> execute(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage());
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return LastMonth ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<LastMonth> firstPage(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/Usage/Records/LastMonth.json",
            client.getRegion()
        );
        
        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<LastMonth> nextPage(final Page<LastMonth> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of LastMonth Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<LastMonth> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("LastMonth read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Page.fromJson(
            "usage_records",
            response.getContent(),
            LastMonth.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (category != null) {
            request.addQueryParam("Category", category.toString());
        }
        
        if (absoluteStartDate != null) {
            request.addQueryParam("StartDate", absoluteStartDate.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeStartDate != null) {
            request.addQueryDateRange("StartDate", rangeStartDate);
        }
        
        if (absoluteEndDate != null) {
            request.addQueryParam("EndDate", absoluteEndDate.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeEndDate != null) {
            request.addQueryDateRange("EndDate", rangeEndDate);
        }
        
        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}