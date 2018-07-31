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
package com.hms;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * App class will be the main class of the project this will contain an object for the ApplicationContext.
 *
 * @autho sachini de zoysa
 */
public class App {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beansContext.xml", "jettyContext.xml");

    }
}