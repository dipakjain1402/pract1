pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "admin"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from the GitHub repository
                git branch: 'main', url: 'https://github.com/dipakjain1402/pract1'
            }
        }

        stage('Build') {
            steps {
                // Build the application (modify as per your application's build command)
                sh 'mvn clean package' // For Java, or adjust for other languages
            }
        }

        stage('Test') {
            steps {
                // Run tests (modify as per your application's test command)
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    // Build the Docker image
                    sh "docker build -t ${DOCKER_IMAGE}:latest ."
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    // Login to DockerHub (you may need to store DockerHub credentials in Jenkins)
                    docker.withRegistry('', 'docker-hub-credentials') {
                        sh "docker push ${DOCKER_IMAGE}:latest"
                    }
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    // Stop and remove any existing container before running a new one
                    sh "docker stop my_container || true && docker rm my_container || true"
                    // Run the Docker container
                    sh "docker run -d --name my_container -p 8080:8080 ${DOCKER_IMAGE}:latest"
                }
            }
        }
    }
}
