pipeline{
    agent any
    stages{
        stage('Build Jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image'){
            steps{
                bat 'docker build -t=haidar123/selenium:latest .'
            }
        }
        stage('Push Image'){
            steps{
                bat "docker push haidar123/selenium"
                bat "docker tag haidar123/selenium:latest haidar123/selenium:${env.BUILD_NUMBER}"
                bat "docker push haidar123/selenium:${env.BUILD_NUMBER}"
            }
        }
    }
}