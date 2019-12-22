pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        withSonarQubeEnv 'sonarqube scanner'
      }
    }

  }
}