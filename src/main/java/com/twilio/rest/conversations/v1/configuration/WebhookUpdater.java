/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1.configuration;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

public class WebhookUpdater extends Updater<Webhook> {
    private String method;
    private List<String> filters;
    private String preWebhookUrl;
    private String postWebhookUrl;
    private Webhook.Target target;

    /**
     * The HTTP method to be used when sending a webhook request..
     *
     * @param method The HTTP method to be used when sending a webhook request.
     * @return this
     */
    public WebhookUpdater setMethod(final String method) {
        this.method = method;
        return this;
    }

    /**
     * The list of webhook event triggers that are enabled for this Service:
     * `onMessageAdded`, `onMessageUpdated`, `onMessageRemoved`,
     * `onConversationUpdated`, `onConversationRemoved`, `onParticipantAdded`,
     * `onParticipantUpdated`, `onParticipantRemoved`.
     *
     * @param filters The list of webhook event triggers that are enabled for this
     *                Service.
     * @return this
     */
    public WebhookUpdater setFilters(final List<String> filters) {
        this.filters = filters;
        return this;
    }

    /**
     * The list of webhook event triggers that are enabled for this Service:
     * `onMessageAdded`, `onMessageUpdated`, `onMessageRemoved`,
     * `onConversationUpdated`, `onConversationRemoved`, `onParticipantAdded`,
     * `onParticipantUpdated`, `onParticipantRemoved`.
     *
     * @param filters The list of webhook event triggers that are enabled for this
     *                Service.
     * @return this
     */
    public WebhookUpdater setFilters(final String filters) {
        return setFilters(Promoter.listOfOne(filters));
    }

    /**
     * The absolute url the pre-event webhook request should be sent to..
     *
     * @param preWebhookUrl The absolute url the pre-event webhook request should
     *                      be sent to.
     * @return this
     */
    public WebhookUpdater setPreWebhookUrl(final String preWebhookUrl) {
        this.preWebhookUrl = preWebhookUrl;
        return this;
    }

    /**
     * The absolute url the post-event webhook request should be sent to..
     *
     * @param postWebhookUrl The absolute url the post-event webhook request should
     *                       be sent to.
     * @return this
     */
    public WebhookUpdater setPostWebhookUrl(final String postWebhookUrl) {
        this.postWebhookUrl = postWebhookUrl;
        return this;
    }

    /**
     * The routing target of the webhook..
     *
     * @param target The routing target of the webhook.
     * @return this
     */
    public WebhookUpdater setTarget(final Webhook.Target target) {
        this.target = target;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Webhook
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Webhook update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            "/v1/Configuration/Webhooks"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Webhook update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (method != null) {
            request.addPostParam("Method", method);
        }

        if (filters != null) {
            for (String prop : filters) {
                request.addPostParam("Filters", prop);
            }
        }

        if (preWebhookUrl != null) {
            request.addPostParam("PreWebhookUrl", preWebhookUrl);
        }

        if (postWebhookUrl != null) {
            request.addPostParam("PostWebhookUrl", postWebhookUrl);
        }

        if (target != null) {
            request.addPostParam("Target", target.toString());
        }
    }
}