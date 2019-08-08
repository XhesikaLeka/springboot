pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout-ing project'
                git 'https://github.com/XhesikaLeka/sprintboot'
                echo 'Checkout Success!'
            }
        }
        stage('Build Artifact') {
            steps {
                echo 'Building artifact...'
                sh 'mvn clean install'
                echo 'Success'
            }
        }

       
        stage('Create artifact copy') {
            steps {
                sh 'cp target/springboot-*.jar target/springboot-RELEASE.jar'
            }
        }
        
        stage('Create Docker Image') {
            steps {
                sh 'docker build -t api_springboot_image .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker stop api_springboot'
                sh 'docker rm api_springboot'
                sh 'docker run -d -p 8080:8080 --link config_service:config_service --name api_springboot api_springboot_image'
            }
        }
    }
}
