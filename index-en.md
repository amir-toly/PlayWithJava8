---
layout: default
title: Java 8 is Coming
---

### Workshop main goal

This workshop aims to make you programming using the Java 8 new functionalities.

The principle is simple: features were coded in Java 7, you have to use the refactoring improvements from Java 8.
Unit tests pass in java 7, they always should run and pass in Java 8. They allow to assert the iso feature implementation.

Comments with several TODOs will guide you along exercises.

### Pre-requisites
* Get the JDK 8 last version ([http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* Get Git
* Clone the git repository : `git clone https://github.com/ibeauvais/PlayWithJava8.git`
* Configure (if needed) your IDE with the Java 8 compatibility

### 1. Date and Time
**Refactor the Java 7 code into Java 8 code**

* Get the Git branch named 'step1'
* Modify methods of DateUtils class : Switch from type **Date** to **LocalDate** (Date without hour) or **LocalDateTime** (Date with hour) based on your needs.
* Use methods from **java.time** API to refactor this code.
* Be careful : you'll have to modify some tests because sometime methods signature changed. Tests to refactor are marked by a TODO.

More information :

 * [http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html](http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html](http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
 * [http://docs.oracle.com/javase/tutorial/datetime/iso/period.html](http://docs.oracle.com/javase/tutorial/datetime/iso/period.html)

Before to switch branch, save your version : `git commit -a -m 'step1-end'`

-----------------

### 2. Basic collection enhancement

 **Refactor the Java 7 code into Java 8 code \(without using stream\(\)\)**

 * Checkout the Git branch named step2 : `git checkout step2`
 * Modify methods of BasicCollectionOperations class : Use the added methods in the collection API without using Streams

 More information :

 * [http://docs.oracle.com/javase/8/docs/api/java/util/Collection.html](http://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/util/Map.html](http://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html](http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)

Before to switch branch, save you version : `git commit -a -m'step2-end' `

-----------------

### 3. Collection Stream
 **Refactor the Java 7 code into Java 8 code**

 * Checkout the Git branch named step3 : `git checkout step3`
 * Refactor the UserService class

 More information :

  * [Stream Api](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
  * [Optional](http://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
  * [Collectors](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)


Before to switch branch, save your version : `git commit -a -m'step3-end' `

-----------------

### 4. Others Stream
 **Refactor the Java 7 code into Java 8 code**

 * Checkout the Git branch named step4 : `git checkout step4`
 * Refactor the FileUtils et NumberUtils classes

 More information :

   * [File Api](http://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)
   * [Random Api](http://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
   * [Collectors](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)
   * [Stream Api](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

  -----------------
