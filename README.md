# Labeling System RetCat library

[![build](https://travis-ci.org/mainzed/labelingsystem-retcat.svg?branch=master)](https://travis-ci.org/mainzed/labelingsystem-retcat) [![version](https://img.shields.io/badge/version-1.0--SNAPSHOT-green.svg)](#)  [![java](https://img.shields.io/badge/jdk-1.8-red.svg)](#)  [![maven](https://img.shields.io/badge/maven-3.5.0-orange.svg)](#) [![output](https://img.shields.io/badge/output-jar-red.svg)](#)  [![docs](https://img.shields.io/badge/apidoc-xxx-blue.svg)](#)  [![license](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/mainzed/labelingsystem-retcat/blob/master/LICENSE)

## Prerequisites

The code is developed using and tested with:

* maven 3.5.0
* Netbeans 8.2
* Apache Tomcat 8.0.27.0
* JDK 1.8

## Maven

The `labelingsystem-retcat` library is build using `maven` as JAR-file.

For details have a look at [pom.xml](https://github.com/mainzed/labelingsystem-retcat/blob/master/foolib/pom.xml).

[Download](http://maven.apache.org/download.cgi) and  [install](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) `maven` and [run](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) it.

## Setup

Download and install `maven`.

Run git clone `https://github.com/mainzed/labelingsystem-retcat.git` to create a local copy of this repository.

Run `mvn install` to install all required dependencies.

Run `mvn clean install site` for cleaning, building, testing and generating the documentation files.

Run the jar-file using `mvn exec:java`.

In order to run the Main Class in Netbeans use `Run / Debug`.

Running `mvn test` will run the unit tests with `JUnit`.

## Documentation

Look at [GitHub Pages](#) for the latest developer documentation like `maven` and `javadoc`.

## Developer Hints

Look at [Gist](https://gist.github.com/florianthiery/0f8c0c015555939c96eb13428bbf1cd4) hints for `Configurations for JAVA projects using Maven`.

## Repo Developers

Florian Thiery M.Sc. (RGZM)
