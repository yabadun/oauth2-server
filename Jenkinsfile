pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        sh 'clean'
        tool(name: 'sonarqube scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation')
      }
    }

  }
}