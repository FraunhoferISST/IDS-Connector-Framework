package de.fraunhofer.isst.ids.framework.util;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Properties;

import de.fraunhofer.iais.eis.ConfigurationModel;
import de.fraunhofer.iais.eis.Connector;
import de.fraunhofer.iais.eis.ids.jsonld.Serializer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * Methods to hash and sign.
 * Necessary for IDSMessage.
 */
@Slf4j
@UtilityClass
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IDSUtils {

    static Base64.Encoder ENCODER    = Base64.getEncoder();
    static Serializer     SERIALIZER = new Serializer();

    /**
     * Hash a value with a given MessageDigest.
     *
     * @param digest MessageDigest to hash with
     * @param value  String to hash.
     * @return Hash value of the input String
     */
    public static String hash(final MessageDigest digest, final String value) {
        digest.update(value.getBytes());
        return ENCODER.encodeToString(digest.digest());
    }

    /**
     * Generate a signature over a given String value.
     *
     * @param privateSignature Signature method
     * @param value            String to sign
     * @param privateKey       Private Key to sign with.
     * @return Signature as String
     * @throws InvalidKeyException if the private key is invalid.
     * @throws SignatureException if the signature cannot properly be initialized.
     */
    public static String sign(final Signature privateSignature,
                              final String value,
                              final PrivateKey privateKey) throws InvalidKeyException, SignatureException {
        privateSignature.initSign(privateKey);
        privateSignature.update(value.getBytes());
        return ENCODER.encodeToString(privateSignature.sign());
    }

    /**
     * Takes generic elements and returns them as a ArrayList.
     *
     * @param <T> type of objects in the returned ArrayList
     * @param elements elements to be put in the list
     * @return elements as {@code ArrayList<T>}
     */
    @SafeVarargs
    public static <T> ArrayList<T> asList(final T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    /**
     * Helper Function for accessing Info from pom.xml.
     * <p>
     * See https://stackoverflow.com/a/26573884 and https://stackoverflow.com/a/37358341
     * This will read from the generated file target/classes/.../project.properties
     *
     * @param property like version, artifactID etc
     * @return the pom value
     */
    public static String getProjectProperty(final String property) {
        //read /main/resources/project/properties
        if (log.isDebugEnabled()) {
            log.debug(String.format("Trying to read Property %s from pom.xml properties", property));
        }

        final var properties = new Properties();

        try {
            //For Classloader see https://www.mkyong.com/java/java-getresourceasstream-in-static-method/
            properties.load(Objects.requireNonNull(IDSUtils.class.getClassLoader().getResourceAsStream("project.properties")));
        } catch (IOException e) {
            if (log.isInfoEnabled()) {
                log.info(e.getMessage());
            }
        }

        //get property (might be null if not correct)
        return properties.getProperty(property);
    }

    /**
     * Generates a XML gregorian calendar from the current time.
     *
     * @return XMLGregorianCalendar containing the current time stamp as {@link XMLGregorianCalendar}.
     */
    public static XMLGregorianCalendar getGregorianNow() {
        final var c = new GregorianCalendar();
        c.setTime(new Date());
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            if (log.isInfoEnabled()) {
                log.info(e.getMessage());
            }
        }
        return null;
    }

    /**
     * Get a ConfigurationModel as JsonLD.
     *
     * @param model a ConfigurationModel
     * @return the SelfDeclaration of the configured connector
     * @throws IOException when the connector cannot be serialized
     */
    public static String buildSelfDeclaration(final ConfigurationModel model) throws IOException {
        return SERIALIZER.serialize(model.getConnectorDescription());
    }

    /**
     * Get a Connector as JsonLD.
     *
     * @param model a ConfigurationModel
     * @return the SelfDeclaration of the configured connector
     * @throws IOException when the connector cannot be serialized
     */
    public static String buildSelfDeclaration(final Connector model) throws IOException {
        return SERIALIZER.serialize(model);
    }
}
