pipeline {
  agent any
  stages {
    stage('mvn') {
      steps {
        tool(name: 'mvn', type: 'maven')
      }
    }

    stage('') {
      steps {
        withSonarQubeEnv('sonarqube') {
          sh 'mvn sonar:sonar'
        }

      }
    }

  }
}