pipeline {
  agent any

  stages {
    stage('Clone') {
      steps {
        git 'https://github.com/armanuralbyice/learnDev.git'
      }
    }

    stage('Deploy') {
      steps {
        sh 'docker-compose down'
        sh 'docker-compose up -d --build'
      }
    }
  }
}