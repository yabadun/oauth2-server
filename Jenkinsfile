pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        withSonarQubeEnv('sonarqube') {
          sh 'mvn clean package sonar:sonar'
        }

        tool(name: 'mvn', type: 'maven')
      }
    }

  }
}