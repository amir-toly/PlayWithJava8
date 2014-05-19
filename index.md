---
layout: default
title: Java 8 is Coming
---

### Objectif de l'atelier

Cet atelier a pour objectif de vous faire coder en utilisant les nouvelles fonctionnalitées de Java 8.

Le principe est simple : des fonctionnalités ont été codées en Java 7, à vous des les refactorer pour utiliser les améliorations de Java 8.
Les tests unitaires passent en java 7, ils doivent toujours passer en Java 8. Ils sont la pour vérifier l'iso fonctionnalité de l'implémentation.

Des commentaires avec des TODO sont la pour vous aiguiller.

### Pre-requis
* Avoir le jdk 8 dernière version d'installé ([http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* Avoir git
* cloner le repository : `git clone https://github.com/ibeauvais/PlayWithJava8.git`
* Si besoin régler votre IDE afin que le projet soit configuré avec la compatibilité java 8

### 1. Date and Time
**Refactorer le code Java 7 en Java 8**

* Vous devez être sur la branche step1
* Modifier les méthodes de la classe DateUtils : Remplacer le type **Date** par **LocalDate** (Date sans heure) ou **LocalDateTime** (Date avec heure) en fonction du besoin.
* Utiliser les méthodes de l'api **java.time** pour refactorer ce code.
* Attention pour cette step il faut dans certains cas modifier également les tests car la signature de la méthode change. Chaque changement de test est marqué d'un TODO.

Plus d'infos : 

 * [http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html](http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)
 * [http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html](http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
 * [http://docs.oracle.com/javase/tutorial/datetime/iso/period.html](http://docs.oracle.com/javase/tutorial/datetime/iso/period.html)

Avant de passer à la suite, sauvegardez votre solution : `git commit -a -m'step1-end' `

-----------------
### 2. Basic collection enhancement
 **Refactorer le code Java 7 en Java 8**  (Sans utiliser stream())

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

