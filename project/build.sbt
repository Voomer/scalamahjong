    name := "ScalaMahjong"
     
    version := "0.1"
     
    scalaVersion := "2.10.0"
     
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
     
    libraryDependencies +=
		"com.typesafe.akka" % "akka-actor_2.10" % "2.1.1"
		
	resolvers += "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"

	libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.4"



