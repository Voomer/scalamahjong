    name := "ScalaMahjong"
     
    version := "0.1"
     
    scalaVersion := "2.10.0"
     
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
	
	resolvers += "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"
	
	resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases")
	
	EclipseKeys.withSource := true
	
    libraryDependencies ++=Seq (
		"com.typesafe.akka" % "akka-actor_2.10" % "2.1.1",
		"org.scalaz" %% "scalaz-core" % "6.0.4",
		"org.specs2" %% "specs2" % "1.14" % "test",
		"org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test",
		"junit" % "junit" % "4.7"
	)



