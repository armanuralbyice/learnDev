pipeline {
    agent any

    environment {
        EC2_USER = 'ubuntu'
        EC2_HOST = '3.107.235.199'
        APP_DIR  = '/home/ubuntu/app'
    }

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/armanuralbyice/learnDev.git', branch: 'main'
            }
        }

        stage('Trust EC2 Host') {
            steps {
                sh """
                mkdir -p ~/.ssh
                ssh-keyscan -H ${EC2_HOST} >> ~/.ssh/known_hosts
                """
            }
        }

        stage('Copy to EC2') {
            steps {
                sh """
                scp -o StrictHostKeyChecking=no -r * ${EC2_USER}@${EC2_HOST}:${APP_DIR}
                """
            }
        }

        stage('Docker Cleanup on EC2') {
            steps {
                sh """
                ssh ${EC2_USER}@${EC2_HOST} "
                    sudo docker system prune -a -f --volumes || true &&
                    sudo docker builder prune -a -f || true
                "
                """
            }
        }

        stage('Deploy on EC2') {
            steps {
                sh """
                ssh ${EC2_USER}@${EC2_HOST} "
                    cd ${APP_DIR} &&
                    docker compose down || true &&
                    docker compose up --build -d
                "
                """
            }
        }
    }

    post {
        success {
            echo "🚀 Deployment Successful on EC2"
        }
        failure {
            echo "❌ Deployment Failed"
        }
    }
}
