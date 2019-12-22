pipeline {
  agent any
  stages {
    stage('mvn') {
      steps {
        tool(name: 'mvn', type: 'maven')
      }
    }

    stage('error') {
      steps {
        withSonarQubeEnv('sonarqube') {
          sh '/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn/bin/mvn sonar:sonar -Dsonar.java.binaries=target/classes'
        }

      }
    }

  }
}