package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;

/**
 * Provides basic implementation for the https server.
 */
final class HttpsServer implements WebServer {
    private com.sun.net.httpserver.HttpsServer httpsServer;

    /**
     * Constructs a default https server.
     *
     * @throws Exception when a https server encounters a problem.
     */
    HttpsServer() throws Exception {
        httpsServer = com.sun.net.httpserver.HttpsServer.create();
        httpsServer.bind(new InetSocketAddress(8080), 0);
        httpsServer.createContext("/", exchange -> exchange.sendResponseHeaders(200, 0));
        httpsServer.setExecutor(null);
        httpsServer.setHttpsConfigurator(new HttpsConfigurator(getSSLContext()) {

            /**
             * {@inheritDoc}
             */
            @Override
            public void configure(final HttpsParameters params) {
                try {
                    final var sslContext = SSLContext.getDefault();
                    final var sslEngine = sslContext.createSSLEngine();
                    params.setNeedClientAuth(false);
                    params.setCipherSuites(sslEngine.getEnabledCipherSuites());
                    params.setProtocols(sslEngine.getEnabledProtocols());
                    params.setSSLParameters(sslContext.getDefaultSSLParameters());
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebServer start() {
        httpsServer.start();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        httpsServer.stop(0);
    }

    private SSLContext getSSLContext() throws Exception {
        final var keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("./etc/tutorial.keystore"), "password".toCharArray());
        final var keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, "password".toCharArray());
        final var trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
        trustManagerFactory.init(keyStore);
        final var sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        return sslContext;
    }
}
