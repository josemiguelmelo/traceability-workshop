#FROM fluent/fluentd:v1.12.0-debian-arm64-1.0
FROM fluent/fluentd:v1.12.0-1.0
USER root

RUN gem uninstall -I elasticsearch && gem install elasticsearch -v 7.17.0
RUN ["gem", "install", "fluent-plugin-elasticsearch", "--no-document", "--version", "5.0.3"]
USER fluent