package com.example.mqttlibray;

/**
 * Created by dell on 2019/6/12.
 */

public class ConfigMqqtBean {
    Builder builder;
    private ConfigMqqtBean(Builder builder){
        this.builder=builder;
    }
    public String getHost() {
        return builder.host;
    }


    public String getUsername() {
        return builder.username;
    }


    public String getPassword() {
        return builder.password;
    }


    public String getResponse_topic() {
        return builder.response_topic;
    }


    public String getPublish_topic() {
        return builder.publish_topic;
    }


    public String getClientid() {
        return builder.clientid;
    }



    private String host;
    private String username;
    private String password;
    private String response_topic;
    private String publish_topic;
    private String clientid;

    public static class Builder {

        private String host;
        private String username;
        private String password;

        public  Builder(){
        }

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setResponse_topic(String response_topic) {
            this.response_topic = response_topic;
            return this;
        }

        public Builder setPublish_topic(String publish_topic) {
            this.publish_topic = publish_topic;
            return this;
        }

        public Builder setClientid(String clientid) {
            this.clientid = clientid;
            return this;
        }

        private String response_topic;
        private String publish_topic;
        private String clientid;
        public ConfigMqqtBean build() {
            return new ConfigMqqtBean(this);
        }
    }
}
