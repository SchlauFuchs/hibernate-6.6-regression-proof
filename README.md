Proof for Hibernate Regression
------------------------------

This problem occurs since Hibernate 6.6.0 - 6.5.x versions and older should pass the provided unit test.

In <6.6.0 this test passes,
in >=6.6.0 it fails.

The produced error message is:
`Can not get com.ourcompany.jpa.Corporation field com.ourcompany.jpa.CorporationUser.corporation on com.ourcompany.jpa.pk.CorporationUserPK`

Caused by an illegal argument exception in the reflection of the getter.

We tested to change the PK class to use entity types instead of their identifiers, but that did not improve this

to run the test, execute
`./gradlew test`

The to make it fail, change the hibernate version in [gradle\libs.versions.toml](gradle\libs.versions.toml) line 2 and
3, then repeat the command above.

