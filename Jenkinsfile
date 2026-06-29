pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Debug') {
            steps {
                bat 'dir target'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

  stage('Deploy') {
            steps {
                bat '''
                echo Deploying Spring Boot App...
                copy /Y target\\SBjenkinsTesting-0.0.1-SNAPSHOT.jar C:\\Deployments\\
                '''
            }
        }
        stage('Run Application') {
    steps {
        bat '''
        echo Starting Spring Boot Application...

        start "" java -jar C:\\Deployments\\SBjenkinsTesting-0.0.1-SNAPSHOT.jar
        '''
    }
}

        stage('JUnit Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}