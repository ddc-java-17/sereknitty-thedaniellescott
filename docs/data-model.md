---
title: Data Model
description: "Unified Modelling Language (UML) class diagram, Entity-relationship diagram (ERD), and Data Definition Language (DDL)."
menu: Data Model
order: 20
uml:
  image: img/uml.svg
  pdf: pdf/uml.pdf
ddl: sql/ddl.sql
erd:
  image: img/erd.svg
  pdf: pdf/erd.pdf
---

{% include ddc-abbreviations.md %}
{% include uml.md %}
{% include erd.md %}
{% include ddl.md %}

## Entity Classes

* [`edu.cnm.deepdive.sereknitty.model.entity.User`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/User.java)
* [`edu.cnm.deepdive.sereknitty.model.entity.Pattern`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/Pattern.java)
* [`edu.cnm.deepdive.sereknitty.model.entity.Row`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/Row.java)
* [`edu.cnm.deepdive.sereknitty.model.entity.RowStitch`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/RowStitch.java)


## DAO Interfaces

* [`edu.cnm.deepdive.sereknitty.model.dao.UserDao`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/User.java)
* [`edu.cnm.deepdive.sereknitty.model.dao.PatternDao`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/Pattern.java)
* [`edu.cnm.deepdive.sereknitty.model.dao.RowDao`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/dao/RowDao.java)
* [`edu.cnm.deepdive.sereknitty.model.dao.RowStitchDao`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/model/dao/RowStitchDao.java)


## DDL

* [`docs.sql.ddl`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/docs/sql/ddl.sql)


## Database

* [`edu.cnm.deepdive.sereknitty.service.SereknittyDatabase`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/service/SereknittyDatabase.java)


## Repositories

* [`edu.cnm.deepdive.sereknitty.service.UserRepository`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/service/UserRepository.java)
* [`edu.cnm.deepdive.sereknitty.service.PatternRepository`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/service/PatternRepository.java)
* [`edu.cnm.deepdive.sereknitty.service.PreferencesRepository`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/service/PreferencesRepository.java)
* [`edu.cnm.deepdive.sereknitty.service.PermissionsRepository`](https://github.com/ddc-java-17/sereknitty-thedaniellescott/blob/main/app/src/main/java/edu/cnm/deepdive/sereknitty/service/PermissionsRepository.java)