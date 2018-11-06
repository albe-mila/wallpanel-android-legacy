package com.thanksmister.iot.wallpanellegacy.network


import android.text.TextUtils
import com.thanksmister.iot.wallpanellegacy.persistence.Configuration
import com.thanksmister.iot.wallpanellegacy.utils.MqttUtils.Companion.TOPIC_COMMAND

import java.util.*
import javax.inject.Inject

class MQTTOptions @Inject
constructor(private val configuration: Configuration) {

    val brokerUrl: String
        get() = if (!TextUtils.isEmpty(getBroker())) {
            if (getBroker().contains("http://") || getBroker().contains("https://")) {
                String.format(Locale.getDefault(), HTTP_BROKER_URL_FORMAT, getBroker(), getPort())
            } else if (getTlsConnection()) {
                String.format(Locale.getDefault(), SSL_BROKER_URL_FORMAT, getBroker(), getPort())
            } else {
                String.format(Locale.getDefault(), TCP_BROKER_URL_FORMAT, getBroker(), getPort())
            }
        } else ""

    val isValid: Boolean
        get() = if (getTlsConnection()) {
            !TextUtils.isEmpty(getBroker()) &&
                    !TextUtils.isEmpty(getClientId()) &&
                    !TextUtils.isEmpty(getBaseTopic()) &&
                    !TextUtils.isEmpty(getUsername()) &&
                    !TextUtils.isEmpty(getStateTopic()) &&
                    !TextUtils.isEmpty(getPassword()) &&
                    configuration.mqttEnabled
        } else !TextUtils.isEmpty(getBroker()) &&
                !TextUtils.isEmpty(getStateTopic()) &&
                !TextUtils.isEmpty(getClientId()) &&
                configuration.mqttEnabled

    fun getBroker(): String {
        return configuration.mqttBroker
    }

    fun getClientId(): String {
        return configuration.mqttClientId
    }

    fun getBaseTopic(): String {
        return configuration.mqttBaseTopic
    }

    fun getStateTopic(): String {
        return getBaseTopic() + TOPIC_COMMAND
    }

    fun getStateTopics(): Array<String> {
        val topics = ArrayList<String>()
        topics.add(getStateTopic())
        return topics.toArray(arrayOf<String>())
    }

    fun getUsername(): String {
        return configuration.mqttUsername
    }

    fun getPassword(): String {
        return configuration.mqttPassword
    }

    fun getPort(): Int {
        return configuration.mqttServerPort
    }

    fun getTlsConnection(): Boolean {
        return configuration.mqttTlsEnabled
    }

    companion object {
        const val SSL_BROKER_URL_FORMAT = "ssl://%s:%d"
        const val TCP_BROKER_URL_FORMAT = "tcp://%s:%d"
        const val HTTP_BROKER_URL_FORMAT = "%s:%d"
    }
}