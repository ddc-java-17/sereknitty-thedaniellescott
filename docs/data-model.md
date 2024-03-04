---
title: Data Model
description: "Entity-relationship diagram and DDL."
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

* [`edu.cnm.deepdive.sereknitty.model.entity.Pattern`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/Pattern.java)
* [`edu.cnm.deepdive.sereknitty.model.entity.User`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/User.java)
* [`edu.cnm.deepdive.sereknitty.model.entity.PatternManager`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/PatternManager.java)
* [`edu.cnm.deepdive.sereknitty.model.entity.StitchLocation`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/entity/StitchLocation.java)

## DAO Interfaces

* [`edu.cnm.deepdive.sereknitty.model.dao.UserDao`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/dao/UserDao.java)
* [`edu.cnm.deepdive.sereknitty.model.dao.PatternDao`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/dao/PatternDao.java)
* [`edu.cnm.deepdive.sereknitty.model.dao.PatternManagerDao`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/dao/PatternManagerDao.java)
* [`edu.cnm.deepdive.sereknitty.model.dao.StitchLocationDao`](app/src/main/java/edu/cnm/deepdive/sereknitty/model/dao/StitchLocationDao.java)