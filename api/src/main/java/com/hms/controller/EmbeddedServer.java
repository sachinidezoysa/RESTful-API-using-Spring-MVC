/*
 *   (C) Copyright 2017-2018 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */
package com.hms.controller;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Arrays;

/**
 * Server class will hold the details about jettey server
 *
 * @author sachini de zoysa
 */
public class EmbeddedServer {

    private Server server;  //server object

    public EmbeddedServer(String contextPath, int port, Object... resources) {
        server = new Server(port);

        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setContextPath(contextPath);

        ResourceConfig rc = new ResourceConfig();
        Arrays.stream(resources).forEach(rc::register);

        ServletContainer servletContainer = new ServletContainer(rc);
        ServletHolder servletHolder = new ServletHolder(servletContainer);
        contextHandler.addServlet(servletHolder, "/*");

        server.setHandler(contextHandler);
    }

    public void start() throws Exception {
        server.start();  //start server
    }

    public void stop() throws Exception {
        server.stop();  //stop server
    }

    public void join() throws Exception {
        server.join();  //join server
    }
}
