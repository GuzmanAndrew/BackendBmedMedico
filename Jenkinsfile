pipeline {
  agent { label 'Jenkins-Agent' }
  tools {
    jdk 'Java17'
    maven 'Maven3'
  }
  stages {
    stage("Cleanup Workspace"){
      steps {
        cleanWs()
      }
    }
    stage("Checkout from SCM"){
      steps {
        git branch: 'master', credentialsId: 'github', url: 'https://github.com/GuzmanAndrew/BackendBmedMedico'
      }
    }
    stage("Build Application"){
      steps {
        sh "mvn clean package"
      }
    }
    stage("Test Application"){
      steps {
        sh "mvn test"
      }
    }
    stage("SonarQube Analysis"){
      steps {
        script {
           withSonarQubeEnv(credentialsId: 'jenkins-sonarqube-tokens') {
              sh "mvn sonar:sonar"
           }
        }
      }
    }
  }
}