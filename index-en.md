---
layout: default
title: Java 8 is Coming
---

### Workshop main goal

This workshop aims to make you programming using the new functionalities of Java 8.

The principle is simple: features were coded in Java 7, you have to use the refactoring improvements from Java 8.
Unit tests pass in java 7, they should always run and pass in Java 8. They exist to assert the iso feature implementation.

Comments with several TODOs will guide you along the exercise.

### Pre-requisites
* Get the last version of the JDK 8 ([http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* Get Git
* Clone the git repository : `git clone https://github.com/ibeauvais/PlayWithJava8.git`
* Configure (if needed) your IDE with the Java 8 compatibility

### 1. Date and Time
**Refactor the Java 7 code into Java 8 code**

* Got the the Git branch named 'step1'
* Modify the methods of DateUtils class : Swith from type **Date** to **LocalDate** (Date without hour) or **LocalDateTime** (Date with hour) based on your needs.
* Use the methods from **java.time** API to refector this code.
* Beware of modify the tests code because sometime method signature changed. The test to refactor are marked by a TODO.

More information : 

 * [http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html](http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html](http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
 * [http://docs.oracle.com/javase/tutorial/datetime/iso/period.html](http://docs.oracle.com/javase/tutorial/datetime/iso/period.html)

Before switch branch, save you version : `git commit -a -m 'step1-end'`

-----------------

### 2. Basic collection enhancement

 **Refactorer le code Java 7 en Java 8  \(Sans utiliser stream\(\)\)**

 * Se connecter à la branche step2 :
     `git checkout step2`
 * Modifier les méthodes de la classe BasicCollectionOperations : Utiliser les méthodes ajoutées dans l'api collection sans passer par les streams

 plus d'infos :

 * [http://docs.oracle.com/javase/8/docs/api/java/util/Collection.html](http://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/util/Map.html](http://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html](http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)


Avant de passer à la suite, sauvegardez votre solution : `git commit -a -m'step2-end' `

-----------------

### 3. Collection Stream
 **Refactorer le code Java 7 en Java 8**

 * Se connecter à la branche step3 :
      `git checkout step3`
 * Refactorer la class UserService.java

 plus d'infos :

  * [Stream Api](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
  * [Optional](http://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
  * [Collectors](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)


Avant de passer à la suite, sauvegardez votre solution : `git commit -a -m'step3-end' `

-----------------

### 4. Others Stream
 **Refactorer le code Java 7 en Java 8**

 * Se connecter à la branche step4 :
      `git checkout step4`
 * Refactorer les class FileUtils.java et NumberUtils.java

 plus d'infos :

   * [File Api](http://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html)
   * [Random Api](http://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
   * [Collectors](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)
   * [Stream Api](http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

  -----------------

