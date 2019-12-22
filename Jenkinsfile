pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        withSonarQubeEnv 'oauth2'
      }
    }

  }
}