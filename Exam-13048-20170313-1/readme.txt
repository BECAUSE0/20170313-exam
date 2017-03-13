1,创建(-DarchetypeArtifactId=maven-archetype-webapp)
mvn archetype:generate -DgroupId=com.hand.test -DartifactId=Exam-1 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false -DarchetypeCatalog=internal
2.编译
mvn compile
3.起服务
mvn jetty:run
4.网页运行
http://localhost:8088/
