pipeline{
	agent any

    stages {
        stage('Initialize') {
            steps {
                bat '''
                    echo "PATH = %PATH%"
                    echo "M2_HOME = %M2_HOME%"
                '''
            }
        }
        stage('Cloning Git') {
            steps {
                git(
                     url: 'https://github.com/ahmed-lou93/training.git',
                     credentialsId: 'jenkins-private-pat'
                )
            }
        }
        stage("build") {
            steps {
                echo 'Clean Build'
                bat 'mvn clean compile'
            }
        }
        
    }
	
}