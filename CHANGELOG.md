```
  _____  _____    _____         ______                                                   _    
 |_   _||  __ \  / ____|       |  ____|                                                 | |   
   | |  | |  | || (___  ______ | |__  _ __  __ _  _ __ ___    ___ __      __ ___   _ __ | | __
   | |  | |  | | \___ \|______||  __|| '__|/ _` || '_ ` _ \  / _ \\ \ /\ / // _ \ | '__|| |/ /
  _| |_ | |__| | ____) |       | |   | |  | (_| || | | | | ||  __/ \ V  V /| (_) || |   |   < 
 |_____||_____/ |_____/        |_|   |_|   \__,_||_| |_| |_| \___|  \_/\_/  \___/ |_|   |_|\_\
```

# Changelog
All notable changes to this project will be documented in this file.

This project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

Versions before 4.0.0 are available on [GitLab](https://gitlab.cc-asp.fraunhofer.de/fhg-isst-ids/ids-framework)

## [5.0.5] - UNRELEASED

### Changes:
- Patch Change: Code refactoring to include more pre-built Lombok functionality

### Dependency Maintenance
- Dependabot: Dependabot will now automatically suggest pull requests for updates to dependencies.
- Upgrade: flatten-maven-plugin 1.1.0 -> 1.2.7
- Upgrade: jacoco-maven-plugin 0.8.5 -> 0.8.7 
- Upgrade: maven-dependency-plugin 3.1.1 -> 3.2.0
- Upgrade: maven-source-plugin 3.2.0 -> 3.2.1
- Upgrade: mockwebserver 4.2.2 -> 4.9.1
- Upgrade: maven-javadoc-plugin 3.1.1 -> 3.3.0
- Upgrade: maven-failsafe-plugin 3.0.0-M3 -> 3.0.0-M5
- Upgrade: versions-maven-plugin 2.5 -> 2.8.1 
- Upgrade: org.projectlombok:lombok 1.18.10 -> 1.18.20
- Upgrade: org.slf4j:slf4j-api 1.7.28 -> 1.7.31
- Upgrade: com.squareup.okhttp3:mockwebserver 4.2.2 -> 4.9.1
- Upgrade: com.squareup.okhttp3:okhttp 4.2.2 -> 4.9.1
- Upgrade: io.netty:netty-common 4.1.43.Final -> 4.1.65.Final
- Upgrade: io.netty:netty-transport 4.1.43.Final -> 4.1.65.Final
- Upgrade: mysql:mysql-connector-java 8.0.18 -> 8.0.25
- Upgrade: org.apache.commons:commons-compress 1.19 -> 1.20
- Upgrade: org.apache.commons:commons-csv 1.7 -> 1.8
- Upgrade: org.apache.poi:poi-ooxml 4.1.1 -> 5.0.0
- Upgrade: org.bitbucket.b_c:jose4j 0.7.0 -> 0.7.8
- Upgrade: org.bouncycastle:bcpkix-fips 1.0.4 -> 1.0.5
- Upgrade: org.eclipse.paho:org.eclipse.paho.client.mqttv3 1.2.2 -> 1.2.5
- Upgrade: org.jooq:jooq 3.12.2 -> 3.15.0
- Upgrade: org.json:json 20190722 -> 20210307
- Upgrade: org.junit.jupiter:junit-jupiter-api 5.5.2 -> 5.7.2
- Upgrade: org.junit.jupiter:junit-jupiter-engine 5.5.2 -> 5.7.2
- Upgrade: org.mapstruct:mapstruct-processor 1.3.1.Final -> 1.4.2.Final
- Upgrade: org.springframework.boot:spring-boot-starter 2.4.3 -> 2.5.2
- Upgrade: org.springframework.boot:spring-boot-starter-test 2.4.3 -> 2.5.2
- Upgrade: com.fasterxml.jackson.core:jackson-databind 2.10.1 -> 2.12.4
- Upgrade: io.springfox:springfox-bean-validators 2.9.2 -> 3.0.0
- Upgrade: io.springfox:springfox-swagger-ui 2.9.2 -> 3.0.0
- Upgrade: io.springfox:springfox-swagger2 2.9.2 -> 3.0.0
- Downgrade: plugins:maven-surefire-plugin to 2.19.1

## [5.0.4] - 2021-06-21

### Patch Change: Infomodel Maintenance
- Used Dependency Version: 4.0.10 (released 2021-06-21)

## [5.0.3] - 2021-06-10

### Patch Change: Infomodel Maintenance
- Used Dependency Version: 4.0.9 (released 2021-06-08)

### Fix
- Patch Change: The DAPS URL is now no longer automatically suffixed with /v2/token. Backward compatibility is ensured in the implementation, therefore no major change.

## [5.0.2] - 2021-06-07

### Changes
- Update Infomodel-Artifacts dependencies 4.0.5 -> 4.0.8

## [5.0.1] - 2021-05-27

### Changes
- Patch Change: Code refactoring

### Fix
- Removed Resource-Payload in ResourceUnavailableMessage to Broker

## [5.0.0] - 2021-04-16
### Major Changes
- Update Infomodel dependency to 4.0.5 - May lead to necessary adjustments to the connector source code, depending on the connector implementation. One use case is known.
- Removed ConfigManager Module: Was not fully implemented, does not belong in an official release.

### Changes
- Patch Change: Code refactoring

### Miscellaneous
- Repo: Conribution-Guideline and Code-of-Conduct files

## [4.0.7] - 2021-03-09
### Changed
- IDSController now accepts messages with empty payloads

## [4.0.6] - 2021-02-28
### Recommended Security Update
- Updated used springframework dependencies

## [4.0.5] - 2021-02-12
### Changed
- Received RejectionMessages are now passed to the connector-developer, regardless of the status of the DAT within the received RejectionMessage

## [4.0.4] - 2021-02-04
### Changed
- Sending an automatic ErrorResponse/RejectionsMessage can now include the message-ID of the rejected message, if it was available

## [4.0.3] - 2021-01-29
### Fixed
- ClientProvider: override read timeout if given

## [4.0.2] - 2021-01-28
### Fixed
- KeyStoreManager: loading  certificates from subpaths in classpath
### Changed
- Minor adjustments to the code in the context of CleanCoding

## [4.0.1] - 2021-01-15
### Fixed
- ErrorResponse can now be created with every RejectionMessage, not just RejectionMessageImpl
### Changed
- Add Project license to every maven module pom
## [4.0.0] - 2021-01-12
### Changed
- IDSController accepts ResponseMessages as incoming IDS Messages
- ConfigurationModel json can be read from absolute path
- Use IDSTruststore and system truststore as trustmanager
- `IDSHttpService` now checks the DAT of a response, `HttpService` can be used for plain HTTP requests
### Removed
- `messaging-core` and `spring-starter` modules removed, merged to `base` and `messaging` modules
## [3.2.3] - 2020-10-19
### Fixed
- Resolving URI Paths, when loading Key- and Truststore from Classpath
### Changed
- JSON Web Key Set parsing in TokenProvider (specify kid with "daps.kid.url" in application properties, or use kid "default")
## [3.2.2] - 2020-10-14
### Fixed
- Fixed a bug in the ConfigurationContainer, which allowed wrong KeyStore paths to be accepted
## [3.2.1] - 2020-09-25
### Fixed
- Parse incoming messages as generic Message, allowing NotificationMessages to be handled by IDSController
## [3.2.0] - 2020-09-23
### Added
- ConfigurationContainer, managing Configuration and rebuilding Key-/Truststore on changes (when using `spring-starter`:
autowire a ConfigurationContainer instead of Connector, ConfigurationModel or KeyStoreManager from now on)
- Add utility for plain GET requests in IDSHttpCommunication/IDSHttpService
### Changed
- Multipart Responses from IDSController in `messaging-spring` now have order _header, payload_
- If ConnectorDeployMode in the current Configuration is set to _TEST_DEPLOYMENT_: DAT Tokens of incoming messages
are ignored
### Removed
- Removed custom DAT token checking using `@DapsVerification` annotation
### Fixed
- Use standard URI Path to File scheme, when parsing Key- and Truststore
## [3.1.0] - 2020-08-24
### Added
- IDSEndpointService for Dynamic configuration of the MessageHandlings Endpoint (in messaging-spring)
### Changed
- TokenManagerService now uses Daps V2 (change the DAPS URL in your application for the URL to a DAPS using v2)
### Removed
- dropped support for DAPS v1 (see Changed)
## [3.0.1] - 2020-08-13
### Fixed
- BrokerCommunication now uses Connector ID instead of ConfigurationModel ID
### Changed
- IDSHttpCommunication send() method now returns the response instead of a boolean (which just returned true if a response was received)
- InfomodelMessageBuilder now creates Messages using static methods instead of builder pattern
### Added
- Added spring-starter module for fast creation of IDS Connectors. The spring starter modules contains
the base, messaging-spring and configmanager modules, provides simple ways to import a configuration from a json
 file and wraps the functionality of the base module (like comminicating with a broker) into Spring services which
 can be autowired and used directly instead of having to create instances of BrokerCommunication for sending
 messages to brokers.
- Add a MultipartStringParser to base module utilities, for parsing the parts from Multipart responses when they are just
provided as a String.
## [3.0.0] - 2020-08-11
### Changed
- Update to Infomodel 4 (ConnectorAvailableMessage&ConnectorUpdateMessage/ConnectorUnavailableMessage&ConnectorInactiveMessage were merged)
- Calls to InactiveAtBroker and RegisterAtBroker have to be changed to Unregister at Broker and UpdateSelfDescriptionAtBroker
- ConfigurationModel from Infomodel 4 replaces the old ConfigModel. Applications using earlier versions of this framework must
change their configuration to an Infomodel ConfigurationModel object when updating to Framework 3.0.0
### Added
- Utility Method to send Resource(Un)AvailableMessage to a Broker
- Utility Method to send UpdateMessage to a List of Brokers asynchronously
- Simple ConfigManager registration in configurationmanager module
## [2.0.13] - 2020-07-16
### Changed
- MessageResponse now contains header (ResponseMessage/NotificationMessage) and payload
- Projects using Messagehandling have to modify their MessageResponses when updating to this version
## [2.0.12] - 2020-06-23
### Added
- use version 3.1.1 of Infomodel serializer and Validator
## [<2.0.12]
_Versions before 2.0.12 are not available in the gitlab repository._

[Unreleased]: https://github.com/FraunhoferISST/IDS-Connector-Framework/compare/master...4.0.3
[4.0.3]: https://github.com/FraunhoferISST/IDS-Connector-Framework/compare/4.0.3...4.0.2
[4.0.2]: https://github.com/FraunhoferISST/IDS-Connector-Framework/compare/4.0.2...4.0.1
[4.0.1]: https://github.com/FraunhoferISST/IDS-Connector-Framework/compare/4.0.1...4.0.0
